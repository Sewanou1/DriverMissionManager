package com.mission.manager_app.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "MissionList")
@XmlAccessorType(XmlAccessType.FIELD)
public class MissionList {

    @XmlElement(name = "message")
    private String message;

    @XmlElement(name = "mission")
    private List<Mission> missions;

    public MissionList() {}

    public MissionList(List<Mission> missions) {
        this.missions = missions;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
