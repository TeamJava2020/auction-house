package team.java.auction.house.mapper;

import org.springframework.stereotype.Component;
import team.java.auction.house.domain.UserEntity;
import team.java.auction.house.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements Mapper<UserDTO,UserEntity> {

    public List<UserDTO> mapToUserDtoList(List<UserEntity> users) {
        List<UserDTO> usersDTO = new ArrayList<>();
        users.forEach(user -> usersDTO.add(toDto(user)));
        return usersDTO;
    }

    @Override
    public UserDTO toDto(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getLogin(),
                userEntity.getPassword()
        );
    }

    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        return new UserEntity(
                userDTO.getUserName(),
                userDTO.getLogin(),
                userDTO.getPassword()
        );
    }
}
