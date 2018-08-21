package pl.javastart.restoffers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.restoffers.model.Category;
import pl.javastart.restoffers.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<CategoryDTO> getAllOffers(){
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (Category category : categories) {
            categoryDTOS.add(new CategoryDTO(category.getId(), category.getName(), category.getDescription(), category.getOffers().size()));
        }
        return categoryDTOS;
    }
    @GetMapping("/names")
    public List<String> getAllCategoriesNames() {
        return categoryRepository.findAllName();
    }

}
