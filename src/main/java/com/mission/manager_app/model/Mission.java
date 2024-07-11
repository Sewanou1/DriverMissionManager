package com.mission.manager_app.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "missions")
@XmlRootElement(name = "mission")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    private Long id;

    @XmlElement(name = "dateDepart")
    @XmlSchemaType(name = "date")
    private LocalDate dateDepart;

    @XmlElement(name = "dateArrivee")
    @XmlSchemaType(name = "date")
    private LocalDate dateArrivee;

    @XmlElement
    private String lieuDepart;

    @XmlElement
    private String lieuArrivee;

    @ManyToOne
    @XmlElement
    @JoinColumn(name = "id_conducteur_mission ", nullable = false)
    private Conducteur conducteur;


    @ManyToOne
    @XmlElement
    @JoinColumn(name = "id_vehicule_mission ", nullable = false)
    private Vehicule vehicule;


    // getters and setters if not using Lombok
}




/*package com.mission.manager_app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
    private LocalDate dateDepart;

    @Column(name = "date_arrivee", nullable = false)
    private LocalDate dateArrivee;

    @Column(name = "lieu_depart", nullable = false, length = 100)
    private String lieuDepart;

    @Column(name = "lieu_arrivee", nullable = true, length = 100)
    private String lieuArrivee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conducteur_mission ", nullable = false)
    private Conducteur conducteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule_mission ", nullable = false)
    private Vehicule vehicule;
}*/
