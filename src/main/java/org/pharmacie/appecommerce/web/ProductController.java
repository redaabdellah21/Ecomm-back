package org.pharmacie.appecommerce.web;

import org.pharmacie.appecommerce.entities.Employee;
import org.pharmacie.appecommerce.entities.Product;
import org.pharmacie.appecommerce.service.EmployeeServices;
import org.pharmacie.appecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// mappe les requete Web
@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> employees = productService.findAllProduct();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id")Long id){
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name")String name){
        Product productByName = productService.findProductByName(name);
        return new ResponseEntity<>(productByName, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.AddProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED );
    }

    @PutMapping("/update")
    public ResponseEntity<Product>  updateProduct(@RequestBody Product product){
        Product newProduct = productService.updateProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK );
    }


    @DeleteMapping(value="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>  deleteProduct(@PathVariable("id")Long id){
        productService.deleteProduct( id);
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
