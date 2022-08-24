package com.jaemee.kurly.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jaemee.kurly.Entity.TagInfoVo;
import com.jaemee.kurly.Repository.TagInfoRepository;

@Service
public class TagInfoService {
    @Autowired
    private TagInfoRepository siteRepository;
    
    public List<TagInfoVo> findAll(){
        List<TagInfoVo> sites = new ArrayList<>();
        siteRepository.findAll().forEach(e -> sites.add(e));
        return sites;
    }

    public Optional<TagInfoVo> findById(Long id){
        Optional<TagInfoVo> sites = siteRepository.findById(id);
        return sites;
    }

    public void deleteById(Long id){
        siteRepository.deleteById(id);
    }

    public TagInfoVo save(TagInfoVo newSite){
        try{
            siteRepository.save(newSite);
        }catch(DataIntegrityViolationException e){
            System.out.println("id is already exist.");
        }
        
        return newSite;
    }
    public void updateById(Long id, TagInfoVo newSite){
        Optional<TagInfoVo> e = siteRepository.findById(id);

        if(e.isPresent()){
            e.get().setId(newSite.getId());
            e.get().setSiteName(newSite.getSiteName());
            e.get().setButtonElem(newSite.getButtonElem().isEmpty()?null:newSite.getButtonElem());
            e.get().setButtonClass(newSite.getButtonClass().isEmpty()? null: newSite.getButtonClass());
            e.get().setDivContainerClass(newSite.getDivContainerClass().isEmpty()? null: newSite.getDivContainerClass());
            e.get().setSplitElem(newSite.getSplitElem().isEmpty()? null:newSite.getSplitElem());
            e.get().setSplitElemClass(newSite.getSplitElemClass().isEmpty()? null:newSite.getSplitElemClass());
            e.get().setDivImageclass(newSite.getDivImageclass().isEmpty()? null: newSite.getDivImageclass());
            e.get().setATitleclass(newSite.getATitleclass().isEmpty()? null:newSite.getATitleclass());
            e.get().setTitleElem(newSite.getTitleElem().isEmpty()?null:newSite.getTitleElem());
            e.get().setTitleClass(newSite.getTitleClass().isEmpty()?null:newSite.getTitleClass());
            e.get().setPriceElem(newSite.getPriceElem().isEmpty()?null:newSite.getPriceElem());
            e.get().setPriceClass(newSite.getPriceClass().isEmpty()? null:newSite.getPriceClass());
            e.get().setUrl(newSite.getUrl());
            siteRepository.save(newSite);
        }
    }
}
