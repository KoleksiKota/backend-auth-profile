package id.ac.ui.cs.advprog.koleksikota.authentication.repository;

import id.ac.ui.cs.advprog.koleksikota.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}