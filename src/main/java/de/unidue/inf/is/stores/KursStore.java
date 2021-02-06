package de.unidue.inf.is.stores;
import java.sql.*;
//import java.util.*;
import java.util.ArrayList;
import java.util.List;
//import java.io.Closeable;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.utils.DBUtil;
import de.unidue.inf.is.view_mainServlet;


public final class KursStore {

	private static Connection con;
	private static Benutzer user =  view_mainServlet.user;
			
    public static List<Kurs> getallKurs()
    {
        List<Kurs> list=new ArrayList<Kurs>();  
        try{
        	con = DBUtil.getExternalConnection();
            PreparedStatement ps = con.prepareStatement("select * from dbp156.kurs");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Kurs k = new Kurs();  
                k.setKid(rs.getInt(1));  
                k.setName(rs.getString(2));  
                k.setBeschreibungstext(rs.getString(3));  
                k.setEinschreibeschluessel(rs.getString(4));  
                k.setFreiePlaetze(rs.getInt(5));
                k.setErsteller(rs.getInt(6));
                list.add(k);  
            }  
            con.close();  
        }catch(Exception k){k.printStackTrace();}  
          
        return list;  
    }

    public static List<Benutzer> getUserKurs()
    {
        List<Benutzer> list=new ArrayList<Benutzer>();  
        
        try{
        	con = DBUtil.getExternalConnection();
            PreparedStatement ps = con.prepareStatement("select b.name as bname, k.name as kname, freieplaetze as fp from dbp156.kurs k inner join dbp156.benutzer b on b.bnummer = k.ersteller where b.bnummer = 1");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Benutzer b = new Benutzer();
                b.setBname(rs.getString(1));
                b.setName(rs.getString(2));  
                b.setFreiePlaetze(rs.getInt(3));
                list.add(b);  
            }  
            con.close();  
        }catch(Exception b){b.printStackTrace();}  
          
        return list;  
    }

    public static List<Benutzer> getspecificKurs()
    {
        List<Benutzer> list=new ArrayList<Benutzer>();
        String name = user.getBname();
        try{
        	con = DBUtil.getExternalConnection();
            PreparedStatement ps = con.prepareStatement("select b.name as bname, k.name as kname, freieplaetze as fp, Beschreibungstext from dbp156.kurs k inner join dbp156.benutzer b on b.bnummer = k.ersteller where b.name = ?");  
            ps.setString(1, name);
            ResultSet rs=ps.executeQuery();      
            while(rs.next()){  
                Benutzer b = new Benutzer();
                b.setBname(rs.getString(1));
                b.setName(rs.getString(2));
                b.setFreiePlaetze(rs.getInt(3));
                b.setBeschreibungstext(rs.getString(4));
                list.add(b);  
            }  
            con.close();  
        }catch(Exception b){b.printStackTrace();}  
          
        return list;  
    }
    
    public int newEnroll(Kurs einschreiben) throws StoreException{
        int kidToAdd = 0;
        try {
         con = DBUtil.getExternalConnection();
         PreparedStatement ps = con
//             .prepareStatement("insert into dbp156.kurs(einschreibeschluessel) values (?)");
           .prepareStatement("insert into dbp156.einschreiben(bnummer, kid) values (1,(select kid from dbp156.kurs where einschreibeschluessel = ?))");
//         ps.setString(1, kursToAdd.getName());
         ps.setString(1, einschreiben.getEinschreibeschluessel());
      
//         PreparedStatement psSelect = connection
//           .prepareStatement("select * from dbp156.kurs");
         
//         PreparedStatement psSelect = connection
//           .prepareStatement("select kid from dbp156.kurs order by datum desc fetch first row only");
//         ResultSet rs = psSelect.executeQuery();
//         if(rs.next()) {
//          kidToAdd = rs.getInt(1);
//          System.out.println("Kategorie for kurs" + kidToAdd);
//         }
         
         kidToAdd = ps.executeUpdate();
//         
        }
        catch(SQLException e) {
         System.out.println("Error: " + e.getMessage());
         throw new StoreException(e);
        } 
        
        return kidToAdd;
       }
    
    



}
