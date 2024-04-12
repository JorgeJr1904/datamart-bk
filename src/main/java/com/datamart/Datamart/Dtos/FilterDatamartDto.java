package com.datamart.Datamart.Dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter @Setter @ToString @EqualsAndHashCode
public class FilterDatamartDto {

    private int totalResponses;
    private int excelentSatisfaction;
    private int mediumSatisfaction;
    private int lowSatisfaction;


}
