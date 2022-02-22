package org.pharmacie.appecommerce.web;

import org.pharmacie.appecommerce.dao.CategoryRepository;
import org.pharmacie.appecommerce.dao.ProductRepository;
import org.pharmacie.appecommerce.entities.Category;
import org.pharmacie.appecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class CatalogueRestControler {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public CatalogueRestControler(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository =categoryRepository;
    }

    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto (@PathVariable("id") Long id) throws Exception{
        Product p = productRepository.findProductById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ECommerce/products/"+p.getPhotoName()));
    }

    @PostMapping(path="/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable ("id") Long id) throws Exception{
        Product product=productRepository.findById(id).get();
        product.setPhotoName(product.getName()+"_"+id+".png");
        Files.write(Paths.get(System.getProperty("user.home")+"/ECommerce/products/"+ product.getPhotoName()),file.getBytes());
        productRepository.save(product);
    }

}
