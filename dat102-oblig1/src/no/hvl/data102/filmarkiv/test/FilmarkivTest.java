package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {

	@Test
	void test() {
		
		Filmarkiv arkiv1 = new Filmarkiv(3); 
		
		Film a = new Film(1, "Jeffrey Katzenberg, Aron Warner, John H. Williams, Steven Spielberg", "Shrek", 2001, Sjanger.COMEDY, "DreamWorks");
		Film b = new Film(2, "Jeffrey Katzenberg", "Shrek 2", 2004, Sjanger.COMEDY, "DreamWorks");
		Film c = new Film(3, "Emma Thomas, Christopher Nolan, Lynda Obst", "Interstellar", 2014, Sjanger.SCIFI, "Paramount Pictures");
		
		arkiv1.leggTilFilm(a);
		arkiv1.leggTilFilm(b);
		arkiv1.leggTilFilm(c);
		
		System.out.println("Filmer: " + arkiv1.antall());
		System.out.println("Lengde: " + arkiv1.getArkiv().length);
		
		Film d = new Film(4, "Bla Bla", "Bla", 2000, Sjanger.DRAMA, "Bla Bla Bla");
		
		arkiv1.leggTilFilm(d);
		
		System.out.println("Filmer: " + arkiv1.antall());
		System.out.println("Lengde: " + arkiv1.getArkiv().length);
		
		System.out.println(arkiv1.finnFilm(3).getTittel());
		
		arkiv1.slettFilm(4);
		
		System.out.println("Filmer: " + arkiv1.antall());
		System.out.println("Lengde: " + arkiv1.getArkiv().length);
		
		Film[] resTittel = arkiv1.soekTittel("Shre");
		for (int i = 0; i < resTittel.length; i++) {
		System.out.println(resTittel[i].getTittel());
		}
	
		Film[] resProd = arkiv1.soekProdusent("Nolan");
		for (int i = 0; i < resProd.length; i++) {
		System.out.println(resProd[i].getTittel());
		}
		
		System.out.println(arkiv1.antall(Sjanger.COMEDY));
		System.out.println(arkiv1.antall(Sjanger.ACTION));
		
	}

}
