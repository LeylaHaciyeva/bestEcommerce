package az.code.sellingbackend.controller;

import az.code.sellingbackend.entity.Category;
import az.code.sellingbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "category", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "success";
    }

    @GetMapping("/all")
    public List<Category> getCategory() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/all/{categoryId}")
    public boolean findById(@PathVariable String categoryId) {
        return categoryService.findById(categoryId);
    }

    @PostMapping("/update/{categoryId}")
    public String updateCategory(@PathVariable String categoryId, @RequestBody Category category) {
        categoryService.updateCategory(categoryId, category);
        return "updated";
    }
}
