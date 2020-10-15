package team.java.auction.house.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import team.java.auction.house.domain.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Override
    UserEntity save(UserEntity order);

    Optional<UserEntity> findByUserName(String userName);
}