package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ChefGenerale extends Account {

    public ChefGenerale() {
        super();
    }

    public ChefGenerale(Integer CIN, String email, String password, String nom, String prenom, String role) {
        super(CIN, email, password, nom, prenom, role);
    }
}
