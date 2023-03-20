package az.code.sellingbackend.controller;

import az.code.sellingbackend.entity.Category;
import az.code.sellingbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping(value = "category", method = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping(value="/create",consumes = MediaType.ALL_VALUE,produces = "application/json")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "success";
    }

    @GetMapping(value="/all", produces = "application/json",consumes = MediaType.ALL_VALUE)
    public List<Category> getCategory() {
        System.out.println("get all cat");
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
