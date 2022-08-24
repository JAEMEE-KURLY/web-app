package com.jaemee.kurly.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaemee.kurly.Entity.PriceSumryVo;

@Repository
public interface PriceSumryRepository extends JpaRepository<PriceSumryVo,Long> {

    public Optional<PriceSumryVo> findByCategoryName(String category_name);
    public List<PriceSumryVo> findByCategoryNameAndCompanyName(String category_name, String company_name);
    public List<PriceSumryVo> findAll();
    
}
