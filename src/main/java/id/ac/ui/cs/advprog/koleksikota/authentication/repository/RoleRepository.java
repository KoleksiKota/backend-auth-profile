package id.ac.ui.cs.advprog.koleksikota.authentication.repository;

import id.ac.ui.cs.advprog.koleksikota.authentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
