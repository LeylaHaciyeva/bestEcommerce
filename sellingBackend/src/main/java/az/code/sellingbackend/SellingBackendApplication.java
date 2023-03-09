package az.code.sellingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EntityScan({"az.code.sellingbackend.dto","az.code.sellingbackend.entity"})
public class SellingBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(SellingBackendApplication.class, args);
    }
}
