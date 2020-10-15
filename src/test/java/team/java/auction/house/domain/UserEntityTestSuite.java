package team.java.auction.house.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import team.java.auction.house.repository.UserRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTestSuite {

    @Autowired
    private UserRepository userEntityRepository;

    @Test
    public void testAddingSingleUserToUserEntity(){
        //given
        UserEntity user = new UserEntity("name", "login", "password");

        //when
        userEntityRepository.save(user);
        long id = user.getId();

        //then
        assertNotEquals(0L, id);
    }
}

