package com.datamart.Datamart.Services;

import com.datamart.Datamart.Dtos.FilterDatamartDto;
import com.datamart.Datamart.Repositories.DatamartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatamartService {

    @Autowired
    private DatamartRepo datamartRepo;

    public FilterDatamartDto filterDataByRegion(int regionId){
        try{
            FilterDatamartDto dto = new FilterDatamartDto();
            int excelent = datamartRepo.getTotalByRegAndTypeRes(regionId, 1);
            dto.setExcelentSatisfaction(excelent);

            int medium = 0;
            medium += datamartRepo.getTotalByRegAndTypeRes(regionId, 2);
            medium += datamartRepo.getTotalByRegAndTypeRes(regionId, 3);
            dto.setMediumSatisfaction(medium);

            int low = 0;
            low += datamartRepo.getTotalByRegAndTypeRes(regionId, 4);
            low += datamartRepo.getTotalByRegAndTypeRes(regionId, 5);
            dto.setLowSatisfaction(low);

            dto.setTotalResponses(excelent + medium + low);
            return dto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}
