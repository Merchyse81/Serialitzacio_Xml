package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.xml.model.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.xml.model.domain.Cotxe;

public class CotxeSerialitzacioRepository {
	
	 private CotxeSerialitzacioRepository() {
		 
		 serialitzador = CommonSerialitzacioXmlRepository.getInstance();
		 }
	 
	 public static CotxeSerialitzacioRepository getInstance() {
	        if (instance == null) {
	            instance = new CotxeSerialitzacioRepository();
	        }
	        return instance;
	    }

	 private static CotxeSerialitzacioRepository instance = null;

	 private CommonSerialitzacioXmlRepository serialitzador;
	 
	 public void serialitzacioUnCotxe(Cotxe cotxe, String nomFitxer) throws IOException {
			serialitzador.serialitza(cotxe, nomFitxer);
		}

		public Cotxe deserialitzaUnCotxe(String nomFitxer) throws IOException, ClassNotFoundException {
			return (Cotxe) serialitzador.deserialitza(nomFitxer);
		}

		public void serialitzaLlistaCotxes(List<Cotxe> cotxes, String nomFitxer) throws IOException {
			serialitzador.serialitza(cotxes, nomFitxer);
		}

		public List<Cotxe> deserialitzaLlistaAlumnes(String nomFitxer) throws IOException, ClassNotFoundException {
			Object object = serialitzador.deserialitza(nomFitxer);
			List<Cotxe> resultat = new ArrayList<>();
			if (object != null && object instanceof Cotxe[]) {
				for (Cotxe cotxe : (Cotxe[]) object) {
					resultat.add(cotxe);
				}
			}
			return resultat;
		}
}

	 
	    


