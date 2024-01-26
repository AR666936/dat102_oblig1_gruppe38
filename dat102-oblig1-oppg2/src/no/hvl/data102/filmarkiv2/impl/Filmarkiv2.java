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
	public Film finnFilm(int filmnr) {
		LinearNode<Film> s = start;
		while (s != null) {
			if (s.data.getFilmNr() == filmnr) {
				return s.data;
			}
			s = s.neste;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> newNode = new LinearNode<>(nyFilm);
		newNode.neste = start;
		start = newNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if (finnFilm(filmnr) == null) {
			return false;
		}
		
		LinearNode<Film> s = start;
		s.data = finnFilm(filmnr);
		s = s.neste;
		antall--;
		return true;
		
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		
		Film[] resultater = new Film[antall];
		int antallResultater = 0;
		LinearNode<Film> s = start;
		
		while (s != null) {
			if (s.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				resultater[antallResultater] = s.data;
				antallResultater++;
			}
			s = s.neste;
		}
		return Arrays.copyOf(resultater, antallResultater);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		
		Film[] resultater = new Film[antall];
		int antallResultater = 0;
		LinearNode<Film> s = start;
		
		while (s != null) {
			if (s.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				resultater[antallResultater] = s.data;
				antallResultater++;
			}
			s = s.neste;
		}
		return Arrays.copyOf(resultater, antallResultater);
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		int resultater = 0;
		LinearNode<Film> s = start;
		
		while(s != null) {
			if (s.data.getSjanger() == sjanger) {
				resultater++;
			}
			s = s.neste;
		}
		return resultater;
	}

	@Override
	public int antall() {
		return antall;
	}

}
