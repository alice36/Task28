package pl.javastart.restoffers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.restoffers.model.Category;
import pl.javastart.restoffers.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public ResponseEntity saveOffer(@RequestBody Category category){
        categoryRepository.save(category);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") Long id){

        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isPresent()) {
            CategoryDTO categoryDTO = new CategoryDTO(byId.get().getId(),byId.get().getName(), byId.get().getDescription(), byId.get().getOffers().size() );
            if (categoryDTO.getOffers()==0) {
                categoryRepository.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else
            return  ResponseEntity.notFound().build();
    }

}
