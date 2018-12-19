package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SportivoController {
	boolean disciplinaIscrizione=false;
	boolean disciplinaCerca=false;
	SportivoModel model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputCognome;

    @FXML
    private TextField inputCodice;

    @FXML
    private ComboBox<String> comboSport;

    @FXML
    private Button btnInserisci;

    @FXML
    private ComboBox<String> selectSport;

    @FXML
    private Button btnCerca;

    @FXML
    private TableView<Sportivo> table;

    @FXML
    private TableColumn<Sportivo, String> coumnNome;

    @FXML
    private TableColumn<Sportivo, String> columnCognome;

    @FXML
    private TableColumn<Sportivo, String> columnCodice;

    @FXML
    private TextField inputElimina;

    @FXML
    private Button btnElimina;

    @FXML
    void cerca(ActionEvent event) {
    	ObservableList<Sportivo> o=model.cerca(selectSport.getValue());
    	table.setItems(o);
    }

    @FXML
    void elimina(ActionEvent event) {
    	if(!inputElimina.getText().isEmpty()) {
    		model.delete(inputElimina.getText());
    		inputElimina.clear();
    		System.out.println("tttret");
    		ObservableList<Sportivo> o=model.cerca(selectSport.getValue());
        	table.setItems(o);
    	}
    }

    @FXML
    void disciplinaIscrizione(ActionEvent event) {
    	disciplinaIscrizione=true;
    	btnInserisci.setDisable(false);
    }
    @FXML
    void disciplinaCerca(ActionEvent event) {
    	disciplinaCerca=true;
    	btnCerca.setDisable(false);
    }
    
    @FXML
    void inserisci(ActionEvent event) {
    	if(!(inputNome.getText().isEmpty() || inputCognome.getText().isEmpty() || inputCodice.getText().isEmpty() || model.codiceFiscale(inputCodice.getText()))) {
    		if(disciplinaIscrizione) {
    			model.inserisci(inputNome.getText(),inputCognome.getText(), inputCodice.getText(),comboSport.getValue());
    			inputNome.clear();
    			inputCognome.clear();
    			inputCodice.clear();
    		}
    	}
    }

    @FXML
    void initialize() {
        assert inputNome != null : "fx:id=\"inputNome\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert inputCognome != null : "fx:id=\"inputCognome\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert inputCodice != null : "fx:id=\"inputCodice\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert comboSport != null : "fx:id=\"comboSport\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert selectSport != null : "fx:id=\"selectSport\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert coumnNome != null : "fx:id=\"coumnNome\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert columnCognome != null : "fx:id=\"columnCognome\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert columnCodice != null : "fx:id=\"columnCodice\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert inputElimina != null : "fx:id=\"inputElimina\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        assert btnElimina != null : "fx:id=\"btnElimina\" was not injected: check your FXML file 'SportivoIscrizione.fxml'.";
        model=new SportivoModel();
        btnInserisci.setDisable(true);
        btnCerca.setDisable(true);
        comboSport.getItems().addAll(model.getSport());
        selectSport.getItems().addAll(model.getSport());
        
        coumnNome.setCellValueFactory(new PropertyValueFactory<Sportivo, String>("nome"));
    	columnCognome.setCellValueFactory(new PropertyValueFactory<Sportivo, String>("cognome"));
    	columnCodice.setCellValueFactory(new PropertyValueFactory<Sportivo, String>("codiceFiscale"));
    }
}