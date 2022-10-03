package br.com.rubenszaes.fullstackspringboot.repository;

import br.com.rubenszaes.fullstackspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
