package com.fastcode.projectwork.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fastcode.projectwork.entities.Utente;



public class DaoUtenti implements IDaoUtenti{

	private Database db;

	@Autowired
	public ApplicationContext context;

	public DaoUtenti(Database db) {
		this.db = db;
	}


	@Override
	public List<Utente> listaUtenti() {
		List<Utente> listaUtenti = new ArrayList<Utente>();
		List<Map<String, String>> elenco = db.read("select * from utenti;");

		for(Map<String, String> mappa : elenco)
		{
			Object o = context.getBean("utentiMappa", mappa);
			if(o instanceof Utente) {
				Utente u = (Utente) o ;
				listaUtenti.add(u);
			}
		}
		return listaUtenti;
	}


	@Override
	public Utente aggiungiUtente(Map<String, String> mappaUtente) {

		boolean ris = db.update("insert into utenti (id,username,email,password) values (?,?,?,?)",
				mappaUtente.get("id"),
				mappaUtente.get("username"),
				mappaUtente.get("email"),
				mappaUtente.get("password"));
		Utente u;
		if(ris) {

			Map<String,String> map = db.read("select * from utenti order by id desc limit 1").get(0);
			u = (Utente) context.getBean("utentiMappa", map) ;

		}
		else
			u = (Utente) context.getBean(Utente.class);

		return u;
	}



	@Override
	public boolean aggiornaUtente(Map<String, String> u) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean eliminaUtente(int idUtente) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean controllaLogin(String username, String password) {
		boolean ris = false;

		List<Map<String, String>> l = db.read("select password from utenti where username = ?", username);

		if(!l.isEmpty()) {
			ris = l.get(0).get("password").equals(password); //true
		}
		return ris;
	}



	@Override
	public Utente leggiUtente(int id) {
		Utente u = new Utente();

		List<Map<String, String>> elenco = db.read("select * from utenti where id = ?;", id + "");

		if (!elenco.isEmpty())
		{
			Map<String, String> mappa = elenco.get(0);

			Object o = context.getBean("utentiMappa", mappa);

			if(o instanceof Utente)
				u = (Utente) o;
		}

		return u;
	}

}
