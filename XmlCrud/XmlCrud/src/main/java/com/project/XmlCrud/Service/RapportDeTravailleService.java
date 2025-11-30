package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Municipalite;
import com.project.XmlCrud.Model.RapportDeTravaille;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.List;
@Service
public class RapportDeTravailleService {

    // CREATE
    public void addRapport(RapportDeTravaille rapport) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addRapport(rapport);  // ajoute dans <RapportsDeTravaille>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<RapportDeTravaille> getAllRapports() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getRapportsDeTravaille();
    }

    // READ BY Intervention REF
    public RapportDeTravaille getRapportByInterventionRef(Integer ref) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getRapportsDeTravaille()
                .stream()
                .filter(r -> r.getInterventionRef().equals(ref))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateRapport(RapportDeTravaille updatedRapport) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();

        for (int i = 0; i < municipalite.getRapportsDeTravaille().size(); i++) {
            RapportDeTravaille r = municipalite.getRapportsDeTravaille().get(i);

            if (r.getInterventionRef().equals(updatedRapport.getInterventionRef())) {
                municipalite.getRapportsDeTravaille().set(i, updatedRapport);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteRapport(Integer interventionRef) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.removeRapportByInterventionRef(interventionRef);
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
