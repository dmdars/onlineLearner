package de.unidue.inf.is.domain;

public class Benutzer extends Kurs {
 
 private int bnummer;
 private String email;
 private String bname;
 
 public Benutzer() {}
 
 public int getBnummer() {
  return bnummer;
 }
 public void setBnummer(int bnummer) {
  this.bnummer = bnummer;
 }
 public String getEmail() {
  return email;
 }
 public void setEmail(String email) {
  this.email = email;
 }
 public String getBname() {
  return bname;
 }
 public void setBname(String name) {
  this.bname = name;
 }
}