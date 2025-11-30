package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Account;
import com.project.XmlCrud.Model.Citoyen;
import com.project.XmlCrud.Model.Agent;
import com.project.XmlCrud.Model.ChefGenerale;
import com.project.XmlCrud.Model.Secretaire;
import com.project.XmlCrud.Model.ChefInformatique;
import com.project.XmlCrud.Security.JwtUtil;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    private final JwtUtil jwtUtil;
    private final CitoyenService citoyenService;
    private final AgentService agentService;
    private final ChefGeneraleService chefGeneraleService;
    private final SecretaireService secretaireService;
    private final ChefInformatiqueService chefInfoService;

    

    public AuthService(JwtUtil jwtUtil,
                       CitoyenService citoyenService,
                       AgentService agentService,
                       ChefGeneraleService chefGeneraleService,
                       SecretaireService secretaireService,
                       ChefInformatiqueService chefInfoService) {
        this.jwtUtil = jwtUtil;
        this.citoyenService = citoyenService;
        this.agentService = agentService;
        this.chefGeneraleService = chefGeneraleService;
        this.secretaireService = secretaireService;
        this.chefInfoService = chefInfoService;
    }

    // Authentifier un utilisateur (login)
    public String login(String email, String password) {
    try {
        Optional<? extends Account> user =
            citoyenService.getAllCitoyens().stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst();

        if(user.isEmpty()) 
            user = agentService.getAllAgents().stream()
                .filter(a -> a.getEmail().equals(email))
                .findFirst();
        if(user.isEmpty()) 
            user = chefGeneraleService.getAllChefs().stream()
                .filter(cg -> cg.getEmail().equals(email))
                .findFirst();
        if(user.isEmpty()) 
            user = secretaireService.getAllSecretaires().stream()
                .filter(s -> s.getEmail().equals(email))
                .findFirst();
        if(user.isEmpty()) 
            user = chefInfoService.getAllChefs().stream()
                .filter(ci -> ci.getEmail().equals(email))
                .findFirst();

        if(user.isPresent() && user.get().getPassword().equals(password)) {
            return jwtUtil.generateToken(user.get().getEmail(), user.get().getRole());
        }

        throw new RuntimeException("Email ou mot de passe incorrect");

    } catch (Exception e) { // JAXBException, SAXException, ou IOException
        throw new RuntimeException("Erreur lors de la lecture des données XML", e);
    }
}
}