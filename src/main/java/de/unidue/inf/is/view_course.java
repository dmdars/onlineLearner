package de.unidue.inf.is;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Kategorie;
import de.unidue.inf.is.domain.Kommentar;
import de.unidue.inf.is.domain.Projekt;
import de.unidue.inf.is.domain.Schreibt;
import de.unidue.inf.is.domain.Spenden;
import de.unidue.inf.is.stores.StoreException;
import de.unidue.inf.is.stores.UserStore;


public final class view_course extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {

		// Projekt, Details und Kommentare fuer eine bestimmte Projekt zeigen
		
        Projekt projekt = new Projekt();
        List<Kommentar> kommentar = new ArrayList<Kommentar>();
        
        request.setAttribute("pagetitle", "ProjectFunder");
        
        //peojekt und aktuelle Benutzer von Hauptseite uebertragen 
        request.setAttribute("benutzer", request.getParameter("ersteller"));
        request.setAttribute("kennung", request.getParameter("kennung"));
        
        int kennung = Integer.parseInt(request.getParameter("kennung"));
        
        try {
        	UserStore userstore = new UserStore();
        	projekt = userstore.sucheProjekt(kennung);
        	
        	System.out.println("Displaying projekt with kennung = " + projekt.getKennung());
        	System.out.println(projekt.getStatus());
        	
        	request.setAttribute("titel" , projekt.getTitel());
        	request.setAttribute("ersteller" , projekt.getErsteller());
        	request.setAttribute("beschreibung" , projekt.getBeschreibung());
        	request.setAttribute("finanzierunglimit" , projekt.getFinanzierungslimit());
        	request.setAttribute("status" , projekt.getStatus());
        	
        	kommentar = userstore.listKommentar(kennung);
        	request.setAttribute("allKommentar", kommentar);

        	userstore.complete();
        	userstore.close();
        	
        } catch(StoreException e) {
        	e.printStackTrace();
        }
        
