package com.jaemee.kurly.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaemee.kurly.Entity.TagInfoVo;


@Repository
public interface TagInfoRepository extends JpaRepository<TagInfoVo, Long> {
    
    public Optional<TagInfoVo> findById(Long id);
    public List<TagInfoVo> findBySiteName(String site_name);
    public List<TagInfoVo> findAll();
    // public void saveOrUpdate(SiteVo newSite);

}
