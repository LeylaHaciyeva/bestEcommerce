package az.code.sellingbackend.repo;
import az.code.sellingbackend.dto.ProductDto;
import az.code.sellingbackend.entity.Contact;
import az.code.sellingbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Integer> {
}