        try {
        	request.getRequestDispatcher("/view_project.ftl").forward(request, response);
        } catch(Exception e) {
        	e.printStackTrace();
        }

    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Editieren
        if(request.getParameter("action").equals("editieren")) {
        	
        	if(String.valueOf(request.getParameter("titel")).length() > 30) {
            	request.setAttribute("errormessage", "Fehler bei der Eingabe!");
            	Projekt projektToEdit = new Projekt();
        		List<Kategorie> kategorie = new ArrayList<Kategorie>();
        		
            	//Form fuer Editieren
            	request.setAttribute("pagetitle", "Projekt editieren");
                request.setAttribute("ersteller", request.getParameter("ersteller"));
                System.out.println("Edited by: " + String.valueOf(request.getParameter("ersteller")));
                
                // kennung von projekt details uebertragen
                request.setAttribute("kennung", request.getParameter("kennung"));
                
                int kennung = Integer.parseInt(request.getParameter("kennung"));
                
                // Werte aus der ausgewaehlte Projekt setzen
                try{
                	UserStore userstore = new UserStore();
                	projektToEdit = userstore.sucheProjekt(kennung);
                	
                	request.setAttribute("titel", projektToEdit.getTitel());
                	request.setAttribute("finanzierungslimit", projektToEdit.getFinanzierungslimit());
                	request.setAttribute("beschreibung", projektToEdit.getBeschreibung());
                	request.setAttribute("vorgaenger", projektToEdit.getVorgaenger());
                	kategorie = projektToEdit.getKategorie();
                	
                	request.setAttribute("checked1", "");
                	request.setAttribute("checked2", "");
                	request.setAttribute("checked3", "");
                	request.setAttribute("checked4", "");
                	
                	for(int i = 0; i < kategorie.size(); i++) {
                		if(kategorie.get(i).getName().equals("Health & Wellness")) {
                			request.setAttribute("checked1", " checked");
                		}
                		if(kategorie.get(i).getName().equals("Art & Creative Works")) {
                			request.setAttribute("checked2", " checked");
                		}
                		if(kategorie.get(i).getName().equals("Education")) {
                			request.setAttribute("checked3", " checked");
                		}
                		if(kategorie.get(i).getName().equals("Tech & Innovation")) {
                			request.setAttribute("checked4", " checked");
                		}
                	}
                	
                	userstore.complete();
                	userstore.close();
                } catch (StoreException e) {
                	e.printStackTrace();
                }
                
                
                try {
                	request.getRequestDispatcher("/edit_project.ftl").forward(request, response);
                } catch (Exception e) {
                	e.printStackTrace();
                }
            	
        	}
        	
        	else {
				String titel = request.getParameter("titel");
				String beschreibung = request.getParameter("beschreibung");
				String status = request.getParameter("status");
				BigDecimal finanzierungslimit = new BigDecimal(request.getParameter("finanzierungslimit"));
				String ersteller = request.getParameter("ersteller");
				int vorgaenger = Integer.parseInt(request.getParameter("vorgaenger"));
				String[] katArray = request.getParameterValues("kategorie");
				String kat = "";
				for (int i = 0; i < katArray.length; i++) {
					kat = kat + katArray[i];
				}
				System.out.println(kat);
				List<Kategorie> kategorie = new ArrayList<Kategorie>();
				if(kat.contains("Health & Wellness")) {
					kategorie.add(new Kategorie(1, "Health & Wellness", "pfad/icons/health.png"));
				}
				if(kat.contains("Art & Creative Works")) {
					kategorie.add(new Kategorie(2, "Art & Creative Works", "pfad/icons/art.png"));
				}
				if(kat.contains("Education")) {
					kategorie.add(new Kategorie(3, "Education", "pfad/icons/education.png"));
				}
				if(kat.contains("Tech & Innovation")) {
					kategorie.add(new Kategorie(4, "Tech & Innovation", "pfad/icons/tech.png"));
				}
						
				Projekt projektToEdit = new Projekt(titel, beschreibung, status, finanzierungslimit, ersteller, vorgaenger, kategorie);
				projektToEdit.setKennung(Integer.parseInt(request.getParameter("kennung")));
				
				//doGet fuer Projekt Details
				Projekt projekt = new Projekt();
		        List<Kommentar> kommentar = new ArrayList<Kommentar>();
		        
		        request.setAttribute("pagetitle", "ProjectFunder");
		        
		        //projekt kennung und aktuelle Benutzer von Hauptseite uebertragen 
		        request.setAttribute("benutzer", request.getParameter("ersteller"));
		        request.setAttribute("kennung", request.getParameter("kennung"));
		        
		        int kennung = Integer.parseInt(request.getParameter("kennung"));
		        
		        try {
		        	UserStore userstore = new UserStore();
		        	userstore.updateProjekt(projektToEdit);
		        	userstore.complete();
		        	userstore.close();
		        	
		        } catch(StoreException e) {
		        	e.printStackTrace();
		        }
		        
		        try {
		        	UserStore userstore2 = new UserStore();
		        	projekt = userstore2.sucheProjekt(kennung);
		        	
		        	kommentar = userstore2.listKommentar(kennung);
	
		        	userstore2.complete();
		        	userstore2.close();
		        
		        } catch(StoreException e) {
		        	e.printStackTrace();
		        }
		        
		        System.out.println("Displaying Projekt with kennung = " + projekt.getKennung());
	        	System.out.println(projekt.getStatus());
	        	
	        	request.setAttribute("titel" , projekt.getTitel());
	        	request.setAttribute("beschreibung" , projekt.getBeschreibung());
	        	request.setAttribute("status" , projekt.getStatus());
	        	request.setAttribute("finanzierungslimit" , projekt.getFinanzierungslimit());
	        	request.setAttribute("ersteller" , projekt.getErsteller());
	        	request.setAttribute("vorgaenger" , projekt.getVorgaenger());
	        	request.setAttribute("kategorie" , projekt.getKategorie());
	   
	        	request.setAttribute("allkommentar", kommentar);
				
				try {
					request.getRequestDispatcher("/view_project.ftl").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			
        	}
        	
        }
		
        // Spenden
        else if(request.getParameter("action").equals("spenden")) {
        	
//        	String benutzer = String.valueOf(request.getParameter("benutzer"));
        	Spenden spendenToAdd = null;
        	int kennung = Integer.parseInt(request.getParameter("kennung"));
        	BigDecimal guthaben = new BigDecimal(request.getParameter("guthaben"));
        	
        	//doGet aus Projekt Details
			Projekt projekt = new Projekt();
	        List<Kommentar> kommentar = new ArrayList<Kommentar>();
	        
	        request.setAttribute("pagetitle", "ProjectFunder");
	        
	        //ID und aktuelle Benutzer von Hauptseite uebertragen 
	        request.setAttribute("benutzer", request.getParameter("benutzer"));
	        request.setAttribute("kennung", request.getParameter("kennung"));
	        
        	try {
        		UserStore userstore = new UserStore();
        		
				userstore.addSpenden(spendenToAdd, guthaben);
        		userstore.complete();
        		userstore.close();
        	} catch(StoreException e) {
        		e.printStackTrace();
        	}
        	
        	try {
	        	UserStore userstore2 = new UserStore();
	        	projekt = userstore2.sucheProjekt(kennung);
	        		        	
	        	kommentar = userstore2.listKommentar(kennung);

	        	userstore2.complete();
	        	userstore2.close();
	        
	        } catch(StoreException e) {
	        	e.printStackTrace();
	        }
	        
	        System.out.println("Displaying Projekt with kennung = " + projekt.getKennung());
        	System.out.println(projekt.getStatus());
        	
        	request.setAttribute("titel" , projekt.getTitel());
        	request.setAttribute("beschreibung" , projekt.getBeschreibung());
        	request.setAttribute("status" , projekt.getStatus());
        	request.setAttribute("finanzierungslimit" , projekt.getFinanzierungslimit());
        	request.setAttribute("ersteller" , projekt.getErsteller());
        	request.setAttribute("vorgaenger" , projekt.getVorgaenger());
        	request.setAttribute("kategorie" , projekt.getKategorie());
        	request.setAttribute("allekommentare", kommentar);
        	
        	
        	
        	try {
        		request.getRequestDispatcher("/view_project.ftl").forward(request, response);
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        }
        
        // Loeschen
        else if(request.getParameter("action").equals("loeschen")) {
        	
//       	int kennung = Integer.parseInt(request.getParameter("kennung"));
//       	BigDecimal guthaben = new BigDecimal(request.getParameter("guthaben"));	
        	// refresh list of Projekt
	        List<Projekt> projekt = null;
	 
	        
	        request.setAttribute("pagetitle", "ProjectFunder");
	      
	        request.setAttribute("benutzer", request.getParameter("benutzer"));
	        
	        String benutzer = String.valueOf(request.getAttribute("benutzer"));
	        
	        //doGet aus Hauptseite
	        try {
	        	UserStore userstore = new UserStore();
//	        	userstore.deleteProjekt(kennung, projekt, guthaben);
	        	
	        	String link = "";
	        	// because id doesn't show in freemarker
	        	projekt = userstore.allClosedProjekt();
	        	projekt = userstore.allOpenProjekt();
	        	
	        	for(Projekt p : projekt) {
	        		
	        		String temp = "<h2><a href=\"/projekt_details?id=" + p.getKennung()
	        		+ "&benutzer=" + benutzer + "\" title=\"Click for details\">" + p.getTitel()
	        		+ " </a> </h2>\r\n" + 
	        		"Seit: " + "<b> Finanzierungslimit: " + p.getFinanzierungslimit()
	        		+ " EUR</b> </br>\r\n" + 
	        		"<a href=\"/user_profil?ersteller=" + p.getErsteller() + "\">" + p.getErsteller()
	        		+ " </a> </br>\r\n" + 
	        		"</br>";
	        		
	        		link = link + temp;
	        	}
	        	
	        	       	
	        	request.setAttribute("link", link);
	        	userstore.complete();
	        	userstore.close();
	        	
	        } catch(StoreException e) {
	        	e.printStackTrace();
	        }
 
        	try {
        		request.getRequestDispatcher("/view_main.ftl").forward(request, response);
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        }
        
        // Kommentar: Kommentar text, die leer sind, wird nicht eingetragen
        else if(request.getParameter("action").equals("kommentar") && !request.getParameter("kommentartext").equals("")) {
        	
        	System.out.println("action kommentar");
        	int id = Integer.parseInt(request.getParameter("id"));
        	String benutzer = request.getParameter("benutzer");
        	String text = request.getParameter("text");
        	int kennung = Integer.parseInt(request.getParameter("kennung"));
        	Kommentar komToAdd = new Kommentar(id, text, benutzer);
        	Schreibt schreibt = new Schreibt(benutzer, kennung, id);
        	
        	//doGet aus Projekt Details
        	 Projekt projekt = new Projekt();
             List<Kommentar> kommentar = new ArrayList<Kommentar>();
             
             request.setAttribute("pagetitle", "Inserator");
             
             //ID und aktuelle Benutzer von Hauptseite Ã¼bertragen 
             request.setAttribute("benutzer", request.getParameter("benutzer"));
             request.setAttribute("kennung", request.getParameter("kennung"));
             
             try{
               	UserStore userstore = new UserStore();
            	userstore.addKommentar(komToAdd, kennung, schreibt);
            	userstore.complete();
            	userstore.close();
            	
             } catch(StoreException e) {
            	 e.printStackTrace();
             }
             
             try {
               	UserStore userstore2 = new UserStore();
             	projekt = userstore2.sucheProjekt(kennung);
             	
             	kommentar = userstore2.listKommentar(kennung);
             	
             	userstore2.complete();
             	userstore2.close();
             	
             } catch(StoreException e) {
             	e.printStackTrace();
             }
             
            System.out.println("Displaying Projekt with kennung = " + projekt.getKennung());
          	System.out.println(projekt.getStatus());
          	
          	request.setAttribute("titel" , projekt.getTitel());
        	request.setAttribute("beschreibung" , projekt.getBeschreibung());
        	request.setAttribute("status" , projekt.getStatus());
        	request.setAttribute("finanzierungslimit" , projekt.getFinanzierungslimit());
        	request.setAttribute("ersteller" , projekt.getErsteller());
        	request.setAttribute("vorgaenger" , projekt.getVorgaenger());
        	request.setAttribute("kategorie" , projekt.getKategorie());
          	request.setAttribute("allKommentar", kommentar);
        	
        	try {
        		request.getRequestDispatcher("/view_project.ftl").forward(request, response);
        	} catch(Exception e) {
        		e.printStackTrace();
        	}
        	
        }
        	doGet(request, response);   
    }
}
