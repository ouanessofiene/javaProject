package com.project.XmlCrud.Model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Municipalite")
@XmlAccessorType(XmlAccessType.FIELD)
public class Municipalite {

    @XmlElementWrapper(name = "Citoyens")
    @XmlElement(name = "Citoyen")
    private List<Citoyen> citoyens;

    @XmlElementWrapper(name = "Agents")
    @XmlElement(name = "Agent")
    private List<Agent> agents;

    @XmlElementWrapper(name = "Secretaires")
    @XmlElement(name = "Secretaire")
    private List<Secretaire> secretaires;

    @XmlElementWrapper(name = "ChefsGeneraux")
    @XmlElement(name = "ChefGenerale")
    private List<ChefGenerale> chefsGeneraux;

    @XmlElementWrapper(name = "ChefsInformatiques")
    @XmlElement(name = "ChefInformatique")
    private List<ChefInformatique> chefsInformatiques;

    @XmlElementWrapper(name = "Demandes")
    @XmlElement(name = "Demande")
    private List<Demande> demandes;

    @XmlElementWrapper(name = "Notifications")
    @XmlElement(name = "Notification")
    private List<Notification> notifications;

    @XmlElementWrapper(name = "RapportsDeTravaille")
    @XmlElement(name = "RapportDeTravaille")
    private List<RapportDeTravaille> rapportsDeTravaille;

    @XmlElementWrapper(name = "Interventions")
    @XmlElement(name = "Intervention")
    private List<Intervention> interventions;

    // Constructeur vide nécessaire pour JAXB — on initialise les listes pour éviter les NPE
    public Municipalite() {
        this.citoyens = new ArrayList<>();
        this.agents = new ArrayList<>();
        this.secretaires = new ArrayList<>();
        this.chefsGeneraux = new ArrayList<>();
        this.chefsInformatiques = new ArrayList<>();
        this.demandes = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.rapportsDeTravaille = new ArrayList<>();
        this.interventions = new ArrayList<>();
    }

    // Getters et Setters
    public List<Citoyen> getCitoyens() { return citoyens; }
    public void setCitoyens(List<Citoyen> citoyens) { this.citoyens = citoyens != null ? citoyens : new ArrayList<>(); }

    public List<Agent> getAgents() { return agents; }
    public void setAgents(List<Agent> agents) { this.agents = agents != null ? agents : new ArrayList<>(); }

    public List<Secretaire> getSecretaires() { return secretaires; }
    public void setSecretaires(List<Secretaire> secretaires) { this.secretaires = secretaires != null ? secretaires : new ArrayList<>(); }

    public List<ChefGenerale> getChefsGeneraux() { return chefsGeneraux; }
    public void setChefsGeneraux(List<ChefGenerale> chefsGeneraux) { this.chefsGeneraux = chefsGeneraux != null ? chefsGeneraux : new ArrayList<>(); }

    public List<ChefInformatique> getChefsInformatiques() { return chefsInformatiques; }
    public void setChefsInformatiques(List<ChefInformatique> chefsInformatiques) { this.chefsInformatiques = chefsInformatiques != null ? chefsInformatiques : new ArrayList<>(); }

    public List<Demande> getDemandes() { return demandes; }
    public void setDemandes(List<Demande> demandes) { this.demandes = demandes != null ? demandes : new ArrayList<>(); }

    public List<Notification> getNotifications() { return notifications; }
    public void setNotifications(List<Notification> notifications) { this.notifications = notifications != null ? notifications : new ArrayList<>(); }

    public List<RapportDeTravaille> getRapportsDeTravaille() { return rapportsDeTravaille; }
    public void setRapportsDeTravaille(List<RapportDeTravaille> rapportsDeTravaille) { this.rapportsDeTravaille = rapportsDeTravaille != null ? rapportsDeTravaille : new ArrayList<>(); }

    public List<Intervention> getInterventions() { return interventions; }
    public void setInterventions(List<Intervention> interventions) { this.interventions = interventions != null ? interventions : new ArrayList<>(); }

    // Méthodes utilitaires (facilitent le CRUD dans tes services)
    public void addCitoyen(Citoyen c) { this.citoyens.add(c); }
    public boolean removeCitoyenByCIN(String cin) { return this.citoyens.removeIf(c -> c.getCIN().equals(cin)); }

    public void addAgent(Agent a) { this.agents.add(a); }
    public boolean removeAgentByCIN(String cin) { return this.agents.removeIf(a -> a.getCIN().equals(cin)); }

    public void addSecretaire(Secretaire s) { this.secretaires.add(s); }
    public boolean removeSecretaireByCIN(String cin) { return this.secretaires.removeIf(s -> s.getCIN().equals(cin)); }

    public void addChefGenerale(ChefGenerale c) { this.chefsGeneraux.add(c); }
    public void addChefInformatique(ChefInformatique c) { this.chefsInformatiques.add(c); }

    public void addDemande(Demande d) { this.demandes.add(d); }
    public boolean removeDemandeById(Integer id) { return this.demandes.removeIf(d -> d.getIdentifiant().equals(id)); }

    public void addNotification(Notification n) { this.notifications.add(n); }
    public boolean removeNotificationById(Integer idN) { return this.notifications.removeIf(n -> n.getIdN().equals(idN)); }

    public void addRapport(RapportDeTravaille r) { this.rapportsDeTravaille.add(r); }
    public boolean removeRapportByInterventionRef(Integer ref) { return this.rapportsDeTravaille.removeIf(r -> r.getInterventionRef().equals(ref)); }

    public void addIntervention(Intervention i) { this.interventions.add(i); }
    public boolean removeInterventionById(Integer id) { return this.interventions.removeIf(i -> i.getId().equals(id)); }
}
