package de.unidue.inf.is.domain;

public class Aufgabe {
	private int kid;
	private int anummer;
	private String name;
	private String beschreibung;
	
	public Aufgabe() {}
	
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public int getAnummer() {
		return anummer;
	}
	public void setAnummer(int anummer) {
		this.anummer = anummer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
}
