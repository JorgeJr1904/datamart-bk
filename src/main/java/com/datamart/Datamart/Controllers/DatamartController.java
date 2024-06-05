package com.datamart.Datamart.Controllers;

import com.datamart.Datamart.Dtos.FilterDatamartDto;
import com.datamart.Datamart.Dtos.SatisfactionRegionDto;
import com.datamart.Datamart.Services.DatamartService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/datamart")
public class DatamartController {

    @Autowired
    private DatamartService datamartService;

    @GetMapping(value = "{idRegion}/initDate/{initDate}/finishDate/{finishDate}")
    public FilterDatamartDto filterData(@PathVariable int idRegion, @PathVariable ZonedDateTime initDate, @PathVariable ZonedDateTime finishDate){

        return datamartService.filterDataByRegion(idRegion,initDate, finishDate);
    }

    @GetMapping(value = "getSatisfaction/initDate/{initDate}/finishDate/{finishDate}")
    public List<SatisfactionRegionDto> filterData(@PathVariable ZonedDateTime initDate, @PathVariable ZonedDateTime finishDate){
        System.out.println(initDate);
        System.out.println(finishDate);
        return datamartService.filterDataByRegion(initDate, finishDate);
    }

}
