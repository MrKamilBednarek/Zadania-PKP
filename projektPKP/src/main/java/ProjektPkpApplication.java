
import model.Cytat;
import org.springframework.web.client.RestTemplate;
import service.getKanyeQuoteImpl;

import java.util.ArrayList;
import java.util.Scanner;


public class ProjektPkpApplication {

    public static void main(String[] args) {
        Cytat madroscKanye;
        getKanyeQuoteImpl imp=new getKanyeQuoteImpl(new RestTemplate());
        Scanner scanner = new Scanner(System.in);
        String linia=" ";
        ArrayList<String> cytaty = new ArrayList<String>();
        System.out.println("Write \"next\" to get a piece of Kanye wisdom or \"exit\" to finish program.");
        while(cytaty.size()<122 && !linia.equalsIgnoreCase("exit")){
            linia=scanner.nextLine();
            if (linia.equalsIgnoreCase("next")){
                madroscKanye=imp.getOneQuote();
                while(cytaty.contains(madroscKanye.getQuote())) {
                    madroscKanye=imp.getOneQuote();
                }
                cytaty.add(madroscKanye.getQuote());
                System.out.println(madroscKanye.getQuote());
            }
        }
        if(cytaty.size()==122){
        System.out.println("You've got all Kanye quotes.");}
        scanner.close();
    }

}
