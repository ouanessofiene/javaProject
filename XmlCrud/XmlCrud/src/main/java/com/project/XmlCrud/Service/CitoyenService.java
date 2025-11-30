package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Citoyen;
import com.project.XmlCrud.Model.Municipalite;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.List;
@Service
public class CitoyenService {

    // CREATE
    public void addCitoyen(Citoyen citoyen) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addCitoyen(citoyen);  // ajoute dans <Citoyens>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<Citoyen> getAllCitoyens() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getCitoyens();
    }

    // READ BY CIN
    public Citoyen getCitoyenByCIN(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getCitoyens()
                .stream()
                .filter(c -> c.getCIN().equals(cin))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateCitoyen(Citoyen updatedCitoyen) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();

        for (int i = 0; i < municipalite.getCitoyens().size(); i++) {
            Citoyen c = municipalite.getCitoyens().get(i);

            if (c.getCIN().equals(updatedCitoyen.getCIN())) {
                municipalite.getCitoyens().set(i, updatedCitoyen);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteCitoyen(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.removeCitoyenByCIN(String.valueOf(cin));
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
