package org.pharmacie.appecommerce.web;

import org.pharmacie.appecommerce.dao.ProductRepository;
import org.pharmacie.appecommerce.entities.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class CatalogueRestControler {
    private ProductRepository productRepository;

    public CatalogueRestControler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto (@PathVariable("id") Long id) throws Exception{
        Product p = productRepository.findById(id).get();
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
