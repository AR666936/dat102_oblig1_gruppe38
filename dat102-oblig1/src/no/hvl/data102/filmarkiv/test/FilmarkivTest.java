package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {

	@Test
    public void leggTilOgFinnFilm() {
        Filmarkiv filmarkiv = new Filmarkiv(5);

        Film film = new Film(1, "Produsent", "Film", 0, Sjanger.ACTION, "Filmselskap");

        filmarkiv.leggTilFilm(film);

        assertEquals(film, filmarkiv.finnFilm(1));
    }
	
	@Test
	public void utvid() {
		Filmarkiv filmarkiv = new Filmarkiv(2);
		
		Film film1 = new Film(1, "Produsent", "Film", 0, Sjanger.SCIFI, "Filmselskap");
        Film film2 = new Film(2, "Produsent", "Film", 0, Sjanger.SCIFI, "Filmselskap");
        Film film3 = new Film(3, "Produsent", "Film", 0, Sjanger.DRAMA, "Filmselskap");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        
        assertEquals(4, filmarkiv.getArkiv().length);
	}

    @Test
    public void slettFilm() {
        Filmarkiv filmarkiv = new Filmarkiv(5);

        Film film = new Film(1, "Produsent", "Film", 0, Sjanger.ACTION, "Filmselskap");

        filmarkiv.leggTilFilm(film);

        assertTrue(filmarkiv.slettFilm(1));

        assertNull(filmarkiv.finnFilm(1));
    }

    @Test
    public void soekTittel() {
        Filmarkiv filmarkiv = new Filmarkiv(5);

        Film film1 = new Film(1, "Produsent", "abc", 0, Sjanger.SCIFI, "Filmselskap");
        Film film2 = new Film(2, "Produsent", "def", 0, Sjanger.SCIFI, "Filmselskap");
        Film film3 = new Film(3, "Produsent", "ghi", 0, Sjanger.DRAMA, "Filmselskap");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);

        assertArrayEquals(new Film[]{film1}, filmarkiv.soekTittel("ABc"));
    }
    
    @Test
    public void soekProdusent() {
        Filmarkiv filmarkiv = new Filmarkiv(5);

        Film film1 = new Film(1, "abc", "Film", 0, Sjanger.SCIFI, "Filmselskap");
        Film film2 = new Film(2, "def", "Film", 0, Sjanger.SCIFI, "Filmselskap");
        Film film3 = new Film(3, "ghi", "Film", 0, Sjanger.DRAMA, "Filmselskap");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);

        assertArrayEquals(new Film[]{film2}, filmarkiv.soekProdusent("De"));
    }

    @Test
    public void antallSjanger() {
        Filmarkiv filmarkiv = new Filmarkiv(5);

        Film film1 = new Film(1, "Produsent", "Film", 0, Sjanger.SCIFI, "Filmselskap");
        Film film2 = new Film(2, "Produsent", "Film", 0, Sjanger.SCIFI, "Filmselskap");
        Film film3 = new Film(3, "Produsent", "Film", 0, Sjanger.DRAMA, "Filmselskap");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);

        assertEquals(2, filmarkiv.antall(Sjanger.SCIFI));
    }
}
