package com.fastcode.projectwork.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcode.projectwork.dao.DaoEsercizi;

@Controller
@RequestMapping("/esercizio")
public class EserciziController {
	@Autowired
	DaoEsercizi daoEsercizi;
	
	
	@GetMapping("/count")
	@ResponseBody
	public String count() {
		return daoEsercizi.leggiEsercizi();
	}
	@GetMapping("/count/sqlbase")
	@ResponseBody
	public List<Map<String,String>> sqlBase() {
		return daoEsercizi.leggiSqlBase();
	
	}@GetMapping("/count/javabase")
	@ResponseBody
	public List<Map<String,String>> javaBase() {
		return daoEsercizi.leggiJavaBase();
	}
	//localhost:8080/esercizio/leggi?id=1
	@GetMapping("/leggi")
	@ResponseBody
	public String leggi(@RequestParam("id") int idEsercizio) {
		return daoEsercizi.getTestoEsercizio(idEsercizio);
	}
}
