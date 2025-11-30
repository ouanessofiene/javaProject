package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Municipalite;
import com.project.XmlCrud.Model.Notification;
import jakarta.xml.bind.JAXBException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.util.List;
@Service
public class NotificationService {

    // CREATE
    public void addNotification(Notification notification) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        municipalite.addNotification(notification);  // ajoute dans <Notifications>
        XmlUtil.saveMunicipalite(municipalite);
    }

    // READ ALL
    public List<Notification> getAllNotifications() throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getNotifications();
    }

    // READ BY ID
    public Notification getNotificationById(Integer idN) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        return municipalite.getNotifications()
                .stream()
                .filter(n -> n.getIdN().equals(idN))
                .findFirst()
                .orElse(null);
    }

    // UPDATE
    public boolean updateNotification(Notification updatedNotification) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();

        for (int i = 0; i < municipalite.getNotifications().size(); i++) {
            Notification n = municipalite.getNotifications().get(i);

            if (n.getIdN().equals(updatedNotification.getIdN())) {
                municipalite.getNotifications().set(i, updatedNotification);
                XmlUtil.saveMunicipalite(municipalite);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean deleteNotification(Integer idN) throws JAXBException, SAXException {
        Municipalite municipalite = XmlUtil.loadMunicipalite();
        boolean removed = municipalite.removeNotificationById(idN);
        if (removed) {
            XmlUtil.saveMunicipalite(municipalite);
        }
        return removed;
    }
}
