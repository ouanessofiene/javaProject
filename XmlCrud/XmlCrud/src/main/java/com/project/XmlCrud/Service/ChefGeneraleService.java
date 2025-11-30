package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.ChefGenerale;
import com.project.XmlCrud.Model.Municipalite;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.List;
@Service
public class ChefGeneraleService {

    // CREATE
    public void addChefGenerale(ChefGenerale chef) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addChefGenerale(chef);  // ajoute dans <ChefsGeneraux>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<ChefGenerale> getAllChefs() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getChefsGeneraux();
    }

    // READ BY CIN
    public ChefGenerale getChefByCIN(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getChefsGeneraux()
                .stream()
                .filter(c -> c.getCIN().equals(cin))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateChef(ChefGenerale updatedChef) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();

        for (int i = 0; i < municipalite.getChefsGeneraux().size(); i++) {
            ChefGenerale c = municipalite.getChefsGeneraux().get(i);

            if (c.getCIN().equals(updatedChef.getCIN())) {
                municipalite.getChefsGeneraux().set(i, updatedChef);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteChef(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.getChefsGeneraux().removeIf(c -> c.getCIN().equals(cin));
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
