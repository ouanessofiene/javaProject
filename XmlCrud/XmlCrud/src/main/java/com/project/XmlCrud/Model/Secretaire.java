package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Secretaire extends Account {
    
    public Secretaire() {
        super();
    }

    public Secretaire(Integer CIN, String email, String password, String nom, String prenom, String role) {
        super(CIN, email, password, nom, prenom, role);
    }
}
