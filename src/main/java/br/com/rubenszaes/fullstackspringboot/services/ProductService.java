package br.com.rubenszaes.fullstackspringboot.services;

import br.com.rubenszaes.fullstackspringboot.entities.Product;
import br.com.rubenszaes.fullstackspringboot.exceptions.ResourceNotFoundException;
import br.com.rubenszaes.fullstackspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow( () -> new ResourceNotFoundException(id));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product, Long id) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
