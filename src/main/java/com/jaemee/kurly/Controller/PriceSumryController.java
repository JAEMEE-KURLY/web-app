package com.jaemee.kurly.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaemee.kurly.Entity.PriceSumryVo;
import com.jaemee.kurly.Service.PriceSumryService;

@RestController
@RequestMapping("/api/v1/price")
@CrossOrigin(origins="http://localhost:8080")
public class PriceSumryController {
    @Autowired
    PriceSumryService priceSumryService;

    // @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    // public ResponseEntity<List<PriceSumryVo>> getItemInfo(@PathVariable("source") String company_name, @PathVariable("item") String category_name){
    //     List<PriceSumryVo> prices = priceSumryService.findByCategoryNameAndCompanyName(category_name, company_name);
    //     return new ResponseEntity<List<PriceSumryVo>>(prices, HttpStatus.OK);
    // }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PriceSumryVo>> getItemInfo(){
        List<PriceSumryVo> prices = priceSumryService.findAll();
        return new ResponseEntity<List<PriceSumryVo>>(prices, HttpStatus.OK);
    }

    @GetMapping(value="/{comp}/{category}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<PriceSumryVo>> getPrice(@PathVariable("comp") String company_name, @PathVariable("category") String category_name){
        List<PriceSumryVo> prices = priceSumryService.findByCategoryNameAndCompanyName(category_name, company_name);
        return new ResponseEntity<List<PriceSumryVo>>(prices, HttpStatus.OK);
    }
}
