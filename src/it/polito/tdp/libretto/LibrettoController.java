package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.ModelLibretto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	private ModelLibretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtMessage;

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	if(codice.length() < 5) {
    		txtMessage.appendText("Codice immesso non valido.\n");
    		return;
    	}
    	Esame e = model.findEsame(codice);
    	if(e == null) {
    		txtMessage.appendText("Esame con codice " + codice + " non trovato");
    	}else {
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}

    }

    @FXML
    void handleInserisci(ActionEvent event) {

    	//recupera i dati dalla vista
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	//verifica validità minima dei dati
    	if(codice.length() < 5 || titolo.length() == 0 || docente.length() == 0) {
    		txtMessage.appendText("Dati immessi non corretti.\n");
    		return;
    	}
    	
    	//chiedi al model di eseguire l'operazione
    	Esame e = new Esame(codice, titolo, docente);
    	try {
    		model.addEsame(e);
    	}catch(IllegalStateException ex){
    		txtMessage.appendText(ex.getMessage() + "\n");
    		return;
    	}
    	
    	//aggiorna la vista con il risultato della operazione
    	txtMessage.appendText("Esame correttamente inserito.\n");
    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }

	public void setModel(ModelLibretto model) {
		this.model = model;
	}
}


