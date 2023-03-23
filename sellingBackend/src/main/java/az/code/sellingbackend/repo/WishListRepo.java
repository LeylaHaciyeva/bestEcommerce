package az.code.sellingbackend.repo;

import az.code.sellingbackend.entity.User;
import az.code.sellingbackend.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepo extends JpaRepository<WishList,Integer> {
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);

    WishList findWishListsById(Integer itemId);

}
