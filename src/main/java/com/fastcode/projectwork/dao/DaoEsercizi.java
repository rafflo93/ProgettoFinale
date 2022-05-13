package com.fastcode.projectwork.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class DaoEsercizi {


	private Database db;

	@Autowired
	public ApplicationContext context;





	public DaoEsercizi(Database db) {

		this.db = db;

	}


	//	public String getTestoEsercizio(int idEsercizio) {
	//		String ris = "Esercizio non trovato!";
	//		
	//		 List<Map<String, String>> l = db.read("select testoesercizio from Esercizi where id = ?", idEsercizio + "");
	//		 
	//		 if (!l.isEmpty()) {
	//			 ris = l.get(0).get("testoesercizio");
	//		 }
	//		 
	//		 return ris;
	//	}

	
	
	
	public String leggiEsercizi() {
    	List<Map<String, String>> listEsercizi = db.read("select count(*) testoesercizio from Esercizi");
    	return listEsercizi.get(0).get("testoesercizio");		
    }
	
	
	public List<Map<String,String>> leggiSqlBase() {
    	List<Map<String, String>> listEsercizi = db.read("select esercizi.id from Esercizi where idCorso = 2");
    	return listEsercizi;		
    }
	
	
    public List<Map<String,String>> leggiJavaBase() {
    	List<Map<String, String>> listEsercizi = db.read("select esercizi.id from Esercizi where idCorso = 1");
    	return listEsercizi;	
    }
    
    

	public String getTestoEsercizio(int idEsercizio) {
		String ris = "Esercizio non trovato!";

		List<Map<String, String>> l = db.read("select testoesercizio from Esercizi where id = ?", idEsercizio + "");

		if (!l.isEmpty()) {
			ris = l.get(0).get("testoesercizio");
		}

		return ris;
	}

	public int getProgresso(int idUtente) {
		List<Map<String, String>> l = db.read("select idEsercizio from progressi where idUtente = ?", idUtente + "");
		return (Integer.parseInt(l.get(0).get("idEsercizio")));
	}

	public int getUtente(String username) {
		List<Map<String, String>> l = db.read("select idUtente from utenti inner join progressi on idUtente = utenti.id where username = ?", username);
		return Integer.parseInt(l.get(0).get("idUtente"));
	}

}
