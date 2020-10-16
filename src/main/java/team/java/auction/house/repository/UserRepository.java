package team.java.auction.house.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import team.java.auction.house.domain.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    @Override
    UserEntity save(UserEntity order);

    @Override
    List<UserEntity> findAll();

    @Override
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByLogin(String login);
}