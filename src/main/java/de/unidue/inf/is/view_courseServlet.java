package de.unidue.inf.is;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Bewerten;
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.stores.KursStore;


public final class view_courseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
//    private Kurs sucheKurs = KursStore.sucheKurs();
    private static List<Kurs> listTop=KursStore.viewKursTop();
    private static List<Bewerten> listBottom=KursStore.viewKursBottom();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
    	
    	request.setAttribute("kurs", listTop);
    	request.setAttribute("aufgabe", listBottom);
    	doPost(request, response); 

    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		// Kurs und Details fuer eine bestimmte Kurs zeigen
    	
//		String bname = request.getParameter("bname");
//        String name = request.getParameter("name");
//        String beschreibungstext = request.getParameter("beschreibungstext");
//        String freieplaetze = request.getParameter("freieplaetze"); // Integer.parseInt(request.getParameter("freiePlaetze"));
		
        
//        if(sucheKurs != null)
//        	System.out.print("Record viewed successfully");
//        
        
        try {
        	request.getRequestDispatcher("/view_course.ftl").forward(request, response);
        } catch(Exception e) {
        	e.printStackTrace();
        }  
    }
}
