package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Intervention {

    @XmlElement(required = true)
    private Integer budget;

    @XmlElement(required = true)
    private Integer id;

    @XmlElement(name = "dateDebut", required = true)
    private String dateDebut;

    @XmlElement(required = true)
    private String type;

    @XmlElement(required = true)
    private Integer urgence;

    @XmlElement(required = true)
    private Integer CINAgent;

    @XmlElement(required = true)
    private Integer CINSecretaire;

    public Intervention() {}

    public Intervention(Integer id, Integer budget, String dateDebut, String type, Integer urgence, Integer CINAgent, Integer CINSecretaire) {
        this.id = id;
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.type = type;
        this.urgence = urgence;
        this.CINAgent = CINAgent;
        this.CINSecretaire = CINSecretaire;
    }

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getBudget() { return budget; }
    public void setBudget(Integer budget) { this.budget = budget; }

    public String getDateDebut() { return dateDebut; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Integer getUrgence() { return urgence; }
    public void setUrgence(Integer urgence) { this.urgence = urgence; }

    public Integer getCINAgent() { return CINAgent; }
    public void setCINAgent(Integer CINAgent) { this.CINAgent = CINAgent; }

    public Integer getCINSecretaire() { return CINSecretaire; }
    public void setCINSecretaire(Integer CINSecretaire) { this.CINSecretaire = CINSecretaire; }
}
