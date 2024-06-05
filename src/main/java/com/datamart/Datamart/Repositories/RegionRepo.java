package com.datamart.Datamart.Repositories;

import com.datamart.Datamart.Models.RegionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<RegionModel, Integer> {

}
