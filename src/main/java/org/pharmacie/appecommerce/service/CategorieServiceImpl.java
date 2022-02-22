package org.pharmacie.appecommerce.service;

import org.pharmacie.appecommerce.dao.CategoryRepository;
import org.pharmacie.appecommerce.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService{

     private CategoryRepository categoryRepository;

     @Autowired
    public CategorieServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public List<String> findAllCategories() {
        List<Category> all = categoryRepository.findAll();
        return all.stream().map(c->c.getName()).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Category addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category updateCategory(Category category) {

       return   categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(Long id) {
         categoryRepository.deleteById(id);

    }
}
