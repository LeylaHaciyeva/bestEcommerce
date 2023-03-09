package az.code.sellingbackend.repo;

import java.util.Optional;

import az.code.sellingbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}