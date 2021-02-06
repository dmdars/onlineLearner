 //erstellen servlet
package de.unidue.inf.is;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.stores.KursStore;

public class new_courseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private KursStore kursStore = new KursStore();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
    	
    	doPost(request, response);
    	
    }  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//Form fuer Kurs Erstellen
        int status = 0;
    	
        try {
        	request.getRequestDispatcher("/new_course.ftl").forward(request, response);
        } 
        catch (Exception e) {
        	e.printStackTrace();
        	
        }
    
    	
    //	int kid = Integer.parseInt(request.getParameter("kid"));
    	String name = request.getParameter("name");
    	String beschreibungstext = request.getParameter("beschreibungstext");
    	String einschreibeschluessel = request.getParameter("einschreibeschluessel");
    	int freiePlaetze = Integer.parseInt(request.getParameter("freiePlaetze"));
    	int ersteller = 1;
    	
    	
    	
    	if(name != null && beschreibungstext != null && einschreibeschluessel != null)
    	{
    			Kurs kurs = new Kurs();
            //	kurs.setKid(kid);
            	kurs.setName(name);
            	kurs.setBeschreibungstext(beschreibungstext);
            	kurs.setEinschreibeschluessel(einschreibeschluessel);
            	kurs.setFreiePlaetze(freiePlaetze);
            	kurs.setErsteller(ersteller);
            	status = kursStore.addKurs(kurs);
            	
                if(status == 1)
                	System.out.print("Record saved successfully");
    	}
    	
 
//        try {
//        	request.getRequestDispatcher("/view_main.ftl").forward(request, response);
//        } 
//        catch (Exception e) {
//        	e.printStackTrace();
//        }
	}
	
}