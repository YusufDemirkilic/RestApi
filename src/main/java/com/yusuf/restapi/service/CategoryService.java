package com.yusuf.restapi.service;

import com.yusuf.restapi.customExeption.NotFoundException;
import com.yusuf.restapi.entities.Category;
import com.yusuf.restapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Kategori Bulunamadı"));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        if (!this.categoryRepository.existsById(id)) {
            throw new NotFoundException("Category with id " + id + " not found.");
        }
        return this.categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        if (!this.categoryRepository.existsById(id)) {
            throw new NotFoundException("Bu kategori mevcut değil.");
        }

        this.categoryRepository.deleteById(id);
    }

}
