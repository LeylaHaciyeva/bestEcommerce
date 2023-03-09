package az.code.sellingbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Slf4j
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private @NotNull Integer id;
    private @NotNull String productName;
    private @NotNull String productDesc;
    private @NotNull double productPrice;
    private @NotNull String productImage;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category productCategory;


}