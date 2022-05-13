package com.fastcode.projectwork.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcode.projectwork.dao.DaoUtenti;
import com.fastcode.projectwork.entities.Utente;


@Controller
@RequestMapping("/utente")
public class UtenteController {
		
		// inietta in dao le proprietà dell'oggetto tramite il bean
		// contenuto in context;
		@Autowired
		private DaoUtenti daoUtente;
			
		
		
		
		@GetMapping("/elencoUtenti")
		@ResponseBody
		public String elenco() {
			return daoUtente.listaUtenti() + "";			
		}
		
		
		@GetMapping("/nuovoutente")
		@ResponseBody
		public String nuovoUtente(@RequestParam Map<String,String> m) {			
			Utente u = daoUtente.aggiungiUtente(m);			
			return u.toString();
		}
		
		
		@GetMapping("/inserisciutente")
        public String nuovoUtente(@RequestParam("username") String username,
        		@RequestParam("email")String email,
        		@RequestParam("password")String password, HttpSession session) {
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("username", username);
			
			map.put("email", email);
			
			map.put("password", password);
			
			daoUtente.aggiungiUtente(map);
			session.setAttribute("login", "OK");
            session.setAttribute("username", map.get("username"));
			return "redirect:/";	
		}
        
}

