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

import com.jaemee.kurly.Entity.TagInfoVo;
import com.jaemee.kurly.Exception.SiteNotFound;
import com.jaemee.kurly.Service.TagInfoService;

@RestController
@RequestMapping("/api/v1/site")
@CrossOrigin(origins="http://localhost:8080")
public class TagInfoController {
    @Autowired
    TagInfoService tagInfoService;

    // Get all site lists
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TagInfoVo>> getAllSites(){
        List<TagInfoVo> sites = tagInfoService.findAll();
        return new ResponseEntity<List<TagInfoVo>>(sites, HttpStatus.OK);
    }

    // Get one site by specific id
    @GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TagInfoVo> getSite(@PathVariable("id") Long id){
        Optional<TagInfoVo> site = tagInfoService.findById(id);
        if(site.isPresent()){
            return new ResponseEntity<TagInfoVo>(site.get(), HttpStatus.OK);
        }else{
            throw new SiteNotFound("Invalid Site Id");
        }
    }

    // Delete from specific id
    @DeleteMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteSite(@PathVariable("id") Long id){
        tagInfoService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // modify site info by id
    @PutMapping(value="/{id}", produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TagInfoVo> updateSite(@PathVariable("id") Long id, @RequestBody TagInfoVo newSite){
        System.out.println(String.format("update: %s",newSite.toString()));
        tagInfoService.updateById(id, newSite);
        return new ResponseEntity<TagInfoVo>(newSite, HttpStatus.OK);
    }

    //Create new Site info
    @PostMapping
    public ResponseEntity<TagInfoVo> save(@RequestBody TagInfoVo site){
        return new ResponseEntity<TagInfoVo>(tagInfoService.save(site), HttpStatus.OK);
    }

    @RequestMapping(value="/saveSite", method=RequestMethod.GET)
    public ResponseEntity<TagInfoVo> save(HttpServletRequest req, TagInfoVo site){
        return new ResponseEntity<TagInfoVo>(tagInfoService.save(site), HttpStatus.OK);
    }
}



