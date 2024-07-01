package com.mission.manager_app.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.Set;

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

    @Column(name = "num_immatriculation", nullable = false, length = 255)
    private String numeroImmatriculation;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Mission> missions;
}
