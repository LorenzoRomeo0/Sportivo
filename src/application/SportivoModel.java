package application;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SportivoModel {
	List<Sportivo> sportivi;
	DAOSportivo dao;
	
	
	SportivoModel(){
		dao=new DAOSportivo("root", "");
		sportivi=dao.getSportivi();
	}
	
	public void inserisci(String nome, String cognome, String codice, String sport) {
		if(codice.matches("^[A-Za-z]{6}[0-9]{2}[A-Za-z]{1}[0-9]{2}[A-Za-z]{1}[0-9]{3}[A-Za-z]{1}"))
			dao.setSportivo(new Sportivo(nome, cognome, codice,sport));
		else
			System.out.println("Codice fiscale non valido");
	}
	
	public ObservableList<Sportivo> cerca(String sport){
		ObservableList<Sportivo> list=FXCollections.observableList(dao.getSportivi(sport));
		return (ObservableList<Sportivo>) list;
	}
	
	public ObservableList<String> getSport(){
		ObservableList<String> list=FXCollections.observableList(dao.getSport());
		return (ObservableList<String>) list;
	}
	
	public boolean codiceFiscale(String codice) {
		boolean b=false;
		for(Sportivo s:dao.getSportivi()) {
			if(s.getCodiceFiscale().equals(codice)) {
				b=true;
				break;
			}
		}
		return b;
	}
	
	public void delete(String codice) {
		System.out.println(codice);
		dao.delSportivo(codice);
	}
	
	
}
