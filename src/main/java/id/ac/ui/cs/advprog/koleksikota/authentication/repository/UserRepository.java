package id.ac.ui.cs.advprog.koleksikota.authentication.repository;

import id.ac.ui.cs.advprog.koleksikota.authentication.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findbyUsername(String username);
    Boolean existsByUsername(String Username);
}
