package no.hvl.data102.filmarkiv2.impl;

import java.util.Arrays;

import no.hvl.data102.filmarkiv2.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private LinearNode<Film> start;
	private int antall;
	
	public Filmarkiv2() {
		this.start = null;
		this.antall = 0;
	}
	
	@Override
	public Film finnFilm(int nr) {
		for(Film s : arkiv) {
			if (s.getFilmNr() == 0) {
				return s;
			}
			
			if (s.getFilmNr() == nr) {
				return s;
			}
		}
		return null;
	}
	
	private void utvid() {
		Film[] nyttArkiv = new Film[2 * arkiv.length];
		System.arraycopy(arkiv, 0, nyttArkiv, 0, antall);
		arkiv = nyttArkiv;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == arkiv.length) {
			utvid();
		}
		arkiv[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		
		for (int i = 0; i < antall; i++) {
            if (arkiv[i].getFilmNr() == filmnr) {
                arkiv[i] = new Film();
                System.arraycopy(arkiv, i + 1, arkiv, i, antall - i - 1);
                antall--;
                return true;
            }
			
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		
		Film[] resultater = new Film[antall];
		int antallResultater = 0;
		
		for (int i = 0; i < antall; i++) {
			if (arkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				resultater[antallResultater] = arkiv[i];
				antallResultater++;
			}
		}
		return Arrays.copyOf(resultater, antallResultater);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		
		Film[] resultater = new Film[antall];
		int antallResultater = 0;
		
		for (int i = 0; i < antall; i++) {
			if (arkiv[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				resultater[antallResultater] = arkiv[i];
				antallResultater++;
			}
		}
		return Arrays.copyOf(resultater, antallResultater);
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		int resultater = 0;
		
		for (int i = 0; i < antall; i++) {
			if (arkiv[i].getSjanger() == sjanger) {
				resultater++;
			}
		}
		return resultater;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	@Override
	public Film[] getArkiv() {
		return arkiv;
	}
	
	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
		nytab[i] = tab[i];
		i++;
		}
		return nytab;
		}


}
