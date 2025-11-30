package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Agent;
import com.project.XmlCrud.Model.Municipalite;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.List;

@Service
public class AgentService {

    // CREATE
    public void addAgent(Agent agent) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addAgent(agent);  // ajoute dans <Agents>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<Agent> getAllAgents() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getAgents();
    }

    // READ BY CIN
    public Agent getAgentByCIN(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getAgents()
                .stream()
                .filter(a -> a.getCIN().equals(cin))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateAgent(Agent updatedAgent) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();

        for (int i = 0; i < municipalite.getAgents().size(); i++) {
            Agent a = municipalite.getAgents().get(i);

            if (a.getCIN().equals(updatedAgent.getCIN())) {
                municipalite.getAgents().set(i, updatedAgent);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteAgent(Integer cin) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.removeAgentByCIN(String.valueOf(cin));
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
