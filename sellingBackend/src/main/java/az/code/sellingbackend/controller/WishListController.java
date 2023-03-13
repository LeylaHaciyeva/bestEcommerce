package az.code.sellingbackend.controller;

import az.code.sellingbackend.dto.ProductDto;
import az.code.sellingbackend.entity.Product;
import az.code.sellingbackend.entity.User;
import az.code.sellingbackend.entity.WishList;
import az.code.sellingbackend.service.AuthenticationTokenService;
import az.code.sellingbackend.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "wishlist", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class WishListController {
    @Autowired
    WishListService wishListService;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addToWishList(@RequestBody Product product,
                                                    @RequestParam("token") String token) throws Exception {
        authenticationTokenService.authentication(token);
        User user = authenticationTokenService.getUser(token);
        WishList wishList = new WishList(user, product);
        wishListService.createWishList(wishList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{token}")

    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) throws Exception {
        authenticationTokenService.authentication(token);
        User user = authenticationTokenService.getUser(token);
       List<ProductDto> productDtos= wishListService.getWishListForUser(user);
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }
}
