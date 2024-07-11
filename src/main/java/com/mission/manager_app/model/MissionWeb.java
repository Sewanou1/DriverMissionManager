package com.mission.manager_app.model;

import jakarta.xml.bind.annotation.*;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import jakarta.xml.bind.annotation.XmlRootElement;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "missions")
@XmlAccessorType(XmlAccessType.FIELD)
public class MissionWeb {
    @XmlElement
    private Long id;

    @XmlElement
    private String code;

    @XmlElement(name = "dateDepart")
    @XmlSchemaType(name = "dateTime")
    private LocalDate dateDepart;

    @XmlElement(name = "dateArrivee")
    @XmlSchemaType(name = "dateTime")
    private LocalDate dateArrivee;

    @XmlElement
    private String lieuDepart;

    @XmlElement
    private String lieuArrivee;

    @XmlElement
    private Conducteur conducteur;

    @XmlElement
    private Vehicule vehicule;

// getters and setters
}
