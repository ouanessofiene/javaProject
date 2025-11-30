package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class RapportDeTravaille {

    @XmlElement(required = true)
    private Integer CINAgent;

    @XmlElement(required = true)
    private Integer InterventionRef;

    @XmlElement(required = true)
    private Integer cout;

    @XmlElement(required = true)
    private Integer Duree;

    @XmlElement(required = true)
    private String description;

    @XmlElement(required = true)
    private String image;

    public RapportDeTravaille() {}

    public RapportDeTravaille(Integer CINAgent, Integer cout, Integer Duree, String description, String image , Integer InterventionRef) {
        this.CINAgent = CINAgent;
        this.cout = cout;
        this.Duree = Duree;
        this.description = description;
        this.image = image;
        this.InterventionRef = InterventionRef;
    }

    // Getters et Setters

    public Integer getInterventionRef() { return InterventionRef; }
    public void setInterventionRef(Integer interventionRef) { this.InterventionRef = interventionRef; }

    public Integer getDuree() { return Duree; }
    public void setDuree(Integer duree) { Duree = duree; }

    public Integer getCINAgent() { return CINAgent; }
    public void setCINAgent(Integer CINAgent) { this.CINAgent = CINAgent; }

    public Integer getCout() { return cout; }
    public void setCout(Integer cout) { this.cout = cout; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
