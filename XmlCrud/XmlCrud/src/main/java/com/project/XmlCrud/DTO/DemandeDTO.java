package com.project.XmlCrud.DTO;

public class DemandeDTO {

    private Integer citoyenRef;       // référence du citoyen
    private String imageBase64;       // image reçue en Base64
    private String localisation;      // localisation de la demande

    // Getters et Setters
    public Integer getCitoyenRef() {
        return citoyenRef;
    }

    public void setCitoyenRef(Integer citoyenRef) {
        this.citoyenRef = citoyenRef;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
