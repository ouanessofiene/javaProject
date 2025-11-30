package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.ChefInformatique;
import com.project.XmlCrud.Model.Municipalite;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.List;
@Service
public class ChefInformatiqueService {

    // CREATE
    public void addChefInformatique(ChefInformatique chef) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addChefInformatique(chef);  // ajoute dans <ChefsInformatiques>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<ChefInformatique> getAllChefs() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getChefsInformatiques();
    }

    // READ BY CIN
    public ChefInformatique getChefByCIN(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getChefsInformatiques()
                .stream()
                .filter(c -> c.getCIN().equals(cin))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateChef(ChefInformatique updatedChef) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();

        for (int i = 0; i < municipalite.getChefsInformatiques().size(); i++) {
            ChefInformatique c = municipalite.getChefsInformatiques().get(i);

            if (c.getCIN().equals(updatedChef.getCIN())) {
                municipalite.getChefsInformatiques().set(i, updatedChef);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteChef(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.getChefsInformatiques()
                .removeIf(c -> c.getCIN().equals(cin));
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
