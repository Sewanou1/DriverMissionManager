package com.mission.manager_app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Missions")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "DateDepart", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDepart;

    @Column(name = "DateArrivee", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateArrivee;

    @Column(name = "LieuDepart", nullable = false, length = 100)
    private String lieuDepart;

    @Column(name = "LieuArrivee", nullable = false, length = 100)
    private String lieuArrivee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdConducteurMission", nullable = false)
    private Conducteur conducteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdVehiculeMission", nullable = false)
    private Vehicule vehicule;
}
