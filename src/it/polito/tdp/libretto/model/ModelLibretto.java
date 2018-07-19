package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

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
	public void addEsame(Esame e) {
		if(!esami.contains(e)) {
			esami.add(e);
		}else {
			throw new IllegalStateException("L'esame di codice " + e.getCodice() + " è già inserito");
		}
	}
	
	/**
	 * Ritorna l'oggetto esame corrispondente al codice di corso passato
	 * se il codice non è presente ritorna null
	 * @param codice esame da ricercare
	 * @return esame trovato oppure null
	 */
	public Esame findEsame(String codice) {
		Esame esameProva = new Esame(codice, "titolo", "docente");
		int indice = this.esami.indexOf(esameProva);
		if(indice != -1) {
			return this.esami.get(indice);
		}else {
			return null;
		}
		
	}

}
