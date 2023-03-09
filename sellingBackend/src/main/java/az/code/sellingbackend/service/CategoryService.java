package az.code.sellingbackend.service;

import az.code.sellingbackend.entity.Category;
import az.code.sellingbackend.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public void createCategory(Category category) {
        categoryRepo.save(category);
//        return "success";
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public ResponseEntity<HttpStatus> updateCategory(String categoryId, Category category) {
        if (categoryRepo.findById(Integer.valueOf(categoryId)).isPresent()) {
            Category categorySelected = categoryRepo.getById(Integer.valueOf(categoryId));
            categorySelected.setCategoryName(category.getCategoryName());
            categorySelected.setDescription(category.getDescription());
            categorySelected.setImageUrl(category.getImageUrl());
            categoryRepo.save(category);
            return new ResponseEntity(HttpStatus.OK);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    public boolean findById(String categoryId) {
        return categoryRepo.findById(Integer.valueOf(categoryId)).isPresent();
    }
}
