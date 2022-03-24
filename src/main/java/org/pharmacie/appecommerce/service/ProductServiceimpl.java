package org.pharmacie.appecommerce.service;

import org.pharmacie.appecommerce.dao.EmployeeRepository;
import org.pharmacie.appecommerce.dao.ProductRepository;
import org.pharmacie.appecommerce.entities.Product;
import org.pharmacie.appecommerce.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
// la logique du metier est developpée ici

@Service
public class ProductServiceimpl implements ProductService{

    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceimpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public Product AddProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Transactional
    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Product findProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow(()->new UserNotFoundException("Product by id :"+id+"was not found"));
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
    @Transactional
    @Override
    public Product findProductByName(String name) {
        return productRepository.findProductByName(name).orElseThrow(()->new UserNotFoundException("Product by name :"+name+"was not found"));
    }
}
