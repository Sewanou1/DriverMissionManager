package com.mission.manager_app.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "cars")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "marque", nullable = false, length = 255)
    private String marque;

    @Column(name = "modele", nullable = false, length = 255)
    private String modele;

    @Column(name = "annee", nullable = false)
    private Integer annee;

    @Column(name = "numeroImmatriculation", nullable = false, length = 255)
    private String numeroImmatriculation;

}
