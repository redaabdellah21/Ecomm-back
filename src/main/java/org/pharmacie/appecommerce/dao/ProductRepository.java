package org.pharmacie.appecommerce.dao;

import org.pharmacie.appecommerce.entities.Employee;
import org.pharmacie.appecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

// data access object pour avoir une relation avec la base de donnée
@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource(path="/selectedProducts")
    public List<Product> findBySelectedIsTrue();
    @RestResource(path = "/productsByKeyword")
    public List<Product> findByNameContains(@Param("mc") String mc);
    @RestResource(path = "/promoProducts")
    public List<Product> findByPromotionIsTrue();
    @RestResource(path = "/dispoProducts")
    public List<Product> findByAvailableIsTrue();

    Optional<Product> findProductById(Long id);
    Optional<Product> findProductByName(String Name);
}
