package com.jaemee.kurly.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="PRICE_SUMRY")
@ToString
public class PriceSumryVo {
    @Id
    private Long id;

    @Column(name="sumrydate")
    private String sumryDate;

    @Column(name="company_name")
    private String companyName;

    @Column(name="category_name")
    private String categoryName;
    
    @Column(name="min_prc")
    private int minPrc;

    @Column(name="avg_prc")
    private int avgPrc;

    @Column(name="max_prc")
    private int maxPrc;

    // @Builder
    // public PriceSumryVo(String sumryDate, String companyName, String categoryName, int minPrc, int avgPrc, int maxPrc){
    //     this.sumryDate = sumryDate;
    //     this.companyName = companyName;
    //     this.categoryName = categoryName;
    //     this.minPrc = minPrc;
    //     this.avgPrc = avgPrc;
    //     this.maxPrc = maxPrc;
    // }
}
