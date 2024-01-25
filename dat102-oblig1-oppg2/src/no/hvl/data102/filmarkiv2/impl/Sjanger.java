package no.hvl.data102.filmarkiv2.impl;

public enum Sjanger {
	
	ACTION, DRAMA, HISTORY, SCIFI, COMEDY;
	
	public static Sjanger finnSjanger(String navn) {
	for (Sjanger s : Sjanger.values()) {
	if (s.toString().equals(navn.toUpperCase())) {
	return s;
	}
	}
	return null;
	}

}
