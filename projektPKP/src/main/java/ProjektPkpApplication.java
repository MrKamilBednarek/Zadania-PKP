
import model.OneQuote;
import org.springframework.web.client.RestTemplate;
import service.getKanyeQuoteImpl;

import java.util.ArrayList;
import java.util.Scanner;


public class ProjektPkpApplication {

    public static void main(String[] args) {
        OneQuote kanyeWisdom;
        getKanyeQuoteImpl imp=new getKanyeQuoteImpl(new RestTemplate());
        Scanner scanner = new Scanner(System.in);
        String line=" ";
        ArrayList<String> quotesList = new ArrayList<>();
        System.out.println("Write \"next\" to get a piece of Kanye wisdom or \"exit\" to finish program.");
        while(quotesList.size()<122 && !line.equalsIgnoreCase("exit")){
            line=scanner.nextLine();
            if (line.equalsIgnoreCase("next")){
                kanyeWisdom=imp.getOneQuote();
                while(quotesList.contains(kanyeWisdom.getQuote())) {
                    kanyeWisdom=imp.getOneQuote();
                }
                quotesList.add(kanyeWisdom.getQuote());
                System.out.println(kanyeWisdom.getQuote());
            }
        }
        if(quotesList.size()==122){
        System.out.println("You've got all Kanye quotes.");}
        scanner.close();
    }

}
