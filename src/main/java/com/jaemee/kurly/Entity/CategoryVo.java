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
@Entity(name="CATEGORY_INFO")
@ToString
public class CategoryVo {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="category_name", nullable = false)
    private String categoryName="";

    @Column(name="target_info")
    private String targetInfo;

    @Builder
    public CategoryVo(String category_name, String target_info){
        this.categoryName = category_name;
        this.targetInfo = target_info;
    }

}
