package az.code.sellingbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private @NotNull Integer id;
    private @NotNull String productName;
    private @NotNull String productDesc;
    private @NotNull double productPrice;
    private @NotNull String productImage;
    private @NotNull Integer categoryId;
}
