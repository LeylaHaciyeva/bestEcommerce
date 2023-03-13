package az.code.sellingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    List<CartItemDto> cartItemDtoList;
    private double total;
}
