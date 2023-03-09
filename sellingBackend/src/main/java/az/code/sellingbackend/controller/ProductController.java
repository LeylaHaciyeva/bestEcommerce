package az.code.sellingbackend.controller;

import az.code.sellingbackend.dto.ProductDto;
import az.code.sellingbackend.entity.Category;
import az.code.sellingbackend.entity.Product;
import az.code.sellingbackend.repo.CategoryRepo;
import az.code.sellingbackend.repo.ProductRepo;
import az.code.sellingbackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequiredArgsConstructor
@Component
@EnableAutoConfiguration
public class ProductController {
    private final ProductService productService;
    @Autowired
    private final ProductRepo productRepo;

    @Autowired
    private final CategoryRepo categoryRepo;

    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }


    @PostMapping("/createProduct")
    public ResponseEntity<HttpStatus> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDto, optionalCategory.get());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/updateProduct/{productId}")
    public ResponseEntity<HttpStatus> updateProduct(@PathVariable("productId") Integer productId,
                 @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteProducts/{id}")
    public ResponseEntity<?> remover(@PathVariable Integer id) {
        Optional<Product> optional = productRepo.findById(id);
        if (optional.isPresent()) {
            productRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/getProducts/{id}")
    Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
}
