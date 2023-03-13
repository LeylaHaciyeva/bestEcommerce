package az.code.sellingbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wishlist")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

   @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
   @JoinColumn(name = "user_id")
   private User user;

   @Column(name="created_date")
    private Date createdDate;
   @ManyToOne
   @JoinColumn(name = "product_id")
    private Product product;

    public WishList(User user, Product product) {
        this.product=product;
        this.user=user;
        this.createdDate=new Date();
    }
}
