package de.unidue.inf.is.domain;

public class Bewerten extends Einschreiben{

	public Bewerten() {}
	
	private int bnummer;
	private int aid;
	private int note;
	private String kommentar;
	public int getBnummer() {
		return bnummer;
	}
	public void setBnummer(int bnummer) {
		this.bnummer = bnummer;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
}
