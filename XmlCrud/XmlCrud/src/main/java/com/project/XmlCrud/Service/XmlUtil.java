package com.project.XmlCrud.Service;

import com.project.XmlCrud.Model.Municipalite;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class XmlUtil {

    private static final String XML_FILE = "C:\\Users\\ASUS\\Desktop\\JavaProject\\XmlCrud\\XmlCrud\\src\\main\\resources\\Schema.xml";
    private static final String XSD_FILE = "C:\\Users\\ASUS\\Desktop\\JavaProject\\XmlCrud\\XmlCrud\\src\\main\\resources\\Schema.xsd";

    /**
     * Charge le schema XSD pour validation.
     */
    private static Schema loadSchema() throws SAXException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return schemaFactory.newSchema(new File(XSD_FILE));
    }

    /**
     * Déserialise le XML en objet Java Municipalite (pas de validation ici).
     */
    public static Municipalite loadMunicipalite() {
        try {
            JAXBContext context = JAXBContext.newInstance(Municipalite.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Municipalite) unmarshaller.unmarshal(new File(XML_FILE));
        } catch (JAXBException e) {
            throw new RuntimeException("Erreur lors du chargement du XML", e);
        }
    }

    /**
     * Sérialise l'objet Municipalite vers XML avec validation XSD.
     * Sauvegarde atomique pour éviter les fichiers tronqués.
     */
    public static void saveMunicipalite(Municipalite municipalite) {
        try {
            JAXBContext context = JAXBContext.newInstance(Municipalite.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            // Validation XSD
            Schema schema = loadSchema();
            marshaller.setSchema(schema);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshaller.marshal(municipalite, baos);

            // Marshal dans un fichier temporaire
            Path original = Path.of(XML_FILE);
            Path temp = Path.of(XML_FILE + ".tmp");
            marshaller.marshal(municipalite, temp.toFile());

            // Remplacer l'ancien fichier par le nouveau
            Files.move(temp, original, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);

        } catch (JAXBException e) {
            throw new RuntimeException("Erreur JAXB lors de la sauvegarde du XML", e);
        } catch (SAXException e) {
            throw new RuntimeException("Erreur de validation XSD", e);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la sauvegarde du XML", e);
        }
    }
}
