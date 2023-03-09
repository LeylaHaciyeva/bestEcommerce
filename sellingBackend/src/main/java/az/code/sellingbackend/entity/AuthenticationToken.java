package az.code.sellingbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Slf4j
@Table(name = "token")
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String token;
    @Column(name = "created_date")
    private Date createdDate;
    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name="user_id")
    private User user;

}
