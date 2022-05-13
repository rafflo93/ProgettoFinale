package com.fastcode.projectwork.controllers;

import java.io.File;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fastcode.projectwork.dao.DaoUtenti;
import com.fastcode.projectwork.utility.Vik;

@Controller
public class HomeController {

	@Autowired
	DaoUtenti daoUtenti;

	@GetMapping("/test")
	@ResponseBody
	public String test() {
		return "FastCode ti dà il benvenuto";
	}

	@GetMapping("/certificazione")
	public String certificazione(HttpSession session) {
		if (session.getAttribute("login") == null) {
			return "redirect:/noLogin";      
		} else { 
			return "certificazione.html";
		}
	}

	/*@GetMapping("/noLogin") 
	public String noLogin() {
		return "noLogin.html";
	}*/

	//@GetMapping("/") 
	//public String home() {
	//	return "Index.html";
	//}

	/*@GetMapping("/formlogin")
	public String formLogin(HttpSession session) {
		if (session.getAttribute("login") == null) {
			return "formLogin.html";
		}
		else return "redirect:/"; 
	}*/

	@GetMapping("/login")
	public String login(@RequestParam("username") String u, @RequestParam("password") String p, HttpSession session) {

		if (daoUtenti.controllaLogin(u, p)) {
			session.setAttribute("login", "OK");
			session.setAttribute("username", u);

			return "redirect:/";
		} 
		else {
			return "redirect:/formlogin";
		} 		
	} 


	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("login", null);
		session.setAttribute("username", null);
		return "redirect:/";
	}


	/*@GetMapping("/registrati")
	public String registrati() {
		return "formnuovoutente.html";
	}*/


	
	
	//@GetMapping("/prova")
	//
	// public String homeLogin(HttpSession session) {
	//	String ris = Vik.leggiIndex("Index.html");
	//	if (session.getAttribute("login") == null) {
	//	System.out.println(session.getAttribute("login"));
			
	//	ris = ris.replace("\"[controlloLogin]\"", "<a class=\"btn nav__btn btn--oranged\" href=\"/formlogin\">Login</a> <a class=\"btn nav__btn btn--blue\" href=\"/registrati\">Registrati</a>");
	//	 System.out.println(ris);
	//	return "redirect:/";
		
	//}
	//else { 
			//	ris = ris.replace("[controlloLogin]", "<a class=\"nav__link\" href=\"/logout\">LOGOUT</a>");
	//	return "Index.html"; 
	//	}
		
	//}
	@GetMapping("/") 
	@ResponseBody
	public String home(HttpSession session) {
		String ris = Vik.leggiHTML("header.html");
		String ris2 = Vik.leggiHTML("Index.html");
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
  
	@GetMapping("/info") 
	@ResponseBody
	public String info(HttpSession session) {
		String ris = Vik.leggiHTML("header.html");
		String ris2 = Vik.leggiHTML("info.html");
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
		
	@GetMapping("/formlogin") 
	@ResponseBody
	public String formlogin(HttpSession session) {
		String ris = Vik.leggiHTML("header.html");
		String ris2 = Vik.leggiHTML("formLogin.html");
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
    
	@GetMapping("/registrati") 
	@ResponseBody
	public String registati(HttpSession session) {
		String ris = Vik.leggiHTML("header.html");
		String ris2 = Vik.leggiHTML("formnuovoutente.html");
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
	
	@GetMapping("/noLogin") 
	@ResponseBody
	public String noLogin(HttpSession session) {
		String ris = Vik.leggiHTML("header.html");
		String ris2 = Vik.leggiHTML("noLogin.html");
		
		if (session.getAttribute("login") != null) {

			ris = ris.replace("[cambia]", "<a class=\"nav__link\" href=\"/logout\">LOGOUT</a>");
		} 
		else {
			ris = ris.replace("[cambia]", "<a class=\"btn nav__btn btn--oranged\" href=\"/formlogin\">Login</a><a class=\"btn nav__btn btn--blue\" href=\"/registrati\">Registrati</a>");		
		}	
		
		ris2 = ris2.replace("[header]", ris);
        
		return ris2;
	}
}


