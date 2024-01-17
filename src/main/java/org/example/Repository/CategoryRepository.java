package org.example.Repository;

import org.example.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends  JpaRepository<Category,Long> {
    public Category findByCategory(String category);
}
