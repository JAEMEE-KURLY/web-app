package com.jaemee.kurly.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaemee.kurly.Entity.CategoryVo;



@Repository
public interface CategoryRepository extends JpaRepository<CategoryVo, Long> {
    
    public Optional<CategoryVo> findById(Long id);
    public List<CategoryVo> findByCategoryName(String category_name);
    public List<CategoryVo> findAll();

}
