package com.datamart.Datamart.Repositories;

import com.datamart.Datamart.Models.DatamartModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class DatamartRepo {

    @Autowired
    private EntityManager entityManager;

    public List<DatamartModel> getDatamart() {
        return entityManager.createQuery("FROM DatamartModel").getResultList();
    }

    public Integer getTotalResponses() {
        return entityManager.createQuery("SELECT COUNT(*) FROM DatamartModel").getFirstResult();
    }

    public Integer getTotalByRegAndTypeRes(int regionId, int responseId) {
        Query sql = entityManager.createQuery("SELECT count(*) FROM DatamartModel d " +
                "INNER JOIN RegionModel r ON d.region.id = r.id " +
                "INNER JOIN ResponseModel r2 ON d.response.id = r2.id " +
                "WHERE r2.id = :response AND r.id = :region");
        sql.setParameter("response", responseId);
        sql.setParameter("region", regionId);
        Long res = (Long)sql.getSingleResult();
        return Integer.valueOf(res.toString());
    }

}
