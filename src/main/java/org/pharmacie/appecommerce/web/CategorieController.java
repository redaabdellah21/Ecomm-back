package org.pharmacie.appecommerce.web;

import org.pharmacie.appecommerce.entities.Category;
import org.pharmacie.appecommerce.entities.Employee;
import org.pharmacie.appecommerce.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// mappe les requete Web

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategorieController {
    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService)
    {
        this.categorieService = categorieService;
    }
    @GetMapping("/findall")
    public ResponseEntity<List<String>> getAllCategories(){
        List<String> categories = categorieService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategorie(Category category){
        Category newCat = categorieService.addCategory(category);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED );
    }

    @PutMapping("/update")
    public ResponseEntity<Category>  updateCategory(@RequestBody Category category){
        Category category1 = categorieService.updateCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK );
    }
    @DeleteMapping(value="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  deleteCategorie(@PathVariable("id") Long id ){
        categorieService.deleteCategoryById(id);
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
