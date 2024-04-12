package com.datamart.Datamart.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "datamart")
public class DatamartModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "idregion")
    private RegionModel region;

    @OneToOne
    @JoinColumn(name = "idresponse")
    private ResponseModel response;
}
