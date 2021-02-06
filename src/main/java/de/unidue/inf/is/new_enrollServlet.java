package de.unidue.inf.is;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.stores.KursStore;
import de.unidue.inf.is.view_mainServlet;


public final class new_enrollServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Benutzer user = view_mainServlet.user;
    private static view_mainServlet vms = new view_mainServlet();
    private KursStore kursStore = new KursStore();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
    	//Form fuer Kurs Erstellen
    	// request.setAttribute("pagetitle", "Kurs erstellen");
        // request.setAttribute("ersteller", request.getParameter("ersteller"));
    	
//        try {
////        	String kname = kurs.getName();
//        	request.setAttribute("name", name);
//        	request.getRequestDispatcher("/new_enroll.ftl").forward(request, response);
//        } 
//        catch (Exception e) {
//        	e.printStackTrace();
//        }
        
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int status = 0;
    	
        try {
        	request.getRequestDispatcher("/new_enroll.ftl").forward(request, response);
        	request.setAttribute("name", user.getName());
        	String einschreibeschluessel = request.getParameter("Einschreibschlüssel");
        	if(einschreibeschluessel != null)
            {
            	Kurs kurs = new Kurs();
            	kurs.setEinschreibeschluessel(einschreibeschluessel);
            	status = kursStore.newEnroll(kurs);
            }
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
        
        if(status == 1)
        	System.out.print("Record saved successfully");
	}
	
}