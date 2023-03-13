package az.code.sellingbackend.service;

import az.code.sellingbackend.dto.ProductDto;
import az.code.sellingbackend.entity.Category;
import az.code.sellingbackend.entity.Product;
import az.code.sellingbackend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
public ProductDto getProductDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setProductPrice(product.getProductPrice());
        productDto.setProductName(product.getProductName());
        productDto.setProductImage(product.getProductImage());
        productDto.setId(product.getId());
        productDto.setCategoryId(product.getProductCategory().getId());
        productDto.setProductDesc(product.getProductDesc());
        return productDto;
}

    public Product getProductById(String id) {
        return productRepo.getProductsById(Integer.valueOf(id));
    }

    public void deleteById(String id) {
        productRepo.deleteById(Integer.valueOf(id));
    }


    public Product findById(Integer productId) throws Exception {
       Optional<Product> optProduct= productRepo.findById(productId);
       if(optProduct.isEmpty()){
           throw  new Exception("product id not valid");
       }
      return  optProduct.get();
    }
}
