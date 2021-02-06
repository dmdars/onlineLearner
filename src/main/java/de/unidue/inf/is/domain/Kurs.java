package de.unidue.inf.is.domain;

public class Kurs {

	private int kid;
	private String name;
	private String beschreibungstext;
	private String einschreibeschluessel;
	private int freiePlaetze;
	private int ersteller;
	
	public Kurs(){}
	
	public Kurs(int kid, String name, String beschreibungstext, String einschreibeschluessel, int freiePlaetze, int ersteller)
	{
		this.kid=kid;
		this.name=name;
		this.beschreibungstext=beschreibungstext;
		this.einschreibeschluessel=einschreibeschluessel;
		this.freiePlaetze=freiePlaetze;
		this.ersteller=ersteller;
	}
	
	public int getKid() {
		return kid;
	}
	
	public void setKid(int kid) {
		this.kid = kid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBeschreibungstext() {
		return beschreibungstext;
	}
	public void setBeschreibungstext(String beschreibungstext) {
		this.beschreibungstext = beschreibungstext;
	}
	
	public String getEinschreibeschluessel() {
		return einschreibeschluessel;
	}
	
	public void setEinschreibeschluessel(String einschreibeschluessel) {
		this.einschreibeschluessel = einschreibeschluessel;
	}

	public int getFreiePlaetze() {
		return freiePlaetze;
	}
	
	public void setFreiePlaetze(int freiePlaetze) {
		this.freiePlaetze = freiePlaetze;
	}

	public int getErsteller() {
		return ersteller;
	}
	
	public void setErsteller(int ersteller) {
		this.ersteller = ersteller;
	}
}