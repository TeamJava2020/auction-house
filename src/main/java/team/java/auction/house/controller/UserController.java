package team.java.auction.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.UserEntity;
import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.Response;
import team.java.auction.house.dto.UserDTO;
import team.java.auction.house.mapper.UserMapper;
import team.java.auction.house.repository.UserRepository;
import team.java.auction.house.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public Response<List<UserDTO>> getUsers() {
        List<UserEntity> users = userService.getAllUsers();
        List<UserDTO> data = userMapper.mapToUserDtoList(users);
        return data.isEmpty() ? createNoDataResponse() : createOkResponse(data);
    }

    @GetMapping
    public Response<UserDTO> getUser(@RequestBody UserDTO userDto) {
        Optional<UserEntity> user = userService.findUserByLogin(userDto.getLogin());
        if (user.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return (user.get().getPassword().equals(userDto.getPassword())) ? createOkResponse(userMapper.toDto(user.get())) //
                    : createErrorResponse(new ErrorMessage(401, "Podane hasło jest nieprawidłowe!", date));
        }
        return createNoDataResponse();
    }

    @PostMapping
    public Response<UserDTO> createUser(@RequestBody UserDTO userDto) {
        Optional<UserEntity> user = userService.findUserByLogin(userDto.getLogin());
        if (user.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return createErrorResponse(new ErrorMessage(409, "Podany login już istnieje!", date));
        }
        userService.saveUser(userMapper.toEntity(userDto));
        return createOkResponse();
    }

    @DeleteMapping
    public Response<UserDTO> deleteUser( @RequestParam("userId") Long userId) {
        Optional<UserEntity> user = userService.findUserById(userId);
        if (!user.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return createErrorResponse(new ErrorMessage(401, "Podane id nie istnieje!", date));
        }
        userService.deleteUser(user.get());
        return createOkResponse();
    }

    public <T> Response<T> createNoDataResponse() {
        return Response.<T>builder().status(Response.Status.NO_DATA).build();
    }

    public <T> Response<T> createOkResponse(T data) {
        return Response.<T>builder().status(Response.Status.OK).data(data).build();
    }

    public <T> Response<T> createOkResponse() {
        return Response.<T>builder().status(Response.Status.OK).build();
    }

    public <T> Response<T> createErrorResponse(ErrorMessage errorMessage) {
        return Response.<T>builder().status(Response.Status.ERROR).error(errorMessage).build();
    }
}
