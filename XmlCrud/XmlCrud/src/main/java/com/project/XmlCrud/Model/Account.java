package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Account {

    @XmlElement(required = true)
    private Integer CIN;

    @XmlElement(required = true)
    private String email;

    @XmlElement(required = true)
    private String password;

    @XmlElement(required = true)
    private String nom;

    @XmlElement(required = true)
    private String prenom;

    @XmlElement(required = true)
    private String role;

    public Account() {
        
    }

    public Account(Integer CIN, String email, String password, String nom, String prenom, String role) {
        this.CIN = CIN;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }


    public Integer getCIN() { return CIN; }
    public void setCIN(Integer CIN) { this.CIN = CIN; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}


