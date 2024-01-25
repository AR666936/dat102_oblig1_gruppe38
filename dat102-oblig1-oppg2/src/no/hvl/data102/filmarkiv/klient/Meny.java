package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import static java.lang.Integer.parseInt;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	public Meny(FilmarkivADT filmarkiv){
	tekstgr = new Tekstgrensesnitt();
	this.filmarkiv = filmarkiv;
	}
	public void start(){
	// legg inn en del forhåndsdefinerte filmer for å teste metodene
	
		
		Scanner input = new Scanner(System.in);
		String valg = null;
		
        do {
        	
        System.out.println("1) Legg til film");
		System.out.println("2) Skriv ut film");
		System.out.println("3) Søk tittel");
		System.out.println("4) Søk produsent");
		System.out.println("5) Statistikk");
		System.out.println("6) Slett film");
		System.out.println("7) Avslutt");
		
            valg = input.nextLine();
            
            switch (valg) {
                case "1":
                    filmarkiv.leggTilFilm(tekstgr.lesFilm());
                    break;
                case "2":
                	System.out.println("Velg film (film nr): ");
                    tekstgr.skrivUtFilm(filmarkiv.finnFilm(parseInt(input.nextLine())));
                    break;
                case "3":
                	System.out.println("Skriv tittel: ");
                	tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, input.nextLine());
                    break;
                case "4":
                	System.out.println("Skriv produsent: ");
                	tekstgr.skrivUtFilmProdusent(filmarkiv, input.nextLine());
                    break;
                case "5":
                	tekstgr.skrivUtStatistikk(filmarkiv);
                    break;     
                case "6":
                	System.out.println("Velg film (film nr): ");
                	if(filmarkiv.slettFilm(parseInt(input.nextLine()))) {
                		System.out.println("Vellykket");
                	} else {
                		System.out.println("Finner ingen filmer med det nr.");
                	}
                	break;
            }
             
        } while (!valg.equals("7"));
		
		input.close();
		
	}
	
}
