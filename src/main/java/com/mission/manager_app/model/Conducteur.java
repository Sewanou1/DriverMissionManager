package com.mission.manager_app.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "drivers")
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idConducteur;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @Column(name = "dateNaissance", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(name = "numPermis", nullable = false, length = 50)
    private String numeroPermis;

    @OneToMany(mappedBy = "conducteur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Mission> missions;

}
