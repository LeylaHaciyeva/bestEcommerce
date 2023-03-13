package az.code.sellingbackend.dto;

import az.code.sellingbackend.entity.Cart;
import az.code.sellingbackend.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Product product;

    public CartItemDto(Cart cart) {
        this.id=cart.getId();
        this.quantity=cart.getQuantity();
        this.setProduct(cart.getProduct());
    }
}
