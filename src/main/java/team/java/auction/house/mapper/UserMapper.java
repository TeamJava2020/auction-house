package team.java.auction.house.mapper;

import org.springframework.stereotype.Component;
import team.java.auction.house.domain.UserEntity;
import team.java.auction.house.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public List<UserDTO> mapToUserDtoList(List<UserEntity> users) {
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> usersDTO.add(mapToUserDto(user)));
        return usersDTO;
    }

    public UserDTO mapToUserDto(UserEntity user) {
        return new UserDTO(user.getId(), user.getUserName(), user.getLogin(), user.getPassword());
    }

    public UserEntity mapToUser(UserDTO userDto) {
        return new UserEntity(userDto.getUserName(), userDto.getLogin(), userDto.getPassword());
    }
}
