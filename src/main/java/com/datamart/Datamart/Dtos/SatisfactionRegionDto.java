package com.datamart.Datamart.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class SatisfactionRegionDto {

    private String regionName;
    private BigDecimal satisfactionPercentage;
    private String color;

}
