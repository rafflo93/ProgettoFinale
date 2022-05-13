package com.fastcode.projectwork.utility;

import java.io.File;
import java.util.Scanner;

public class Vik {

	//creiamo un metodo che scorra i file e li restituisca:
		public static String leggiHTML(String nomeFile) {
			String ris = "";
			try {
				//andrà a leggere dentro viste, in webapp
				//la stringa verrà poi inviata al browser.
				Scanner file = new Scanner(new File("src\\main\\webapp\\" + nomeFile));
				while(file.hasNextLine()) {
					ris += file.nextLine();
				}
				file.close();
			} catch(Exception e) {
				System.out.println("404 - File non trovato al percorso " + "src\\main\\webapp\\" + nomeFile);
				e.printStackTrace();
			}
			return ris;
		}

}
