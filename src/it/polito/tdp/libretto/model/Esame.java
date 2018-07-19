package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Oggetto semplice che contiene dati relativi ad
 * un singolo esame.
 * POJO - plain old java object
 * ovvero oggetto che contiene:
 * dati privati (proprietà)
 * costruttore
 * metodi get/set
 * metodi di servizio (toString, equals, hashCode, compareTo)
 * 
 * @author Tany
 *
 */
public class Esame {

	private String codice;	//codice alfa numerico del corso
	private String titolo;	//titolo/denominazione del corso
	private String docente;	//in realtà sarebbe private Docente docente;
	
	private boolean superato;	//l'esame è superato o meno
	private int voto;			//se è superato, quale voto
	private LocalDate dataSuperamento;	//data superamento esame
	/**
	 * genera un nuovo esame con isOvercome settato a false
	 * 
	 * @param codice dell'esame
	 * @param titolo denominazione dell'esame
	 * @param docente Nome e Cognome del titolare
	 */
	public Esame(String codice, String titolo, String docente) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		this.superato = false;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public boolean isSuperato() {
		return superato;
	}
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}
	public int getVoto() {
		if(isSuperato())
			return voto;
		else {
			throw new IllegalStateException("Esame " + this.codice + " non ancora superato");
		}
	}
	private void setVoto(int voto) {
		this.voto = voto;
	}
	public LocalDate getDataSuperamento() {
		if(isSuperato())
			return dataSuperamento;
		else {
			throw new IllegalStateException("Esame " + this.codice + " non ancora superato");
		}
	}
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}
	
	@Override
	public String toString() {
		if(this.isSuperato()) {
			return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
		}else {
			return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + "]";
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/**
	 * Se l'esame non è superato, lo considera tale fornendo
	 * voto e data di superamento.
	 * Se invece superato genera Eccezione
	 * 
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data) {
		if(isSuperato())
			throw new IllegalStateException("Esame " + this.codice + " già superato.");
		else {
			this.setSuperato(true);
			this.setVoto(voto);
			this.setDataSuperamento(data);
		}
	}
}
