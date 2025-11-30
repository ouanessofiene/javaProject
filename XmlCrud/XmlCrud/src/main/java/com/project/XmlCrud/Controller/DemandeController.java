package com.project.XmlCrud.Controller;

import com.project.XmlCrud.DTO.DemandeDTO;
import com.project.XmlCrud.Model.Demande;
import com.project.XmlCrud.Service.DemandeService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    // CREATE
    @PostMapping("/create")
    public String createDemande(@RequestBody DemandeDTO demandeDTO) throws JAXBException, SAXException {
            Demande demande = new Demande();

            // Référence citoyen
            demande.setCitoyenRef(demandeDTO.getCitoyenRef());

            // Localisation
            demande.setLocalisation(demandeDTO.getLocalisation());

            // image Base64
            demande.setImage(demandeDTO.getImageBase64());


            // Générer un identifiant unique
            List<Demande> all = demandeService.getAllDemandes();
            int nextId = all.stream().mapToInt(Demande::getIdentifiant).max().orElse(0) + 1;
            demande.setIdentifiant(nextId);

            // Date de soumission automatique
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String today = LocalDate.now().format(formatter);
            demande.setDateDeSoumission(today);

            // Ajouter la demande
            demandeService.addDemande(demande);

            return "Demande ajoutée avec succès, id = " + nextId;


    }

    // READ ALL
    @GetMapping
    public List<Demande> getAllDemandes() throws JAXBException, SAXException {
        return demandeService.getAllDemandes();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Demande getDemandeById(@PathVariable Integer id) throws JAXBException, SAXException {
        return demandeService.getDemandeById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteDemande(@PathVariable Integer id) throws JAXBException, SAXException {
        boolean removed = demandeService.deleteDemande(id);
        return removed ? "Demande supprimée" : "Demande introuvable";
    }
}
