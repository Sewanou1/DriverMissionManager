package com.mission.manager_app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "missions")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "libelle", nullable = false,length = 100)
    private String libelle;

    @Column(name = "date_depart", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    @Column(name = "date_arrivee", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateArrivee;

    @Column(name = "lieu_depart", nullable = false, length = 100)
    private String lieuDepart;

    @Column(name = "lieu_arrivee", nullable = false, length = 100)
    private String lieuArrivee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conducteur_mission ", nullable = false)
    private Conducteur conducteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule_mission ", nullable = false)
    private Vehicule vehicule;
}
