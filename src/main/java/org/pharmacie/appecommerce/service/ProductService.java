package org.pharmacie.appecommerce.service;

import org.pharmacie.appecommerce.entities.Employee;
import org.pharmacie.appecommerce.entities.Product;

import java.util.List;

public interface ProductService {
    public Product AddProduct(Product product);
    public List<Product> findAllProduct();
    public Product updateProduct (Product product);
    public Product findProductById(Long id) ;
    public void deleteProduct (Long id);
}
