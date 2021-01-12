//erstellen servlet
package de.unidue.inf.is;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class new_courseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
    	
    	
    	//Form fuer Kurs Erstellen
    	request.setAttribute("pagetitle", "Kurs erstellen");
        request.setAttribute("ersteller", request.getParameter("ersteller"));
              
        try {
        	request.getRequestDispatcher("/new_course.ftl").forward(request, response);
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	doGet(request, response);
	}
	
}