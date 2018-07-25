package it.polito.tdp.libretto.model;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.db.EsameDAO;

public class ModelLibretto {
	private List<Esame> esami;
	
	public ModelLibretto() {
		esami = new ArrayList<Esame>();
		
	}
	
	/**
	 * Aggiunge alla lista esami un nuovo corso e
	 * verificando che esso non sia presente
	 * nel caso l'esame passato sia già inserito solleva eccezione IllegalStateException
	 * @param e
	 * 
	 */
	public boolean addEsame(Esame e) {
		EsameDAO dao = new EsameDAO();
		
		return dao.create(e);
		
			
	}
	
	/**
	 * Ritorna l'oggetto esame corrispondente al codice di corso passato
	 * se il codice non è presente ritorna null
	 * @param codice esame da ricercare
	 * @return esame trovato oppure null
	 */
	public Esame findEsame(String codice) {
		EsameDAO dao = new EsameDAO();
		Esame e = dao.find(codice);
		return e;
		
		
	}

}
