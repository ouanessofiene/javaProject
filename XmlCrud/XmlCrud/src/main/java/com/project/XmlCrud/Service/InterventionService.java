package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Intervention;
import com.project.XmlCrud.Model.Municipalite;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.List;
@Service
public class InterventionService {

    // CREATE
    public void addIntervention(Intervention intervention) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addIntervention(intervention);  // ajoute dans <Interventions>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<Intervention> getAllInterventions() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getInterventions();
    }

    // READ BY ID
    public Intervention getInterventionById(Integer id) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getInterventions()
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateIntervention(Intervention updatedIntervention) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();

        for (int i = 0; i < municipalite.getInterventions().size(); i++) {
            Intervention interv = municipalite.getInterventions().get(i);

            if (interv.getId().equals(updatedIntervention.getId())) {
                municipalite.getInterventions().set(i, updatedIntervention);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteIntervention(Integer id) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.removeInterventionById(id);
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
