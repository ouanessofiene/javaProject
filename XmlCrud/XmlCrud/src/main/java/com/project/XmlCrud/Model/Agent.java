package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Agent extends Account {

    @XmlElement(required = true)
    private boolean Disponibilite;

    @XmlElement(required = true)
    private String service;

    public Agent() {
        super();
    }

    public Agent(Integer CIN, String email, String password, String nom, String prenom, String role, boolean disponibilite, String service) {
        super(CIN, email, password, nom, prenom, role);
        this.Disponibilite = disponibilite;
        this.service = service;
    }

    // Getters et Setters
    public boolean isDisponibilite() { return Disponibilite; }
    public void setDisponibilite(boolean disponibilite) { Disponibilite = disponibilite; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
}
