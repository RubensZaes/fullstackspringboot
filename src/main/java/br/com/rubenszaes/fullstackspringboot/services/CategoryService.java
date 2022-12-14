package br.com.rubenszaes.fullstackspringboot.services;

import br.com.rubenszaes.fullstackspringboot.entities.Category;
import br.com.rubenszaes.fullstackspringboot.exceptions.ResourceNotFoundException;
import br.com.rubenszaes.fullstackspringboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow( () -> new ResourceNotFoundException(id));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category, Long id) {
        category.setId(id);
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
