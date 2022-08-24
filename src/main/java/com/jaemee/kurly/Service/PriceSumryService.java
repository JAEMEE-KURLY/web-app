package com.jaemee.kurly.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaemee.kurly.Entity.PriceSumryVo;
import com.jaemee.kurly.Repository.PriceSumryRepository;

@Service
public class PriceSumryService {
    @Autowired
    private PriceSumryRepository priceSumryRepository;

    public List<PriceSumryVo> findAll(){
        List<PriceSumryVo> prices = new ArrayList<>();
        priceSumryRepository.findAll().forEach(e -> prices.add(e));
        return prices;
    }

    public Optional<PriceSumryVo> findByCategoryName(String category_name){
        Optional<PriceSumryVo> prices = priceSumryRepository.findByCategoryName(category_name);
        return prices;
    }

    public List<PriceSumryVo> findByCategoryNameAndCompanyName(String category_name, String company_name){
        List<PriceSumryVo> prices = priceSumryRepository.findByCategoryNameAndCompanyName(category_name, company_name);
        return prices;
    }
}
