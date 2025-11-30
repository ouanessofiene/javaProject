package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Citoyen extends Account {

    @XmlElement(required = true)
    private String Adresse;

    @XmlElement(required = true)
    private String Rue;

    
    public Citoyen() {
        super();
    }


    public Citoyen(Integer CIN, String email, String password, String nom, String prenom, String role, String Adresse, String Rue) {
        super(CIN, email, password, nom, prenom, role);
        this.Adresse = Adresse;
        this.Rue = Rue;
    }

    // Getters et Setters
    public String getAdresse() { return Adresse; }
    public void setAdresse(String adresse) { Adresse = adresse; }

    public String getRue() { return Rue; }
    public void setRue(String rue) { Rue = rue; }
}
