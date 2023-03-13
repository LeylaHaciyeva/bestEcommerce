package az.code.sellingbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class CheckoutItemDto implements Serializable {


    private String productName;

    private int quantity;

    private  double price;

    private long productId;

    private int userId;


}
