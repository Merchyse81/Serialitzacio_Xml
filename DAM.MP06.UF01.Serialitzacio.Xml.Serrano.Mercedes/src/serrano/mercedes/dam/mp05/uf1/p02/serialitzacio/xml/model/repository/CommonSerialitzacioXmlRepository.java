package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.xml.model.repository;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class CommonSerialitzacioXmlRepository {
	
	private CommonSerialitzacioXmlRepository() {

	}

	public static CommonSerialitzacioXmlRepository getInstance() {
		if (instance == null) {
			instance = new CommonSerialitzacioXmlRepository();
		}

		return instance;
	}

	private static CommonSerialitzacioXmlRepository instance = null;

	
	public void serialitza(Object object, String nomFitxer) throws IOException {

		FileOutputStream fileOutputStream = new FileOutputStream(nomFitxer + ".xml");
		XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
		xmlEncoder.writeObject(object);
		xmlEncoder.close();
	}

	
	public Object deserialitza(String nomFitxer) throws IOException, ClassNotFoundException {
		Object result = null;
		FileInputStream fileInputStream = new FileInputStream(nomFitxer + ".xml");
		XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
		result = xmlDecoder.readObject();
		xmlDecoder.close();
		return result;
	}

}
