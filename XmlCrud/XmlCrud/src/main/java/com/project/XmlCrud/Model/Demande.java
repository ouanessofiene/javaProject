package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import java.util.Base64;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Demande {
    @XmlElement(required = true)
    private Integer identifiant;

    @XmlElement(required = true)
    private Integer citoyenRef;

    @XmlElement(required = true)
    private String DateDeSoumission;

    @XmlElement(required = true)
    private String image;

    @XmlElement(required = true)
    private String localisation;

    public Demande() {}

    public Demande(Integer identifiant,Integer citoyenRef, String dateDeSoumission, String image, String localisation) {
        this.identifiant=identifiant;
        this.citoyenRef = citoyenRef;
        this.DateDeSoumission = dateDeSoumission;
        this.image = image;
        this.localisation = localisation;
    }

    // Getters et Setters
    public Integer getIdentifiant() { return identifiant; }
    public void setIdentifiant(Integer identifiant) { this.identifiant = identifiant; }
    
    public Integer getCitoyenRef() { return citoyenRef; }
    public void setCitoyenRef(Integer citoyenRef) { this.citoyenRef = citoyenRef; }

    public String getDateDeSoumission() { return DateDeSoumission; }
    public void setDateDeSoumission(String dateDeSoumission) { DateDeSoumission = dateDeSoumission; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getLocalisation() { return localisation; }
    public void setLocalisation(String localisation) { this.localisation = localisation; }
}
