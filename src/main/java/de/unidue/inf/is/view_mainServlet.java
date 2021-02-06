package de.unidue.inf.is;
//import java.sql.*;
//import java.util.*;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;

//import javax.lang.model.element.Name;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import de.unidue.inf.is.utils.DBUtil;
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.stores.KursStore;



/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 */
public final class view_mainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static Benutzer user = new Benutzer();
    public static String name = user.getName();

    private static List<Kurs> list = KursStore.getallKurs();
    private static List<Benutzer> list2 = KursStore.getUserKurs();
    // Just prepare static data to display on screen
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Put the user list in request and let freemarker paint it.
        request.setAttribute("ukurs", list2);
        request.setAttribute("kurs", list);
        request.getRequestDispatcher("/view_main.ftl").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                    IOException {

//        String freiePlaetze = request.getParameter("freiePlaetze");

          
//        if(name != null && name != null && name != null)
//        {
//        String ersteller = request.getParameter("ersteller");
//        request.getSession().setAttribute("name", name);
        doGet(request, response);
        String bname = request.getParameter("bname");
        name = request.getParameter("kname");
//        user.setName(kname);
        user.setBname(bname);
    }
}
