package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Municipalite;
import com.project.XmlCrud.Model.Secretaire;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.List;
@Service
public class SecretaireService {

    // CREATE
    public void addSecretaire(Secretaire secretaire) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addSecretaire(secretaire);  // ajoute dans <Secretaires>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<Secretaire> getAllSecretaires() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getSecretaires();
    }

    // READ BY CIN
    public Secretaire getSecretaireByCIN(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getSecretaires()
                .stream()
                .filter(s -> s.getCIN().equals(cin))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateSecretaire(Secretaire updatedSecretaire) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();

        for (int i = 0; i < municipalite.getSecretaires().size(); i++) {
            Secretaire s = municipalite.getSecretaires().get(i);

            if (s.getCIN().equals(updatedSecretaire.getCIN())) {
                municipalite.getSecretaires().set(i, updatedSecretaire);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteSecretaire(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.getSecretaires()
                .removeIf(s -> s.getCIN().equals(cin));
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
