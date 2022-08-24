package com.jaemee.kurly.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jaemee.kurly.Entity.CategoryVo;
import com.jaemee.kurly.Repository.CategoryRepository;



@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<CategoryVo> findAll(){
        List<CategoryVo> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(e -> categories.add(e));
        return categories;
    }

    public Optional<CategoryVo> findById(Long id){
        Optional<CategoryVo> category = categoryRepository.findById(id);
        return category;
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }

    public CategoryVo save(CategoryVo newCat){
        try{
            categoryRepository.save(newCat);
        }catch(DataIntegrityViolationException e){
            System.out.println("id is already exist.");
        }
        
        return newCat;
    }
    public void updateById(Long id, CategoryVo newCat){
        Optional<CategoryVo> e = categoryRepository.findById(id);

        if(e.isPresent()){
            e.get().setId(newCat.getId());
            e.get().setCategoryName(newCat.getCategoryName());
            e.get().setTargetInfo(newCat.getTargetInfo());
            categoryRepository.save(newCat);
        }
    }
}
