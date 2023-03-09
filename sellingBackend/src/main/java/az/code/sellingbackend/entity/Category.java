package az.code.sellingbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Slf4j
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "category_name")
    private @NotBlank String categoryName;

    private @NotBlank String description;

    private @NotBlank String imageUrl;


}
