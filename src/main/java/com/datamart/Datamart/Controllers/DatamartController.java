package com.datamart.Datamart.Controllers;

import com.datamart.Datamart.Dtos.FilterDatamartDto;
import com.datamart.Datamart.Services.DatamartService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/datamart")
public class DatamartController {

    @Autowired
    private DatamartService datamartService;

    @GetMapping(value = "{idRegion}")
    public FilterDatamartDto filterData(@PathVariable int idRegion){
        return datamartService.filterDataByRegion(idRegion);
    }

}
