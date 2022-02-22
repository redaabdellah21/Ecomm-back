package org.pharmacie.appecommerce.web;

import org.pharmacie.appecommerce.entities.Category;
import org.pharmacie.appecommerce.entities.Employee;
import org.pharmacie.appecommerce.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/categorie")
public class CategorieController {
    private CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService)
    {
        this.categorieService = categorieService;
    }
    @GetMapping("/findall")
    public ResponseEntity<List<String>> getAllEmployees(){
        List<String> categories = categorieService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add/{name}")
    public ResponseEntity<Category> addCategorie(@PathVariable("name") String name){
        Category newCat = categorieService.addCategory(name);
        return new ResponseEntity<>(newCat, HttpStatus.CREATED );
    }

    @PutMapping("/update")
    public ResponseEntity<Category>  updateEmployee(@RequestBody Category category){
        Category category1 = categorieService.updateCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK );
    }
    @DeleteMapping(path ="/delete/{id}")
    public void deleteCategorie(@PathVariable("id") Long id ){
        categorieService.deleteCategoryById(id);
    }
}
