package com.datamart.Datamart.Services;

import com.datamart.Datamart.Dtos.FilterDatamartDto;
import com.datamart.Datamart.Models.RegionModel;
import com.datamart.Datamart.Repositories.DatamartRepo;
import com.datamart.Datamart.Repositories.RegionRepo;
import com.datamart.Datamart.Dtos.SatisfactionRegionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatamartService {

    @Autowired
    private DatamartRepo datamartRepo;

    @Autowired
    private RegionRepo regionRepo;

    public FilterDatamartDto filterDataByRegion(int regionId, ZonedDateTime initDate, ZonedDateTime finishDate){
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String initDate = initDateZ.format(formatter);
        //String finishDate = finishDateZ.format(formatter);
        try{
            FilterDatamartDto dto = new FilterDatamartDto();
            int excelent = datamartRepo.getTotalByRegAndTypeResAndDate(regionId, 1, initDate, finishDate);
            dto.setExcelentSatisfaction(excelent);

            int medium = 0;
            medium += datamartRepo.getTotalByRegAndTypeResAndDate(regionId, 2, initDate, finishDate);
            medium += datamartRepo.getTotalByRegAndTypeResAndDate(regionId, 3, initDate, finishDate);
            dto.setMediumSatisfaction(medium);

            int low = 0;
            low += datamartRepo.getTotalByRegAndTypeResAndDate(regionId, 4, initDate, finishDate);
            low += datamartRepo.getTotalByRegAndTypeResAndDate(regionId, 5, initDate, finishDate);
            dto.setLowSatisfaction(low);

            dto.setTotalResponses(excelent + medium + low);
            return dto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public List<SatisfactionRegionDto> filterDataByRegion(ZonedDateTime initDate, ZonedDateTime finishDate){
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String initDate = initDateZ.format(formatter);
        //String finishDate = finishDateZ.format(formatter);
        try{
            List<RegionModel> regionModelList = regionRepo.findAll();
            List<SatisfactionRegionDto> satisfactionRegionDtosList = new ArrayList<>();

            for (RegionModel regionModel : regionModelList){
                SatisfactionRegionDto satisfactionRegionDto = new SatisfactionRegionDto();
                int excelent = (datamartRepo.getTotalByRegAndTypeResAndDate(regionModel.getId(), 1, initDate, finishDate));

                int medium = 0;
                medium += (datamartRepo.getTotalByRegAndTypeResAndDate(regionModel.getId(), 2, initDate, finishDate));
                medium += (datamartRepo.getTotalByRegAndTypeResAndDate(regionModel.getId(), 3, initDate, finishDate));

                int low = 0;
                low += datamartRepo.getTotalByRegAndTypeResAndDate(regionModel.getId(), 4, initDate, finishDate);
                low += datamartRepo.getTotalByRegAndTypeResAndDate(regionModel.getId(), 5, initDate, finishDate);

                BigDecimal satisfaction = BigDecimal.ZERO;
                int totalResponses = (excelent + medium + low)*5;
                if(totalResponses != 0) {
                    satisfaction = BigDecimal.valueOf(((excelent * 5L) + (medium * 3L) + (low)) * 100 / totalResponses);
                }

                satisfactionRegionDto.setRegionName(regionModel.getName());
                satisfactionRegionDto.setSatisfactionPercentage(satisfaction);
                satisfactionRegionDto.setColor(createColor(satisfaction));
                satisfactionRegionDtosList.add(satisfactionRegionDto);

            }

            return satisfactionRegionDtosList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }



    public static String createColor(BigDecimal percentage){
        if(percentage.compareTo(new BigDecimal("70")) > 0) return "#9EFF00";
        else if(percentage.compareTo(new BigDecimal("70")) < 0 && percentage.compareTo(new BigDecimal("50")) > 0) return "#FFFF00";
        else return "#FF0000";
    }

}
