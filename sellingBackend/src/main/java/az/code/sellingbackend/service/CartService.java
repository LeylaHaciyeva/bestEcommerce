package az.code.sellingbackend.service;

import az.code.sellingbackend.dto.AddToCartDto;
import az.code.sellingbackend.dto.CartDto;
import az.code.sellingbackend.dto.CartItemDto;
import az.code.sellingbackend.entity.Cart;
import az.code.sellingbackend.entity.Product;
import az.code.sellingbackend.entity.User;
import az.code.sellingbackend.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductService productService;

    public void addToCart(AddToCartDto addToCartDto, User user) throws Exception {
        Product product = productService.findById(addToCartDto.getProductId());
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setProduct(product);
        cart.setCreatedDate(new Date());
        cartRepo.save(cart);
    }

    public CartDto getCartItems(User user) {
        List<Cart> cartList = cartRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        double total = 0;
        for (Cart cart : cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            total += cartItemDto.getQuantity() + cart.getProduct().getProductPrice();
            cartItemDtos.add(cartItemDto);
        }
        CartDto cartDto = new CartDto();
        cartDto.setTotal(total);
        cartDto.setCartItemDtoList(cartItemDtos);
        return cartDto;
    }

    public void deleteCartItem(Integer itemId, User user) throws Exception {
        Optional<Cart> optCart=cartRepo.findById(itemId);
        if(optCart.isEmpty()){
            throw  new Exception("invalid id");
        }
        Cart cart =optCart.get();
        if(optCart.get().getUser() !=user){
            throw new Exception("cart item does not belong to user");
        }
        cartRepo.delete(cart);
    }
}
