package de.unidue.inf.is.domain;

public class Einschreiben extends Abgabe {

	public Einschreiben() {}
	
	private int bnummer;
	private int kid;
	
	public int getBnummer() {
		return bnummer;
	}
	public void setBnummer(int bnummer) {
		this.bnummer = bnummer;
	}
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}

}
