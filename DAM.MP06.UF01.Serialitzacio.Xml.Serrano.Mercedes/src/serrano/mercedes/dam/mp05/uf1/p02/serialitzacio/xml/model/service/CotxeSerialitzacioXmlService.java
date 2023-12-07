package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.xml.model.service;

import java.io.IOException;
import java.util.List;
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.xml.model.configuration.Settings;
import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.xml.model.domain.Cotxe;

public class CotxeSerialitzacioXmlService {
	
	private CotxeSerialitzacioXmlService() {
		
	}
	
	public static CotxeSerialitzacioXmlService getInstance() {
		if(instance == null) {
			instance = new CotxeSerialitzacioXmlService();
		}
		return instance;
	}
	
	private static CotxeSerialitzacioXmlService instance = null;

	public void serialitzaUnCotxe(Cotxe cotxe) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(Settings.FICHERO_COTXE_INDIVIDUAL + ".xml");
        XMLEncoder xmlEncoder = new XMLEncoder(fileOut);
        xmlEncoder.writeObject(cotxe);
        xmlEncoder.close();
    }
	
	public void serialitzaLlistaCotxes(List<Cotxe> cotxes) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(Settings.FICHERO_LLISTA_COTXES + ".xml");
        XMLEncoder xmlEncoder = new XMLEncoder(fileOut);
        xmlEncoder.writeObject(cotxes);
        xmlEncoder.close();
    }

    public Cotxe deserialitzaUnCotxe() throws IOException {
        FileInputStream fileIn = new FileInputStream(Settings.FICHERO_COTXE_INDIVIDUAL + ".xml");
        XMLDecoder xmlDecoder = new XMLDecoder(fileIn);
        Cotxe cotxe = (Cotxe) xmlDecoder.readObject();
        xmlDecoder.close();
        return cotxe;
    }

    public List<Cotxe> deserialitzaLlistaCotxes() throws IOException {
        FileInputStream fileIn = new FileInputStream(Settings.FICHERO_LLISTA_COTXES + ".xml");
        XMLDecoder xmlDecoder = new XMLDecoder(fileIn);
        List<Cotxe> cotxes = (List<Cotxe>) xmlDecoder.readObject();
        xmlDecoder.close();
        return cotxes;
    }

}
