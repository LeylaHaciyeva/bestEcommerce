package az.code.sellingbackend.service;

import az.code.sellingbackend.dto.ProductDto;
import az.code.sellingbackend.entity.Category;
import az.code.sellingbackend.entity.Product;
import az.code.sellingbackend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products;
    }

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setProductDesc(productDto.getProductDesc());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductImage(productDto.getProductImage());
        product.setProductName(productDto.getProductName());
        product.setProductCategory(category);
        productRepo.save(product);
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product yoxdur");
        }
        Product product = optionalProduct.get();
        product.setProductName(productDto.getProductName());
        product.setProductImage(productDto.getProductImage());
        product.setProductDesc(productDto.getProductDesc());
        product.setProductPrice(productDto.getProductPrice());
        productRepo.save(product);
    }


    public Product getProductById(String id) {
        return productRepo.getProductsById(Integer.valueOf(id));
    }

    public void deleteById(String id) {
        productRepo.deleteById(Integer.valueOf(id));
    }


}
