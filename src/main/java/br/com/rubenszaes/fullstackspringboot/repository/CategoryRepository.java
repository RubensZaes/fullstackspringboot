package br.com.rubenszaes.fullstackspringboot.repository;

import br.com.rubenszaes.fullstackspringboot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
