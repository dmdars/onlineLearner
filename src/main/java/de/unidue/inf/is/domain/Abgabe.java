package de.unidue.inf.is.domain;

public class Abgabe extends Aufgabe {

	public Abgabe() {}
	
	private int aid;
	private String abgabeText;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAbgabetext() {
		return abgabeText;
	}
	public void setAbgabetext(String abgabeText) {
		this.abgabeText = abgabeText;
	}
}
