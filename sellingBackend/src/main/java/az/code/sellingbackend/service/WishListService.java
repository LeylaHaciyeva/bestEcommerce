package az.code.sellingbackend.service;

import az.code.sellingbackend.dto.ProductDto;
import az.code.sellingbackend.entity.User;
import az.code.sellingbackend.entity.WishList;
import az.code.sellingbackend.repo.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {
    @Autowired
    WishListRepo wishListRepo;
@Autowired
ProductService productService;
    public void createWishList(WishList wishList) {
        wishListRepo.save(wishList);
    }

    public List<ProductDto> getWishListForUser(User user) {
        final List<WishList> wishlists=  wishListRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDto> products= new ArrayList<>();
        for(WishList wishlist:wishlists){
            products.add(productService.getProductDto(wishlist.getProduct()));
        }
        return products;
    }
}
