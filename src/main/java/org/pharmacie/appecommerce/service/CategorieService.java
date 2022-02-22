package org.pharmacie.appecommerce.service;

import org.pharmacie.appecommerce.entities.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface CategorieService  {

    public List<String> findAllCategories();
    @Transactional
    public  Category addCategory(String name);

    public Category updateCategory (Category category);
    public void deleteCategoryById (Long id);
}
