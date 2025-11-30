package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Notification {
    @XmlElement(required = true)
    private Integer idN;

    @XmlElement(required = true)
    private Integer citoyenRef;

    @XmlElement(required = true)
    private String contenue;
    
    public Notification() {}

    public Notification(Integer idN, Integer citoyenRef, String contenue) {
        this.idN = idN;
        this.citoyenRef = citoyenRef;
        this.contenue = contenue;
    }
    public Integer getIdN() { return idN; }
    public void setIdN(Integer idN) { this.idN = idN; }

    public Integer getCitoyenRef() { return citoyenRef; }
    public void setCitoyenRef(Integer citoyenRef) { this.citoyenRef = citoyenRef; }

    public String getContenue() { return contenue; }
    public void setContenue(String contenue) { this.contenue = contenue; }
}
