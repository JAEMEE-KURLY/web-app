package com.jaemee.kurly.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Entity(name="TAG_INFO")
@ToString
public class TagInfoVo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="site_name", nullable=false)
    private String siteName="";

    @Column(name="button_elem")
    private String buttonElem;

    @Column(name="button_class")
    private String buttonClass;

    @Column(name="div_container_class")
    private String divContainerClass;

    @Column(name="split_elem")
    private String splitElem;

    @Column(name="split_elem_class")
    private String splitElemClass;

    @Column(name="div_imageclass" )
    private String divImageclass;

    @Column(name="a_titleclass", nullable=true)
    private String aTitleclass;

    @Column(name="title_elem")
    private String titleElem;

    @Column(name="title_class")
    private String titleClass;

    @Column(name="price_elem")
    private String priceElem;

    @Column(name="price_class")
    private String priceClass;

    @Column(name="url", nullable=false)
    private String url;


    @Builder
    public TagInfoVo(String siteName, String buttonElem, String buttonClass, String divContainerClass,
    String splitElem, String splitElemClass, String divImageclass, String aTitleclass, String titleElem,
    String titleClass, String priceElem, String priceClass, String url){
        this.siteName = siteName;
        this.buttonElem = buttonElem;
        this.buttonClass = buttonClass;
        this.divContainerClass = divContainerClass;
        this.splitElem = splitElem;
        this.splitElemClass = splitElemClass;
        this.divImageclass = divImageclass;
        this.aTitleclass = aTitleclass;
        this.titleElem = titleElem;
        this.titleClass = titleClass;
        this.priceElem = priceElem;
        this.priceClass = priceClass;
        this.url = url;
    }
}
