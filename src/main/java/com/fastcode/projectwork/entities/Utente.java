package com.fastcode.projectwork.entities;

import java.util.LinkedHashMap;
import java.util.Map;

public class Utente {

	
	private int idUtente;
	private String username;
	private String email;
	private String password;
	
	
	
	public Utente(Map<String,String> m) {
		
		if(m.containsKey("id"))
			setIdUtente(Integer.parseInt(m.get("id")));
		if(m.containsKey("username"))
            setUsername(m.get("username"));	
		if(m.containsKey("email"))
            setEmail(m.get("email"));	
		if(m.containsKey("password"))
            setPassword(m.get("password"));
		
	}
	
	
	
	public Utente() {
		
		
	}
	
	public static Utente fromMap(Map<String,String> m) {
		
		return new Utente(m);
	}
	
	public Map<String,String> toMap(Utente u) {
		
		Map<String,String> ris = new LinkedHashMap<String,String>();
		ris.put("id", u.getIdUtente() + "");
		ris.put("username", u.getUsername());
		ris.put("email", u.getEmail());
		ris.put("password", u.getPassword());
		
		return ris;
		
	}
	

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Id utente: " + idUtente + "\n" + "Username: " + username + "\n" + "Email: " + email + "\n" + "Password: " + password
				+ "\n";
	}
	
	
	
	
	
	
}
