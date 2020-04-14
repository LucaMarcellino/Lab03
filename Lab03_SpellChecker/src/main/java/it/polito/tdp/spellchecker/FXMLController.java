package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.*;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	private Dictionary dizionario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxLingua;

    @FXML
    private TextArea txtDaCorreggere;

    @FXML
    private Button spellCheckButton;

    @FXML
    private TextArea txtCorretto;

    @FXML
    private Label lblErrori;

    @FXML
    private Button clearTextButton;

    @FXML
    private Label lblStato;

    @FXML
    void doActivation(ActionEvent event) {
    	
    	dizionario.loadDictionary();
    	txtDaCorreggere.clear();
    	txtDaCorreggere.setDisable(false);
    	spellCheckButton.setDisable(false);
    	clearTextButton.setDisable(false);
    }

    @FXML
    void doClearText(ActionEvent event) {
    	txtDaCorreggere.clear();
    	txtCorretto.clear();
    	lblStato.setText("Spell Check Status:");
    	lblErrori.setText("Number of errors:");
    	txtDaCorreggere.setDisable(true);
    	spellCheckButton.setDisable(true);
    	clearTextButton.setDisable(true);
    	txtCorretto.setDisable(true);
    	
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	List<String> testo =new LinkedList<String>();
    	List<RichWord> testoErr ;
    	
    	dizionario.loadDictionary();
    	String inputText;
    	if(txtDaCorreggere.getText().isEmpty()) {
    		txtCorretto.appendText("Scrivi Figlio di puttana!");
    	}
    	inputText =txtDaCorreggere.getText().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	String array[]= inputText.split(" ");
    	for(int i=0;i<array.length;i++) {
    		testo.add(i, array[i]);
    	}
    	
    	testoErr=new LinkedList<RichWord>(dizionario.spellCheckText(testo));
    	
    	String s="";
    	for(RichWord rw : testoErr) {
    		s+=rw;
    	}
    	txtCorretto.appendText(s);
    	lblErrori.setText("Numero Errori: "+testoErr.size());
    	
    }

    @FXML
    void initialize() {
        assert boxLingua != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDaCorreggere != null : "fx:id=\"txtDaCorreggere\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spellCheckButton != null : "fx:id=\"spellCheckButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert clearTextButton != null : "fx:id=\"clearTextButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblStato != null : "fx:id=\"lblStato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Dictionary model) {
    	
    	txtDaCorreggere.setDisable(true);
    	txtDaCorreggere.setText("Selezionare una lingua");
    	
    	txtCorretto.setDisable(true);
    	boxLingua.getItems().addAll("English","Italiano");
    	
    	spellCheckButton.setDisable(true);
    	clearTextButton.setDisable(true);
 	
    	
    	this.dizionario = model;
    }
}