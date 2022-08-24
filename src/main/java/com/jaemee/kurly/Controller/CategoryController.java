package com.jaemee.kurly.Controller;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jaemee.kurly.Entity.CategoryVo;
import com.jaemee.kurly.Exception.CategoryNotFound;
import com.jaemee.kurly.Service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins="http://localhost:8080")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    // Get all site lists
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CategoryVo>> getAllSites(){
        List<CategoryVo> categories = categoryService.findAll();
        return new ResponseEntity<List<CategoryVo>>(categories, HttpStatus.OK);
    }

    // Get one site by specific id
    @GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CategoryVo> getSite(@PathVariable("id") Long id){
        Optional<CategoryVo> category = categoryService.findById(id);
        if(category.isPresent()){
            return new ResponseEntity<CategoryVo>(category.get(), HttpStatus.OK);
        }else{
            throw new CategoryNotFound("Invalid Category Id");
        }
    }

    // Delete from specific id
    @DeleteMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteSite(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // modify site info by id
    @PutMapping(value="/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CategoryVo> updateSite(@PathVariable("id") Long id, @RequestBody CategoryVo newCategory){
        System.out.println(String.format("update: %s",newCategory.toString()));
        categoryService.updateById(id, newCategory);
        return new ResponseEntity<CategoryVo>(newCategory, HttpStatus.OK);
    }

    //Create new Site info
    @PostMapping
    public ResponseEntity<CategoryVo> save(@RequestBody CategoryVo category){
        return new ResponseEntity<CategoryVo>(categoryService.save(category), HttpStatus.OK);
    }

    @RequestMapping(value="/saveSite", method=RequestMethod.GET)
    public ResponseEntity<CategoryVo> save(HttpServletRequest req, CategoryVo category){
        return new ResponseEntity<CategoryVo>(categoryService.save(category), HttpStatus.OK);
    }
}



