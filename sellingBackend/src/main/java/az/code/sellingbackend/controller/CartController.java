package az.code.sellingbackend.controller;

import az.code.sellingbackend.dto.AddToCartDto;
import az.code.sellingbackend.dto.CartDto;
import az.code.sellingbackend.entity.User;
import az.code.sellingbackend.service.AuthenticationTokenService;
import az.code.sellingbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping(value = "cart", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    AuthenticationTokenService authenticationTokenService;
@PostMapping("/add")

    public ResponseEntity<HttpStatus> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                @RequestParam("token") String token) throws Exception {
        authenticationTokenService.authentication(token);
        User user = authenticationTokenService.getUser(token);
        cartService.addToCart(addToCartDto, user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws Exception {
        authenticationTokenService.authentication(token);
        User user = authenticationTokenService.getUser(token);
        CartDto cartDto= cartService.getCartItems(user);
        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<HttpStatus> deleteCartItem(
            @PathVariable("cartItemId") Integer itemId,
            @RequestParam("token") String token) throws Exception {
        authenticationTokenService.authentication(token);
        User user = authenticationTokenService.getUser(token);
        cartService.deleteCartItem(itemId,user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
