package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Demande;
import com.project.XmlCrud.Model.Municipalite;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.Base64;
import java.util.List;

@Service
public class DemandeService {

    // CREATE
    public void addDemande(Demande demande) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addDemande(demande);  // ajoute dans <Demandes>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<Demande> getAllDemandes() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getDemandes();
    }

    // READ BY ID
    public Demande getDemandeById(Integer id) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getDemandes()
                .stream()
                .filter(d -> d.getIdentifiant().equals(id))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateDemande(Demande updatedDemande) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        for (int i = 0; i < municipalite.getDemandes().size(); i++) {
            Demande d = municipalite.getDemandes().get(i);
            if (d.getIdentifiant().equals(updatedDemande.getIdentifiant())) {
                municipalite.getDemandes().set(i, updatedDemande);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteDemande(Integer id) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.removeDemandeById(id);
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
