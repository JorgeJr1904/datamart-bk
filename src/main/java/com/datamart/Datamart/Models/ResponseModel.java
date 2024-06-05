package com.datamart.Datamart.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Entity
@Table(name = "response")
@Getter @Setter @ToString
public class ResponseModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "response")
    private String response;

}
