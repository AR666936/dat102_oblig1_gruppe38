package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {

	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(){
	
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Film nr: ");
		int filmNr = parseInt(input.nextLine());
		System.out.println("Produsent: ");
		String produsent = input.nextLine();
		System.out.println("Tittel: ");
		String tittel = input.nextLine();
		System.out.println("År: ");
		int lansering = parseInt(input.nextLine());
		System.out.println("Sjanger: ");
		Sjanger sjanger = Sjanger.finnSjanger(input.nextLine());
		System.out.println("Filmselskap: ");
		String filmselskap = input.nextLine();
		Film film = new Film(filmNr, produsent, tittel, lansering, sjanger, filmselskap);
		
		return film;
		
	}
	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		
		if(film == null) {
			System.out.println("Finner ingen filmer med det nr.");
		} else {
		
		System.out.println("Film nr: " + film.getFilmNr());
		System.out.println("Produsent: " + film.getProdusent());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("År: " + film.getLansering());
		System.out.println("Sjanger: " + film.getSjanger());
		System.out.println("Filmselskap: " + film.getFilmselskap());
		System.out.println();
		}
		
	}
	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
	
		Film[] resultat = arkiv.soekTittel(delstreng);
		System.out.println("Resultat: ");
		for(int i = 0; i < resultat.length; i++) {
			skrivUtFilm(resultat[i]);
			System.out.println();
		}
		System.out.println();
		
	}
	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
	
		Film[] resultat = arkiv.soekProdusent(delstreng);
		System.out.println("Resultat: ");
		for(int i = 0; i < resultat.length; i++) {
			skrivUtFilm(resultat[i]);
			System.out.println();
		}
		System.out.println();
	}
	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
	
		System.out.println("Antall filmer: " + arkiv.antall());
		System.out.println("Antall actionfilmer: " + arkiv.antall(Sjanger.ACTION));
		System.out.println("Antall dramafilmer: " + arkiv.antall(Sjanger.DRAMA));
		System.out.println("Antall historiefilmer: " + arkiv.antall(Sjanger.HISTORY));
		System.out.println("Antall scififilmer: " + arkiv.antall(Sjanger.SCIFI));
		System.out.println("Antall komediefilmer: " + arkiv.antall(Sjanger.COMEDY));
		System.out.println();
		
	}
	// osv ... andre metoder
	
}
