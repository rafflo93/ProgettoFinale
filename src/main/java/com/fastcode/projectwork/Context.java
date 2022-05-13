package com.fastcode.projectwork;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;


import com.fastcode.projectwork.dao.DaoEsercizi;
import com.fastcode.projectwork.dao.DaoUtenti;
import com.fastcode.projectwork.dao.Database;
import com.fastcode.projectwork.entities.Utente;

@Configuration
public class Context {




	@Bean
	public Database db() {

		return new Database();
	}


	@Bean
	public DaoUtenti daoUtenti() {

		return new DaoUtenti(db());
	}
	
	@Bean
	public DaoEsercizi daoEsercizi() {

		return new DaoEsercizi(db());
	}

	@Bean
	@Scope("prototype")
	public Utente utentiMappa(Map<String,String> m) {
		return new Utente(m);
	}


}
