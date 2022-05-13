package com.fastcode.projectwork.controllers;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcode.projectwork.dao.DaoEsercizi;
import com.fastcode.projectwork.utility.Vik;

@Controller
@RequestMapping("/lezioni")
public class EserciziController {
//	private Database db;

	
//public DaoEsercizi(Database db) {
//		
//		this.db = db;
//		
//	}
	
	@Autowired
	DaoEsercizi daoEsercizi;

	/*@GetMapping("/esercizi")
	public String elencoEsercizi() {
	
			return "listaEsercizi.html";
		
	}*/
	
//	@GetMapping("/esercizi")
//	public String leggiEsercizi() {
//    	List<Map<String, String>> listEsercizi = db.read("select count(*) testoesercizio from Esercizi");
//    	return listEsercizi.get(0).get("testoesercizio");	
//    }
	
	
	@GetMapping("/count")
	@ResponseBody
	public String count() {
		return daoEsercizi.leggiEsercizi();
	}
	
	
	@GetMapping("/eserciziSQL")
	@ResponseBody
	public List<Map<String,String>> sqlBase() {
		return daoEsercizi.leggiSqlBase();
	
	}
	
	
	@GetMapping("/eserciziJava")
	@ResponseBody
	public List<Map<String,String>> javaBase() {
		return daoEsercizi.leggiJavaBase();
	}


	//	@GetMapping("listaesercizi")

	//localhost:8080/lezioni/leggi?id=1
//	@GetMapping("/leggi")
//	@ResponseBody
//	public String leggi(HttpSession session) {
//		//@RequestParam("id") int idEsercizio) {
//		String username = (String) session.getAttribute("username");
//		int p;
//		try {
//			int o = daoEsercizi.getUtente(username);
//
//			p =	daoEsercizi.getProgresso(o);
//		} catch(Exception e) {
//			p = 1;
//		}
//
//
//		String ris = "";
//		try {
//			Scanner file = new Scanner(new File("src\\main\\webapp\\lezioni\\Esercizio.html"));
//
//			while(file.hasNextLine()) {
//				ris += file.nextLine();
//			}
//			ris = ris.replace("[testo]", daoEsercizi.getTestoEsercizio(p));
//
//			file.close();
//		} catch(Exception e) {
//			System.out.println("404 - File non trovato al percorso");
//		}
//
//		return ris;
//	}

	
	@GetMapping("/leggi")
    @ResponseBody
    public String leggi(@RequestParam("id") int idEsercizio) {
       // return daoEsercizi.getTestoEsercizio(idEsercizio);
		
		
		
        String ris = "";
		try {
			Scanner file = new Scanner(new File("src\\main\\webapp\\lezioni\\Esercizio.html"));

			while(file.hasNextLine()) {
				ris += file.nextLine();
			}
			ris = ris.replace("[testo]", daoEsercizi.getTestoEsercizio(idEsercizio));

			file.close();
		} catch(Exception e) {
			System.out.println("404 - File non trovato al percorso");
		}

		return ris;
	}
	
	@GetMapping("/esercizi") 
	@ResponseBody
	public String noLogin(HttpSession session) {
		String ris = Vik.leggiHTML("header.html");
		String ris2 = Vik.leggiHTML("lezioni/listaEsercizi.html");
		String ris3= Vik.leggiHTML("footer.html");
		
		if (session.getAttribute("login") != null) {

			ris = ris.replace("[cambia]", "<a class=\"nav__link\" href=\"/logout\">LOGOUT</a>");
		} 
		else {
			ris = ris.replace("[cambia]", "<a class=\"btn nav__btn btn--oranged\" href=\"/formlogin\">Login</a><a class=\"btn nav__btn btn--blue\" href=\"/registrati\">Registrati</a>");		
		}	
		
		ris2 = ris2.replace("[header]", ris);
		ris2 = ris2.replace("[footer]", ris3);
        
		return ris2;
	}
	
		

		


}




