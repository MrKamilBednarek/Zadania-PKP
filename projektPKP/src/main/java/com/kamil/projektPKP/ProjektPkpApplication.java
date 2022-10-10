package com.kamil.projektPKP;

import com.kamil.projektPKP.Service.getKanyeQuoteImpl;
import com.kamil.projektPKP.model.Cytat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class ProjektPkpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektPkpApplication.class, args);
		Cytat madroscKanye;
		getKanyeQuoteImpl imp=new getKanyeQuoteImpl(new RestTemplate());
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> cytaty = new ArrayList<String>();
		System.out.println("Write \"next\" to get a piece of Kanye wisdom.");
		while(cytaty.size()<122){
			String linia=scanner.nextLine();
			if (linia.equalsIgnoreCase("next")){
				madroscKanye=imp.getOneQuote();
				while(cytaty.contains(madroscKanye.getQuote())) {
					madroscKanye=imp.getOneQuote();
				}
				cytaty.add(madroscKanye.getQuote());
				System.out.println(madroscKanye.getQuote());
			}
			System.out.println("Write \"next\" to get another piece of Kanye wisdom.");
		}
		System.out.println("You've got all Kanye quotes.");
		scanner.close();
	}

}
