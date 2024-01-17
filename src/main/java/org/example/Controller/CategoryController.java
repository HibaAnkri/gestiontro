package org.example.Controller;

import org.example.Entity.Category;
import org.example.Entity.Trottinette;
import org.example.Service.CategoryService;
import org.example.Service.TrottinetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping("/cat")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/Addcat")
    public ResponseEntity<Category> createcat(@RequestBody Category category) {
        Category createcat = categoryService.createCategory(category); // Use the service method here
        return ResponseEntity.status(HttpStatus.CREATED).body(createcat);
    }
    @GetMapping("/GetCategories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/{idCategory}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long idCategory) {
        categoryService.deleteCategory(idCategory);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long idCategory) {
        Category category = categoryService.findCategoryById(idCategory);

        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
