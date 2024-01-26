package no.hvl.data102.filmarkiv2.klient;

import no.hvl.data102.filmarkiv2.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv2.impl.Filmarkiv2;

public class FilmarkivMain {

	public static void main(String[] args) {
		FilmarkivADT filma = new Filmarkiv2();
		Meny meny = new Meny(filma);
		meny.start();
		}
	
}
