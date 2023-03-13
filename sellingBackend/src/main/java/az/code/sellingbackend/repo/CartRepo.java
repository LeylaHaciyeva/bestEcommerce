package az.code.sellingbackend.repo;

import az.code.sellingbackend.entity.Cart;
import az.code.sellingbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
