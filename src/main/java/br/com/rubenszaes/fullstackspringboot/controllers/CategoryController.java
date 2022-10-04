package br.com.rubenszaes.fullstackspringboot.controllers;

import br.com.rubenszaes.fullstackspringboot.entities.Category;
import br.com.rubenszaes.fullstackspringboot.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({"/categories"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryList = categoryService.findAll();
        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Category categoryList = categoryService.findById(id);
        return ResponseEntity.ok().body(categoryList);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        category = categoryService.save(category);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id) {
        category = categoryService.update(category, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
