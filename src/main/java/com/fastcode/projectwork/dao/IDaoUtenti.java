package com.fastcode.projectwork.dao;

import java.util.List;
import java.util.Map;

import com.fastcode.projectwork.entities.Utente;

public interface IDaoUtenti {
	
	public List<Utente> listaUtenti();
	
	public Utente leggiUtente(int id);
	
	public Utente aggiungiUtente(Map<String,String> u);
	
	public boolean aggiornaUtente(Map<String,String> u);
	
	public boolean eliminaUtente(int idUtente);

}
