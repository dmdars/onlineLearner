package de.unidue.inf.is.stores;

import java.util.ArrayList;
import java.util.List;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.unidue.inf.is.domain.Kurs;
import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.domain.Bewerten;
import de.unidue.inf.is.utils.DBUtil;

public final class KursStore implements Closeable {

    private static Connection connection;
    private boolean complete;


    public KursStore() throws StoreException {
        try {
            connection = DBUtil.getExternalConnection();
//            connection.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
    }


    // Kurs erstellen: Insert Kurs und details
    
    public static List<Kurs> getallKurs()
    {
        List<Kurs> list=new ArrayList<Kurs>();  
          
        try{
            PreparedStatement ps = connection.prepareStatement("select * from dbp156.kurs");  
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
        }catch(Exception k){k.printStackTrace();}  
          
        return list;  
    }

    public static List<Benutzer> getUserKurs()
    {
        List<Benutzer> list=new ArrayList<Benutzer>();  
          
        try{
            PreparedStatement ps = connection.prepareStatement("select b.name as bname, k.name as kname, freieplaetze as fp from dbp156.kurs k inner join dbp156.benutzer b on b.bnummer = k.ersteller where b.bnummer = 1");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Benutzer b = new Benutzer();
                b.setBname(rs.getString(1));
                b.setName(rs.getString(2));  
                b.setFreiePlaetze(rs.getInt(3));
                list.add(b);  
            }  
            connection.close();  
        }catch(Exception b){b.printStackTrace();}  
          
        return list;  
    }
    
    public int addKurs(Kurs kursToAdd) throws StoreException{
    	int kidToAdd = 0;
    	try {
    		connection = DBUtil.getExternalConnection();
    		PreparedStatement ps = connection
    				.prepareStatement("insert into dbp156.kurs (name, beschreibungstext, einschreibeschluessel, freiePlaetze, ersteller) values (?, ?, ?, ?, ?)");
    		ps.setString(1, kursToAdd.getName());
    		ps.setString(2, kursToAdd.getBeschreibungstext());
    		ps.setString(3, kursToAdd.getEinschreibeschluessel());
    		ps.setInt(4, kursToAdd.getFreiePlaetze());
    		ps.setInt(5, kursToAdd.getErsteller());
   
    		kidToAdd = ps.executeUpdate();
//    		
    	}
    	catch(SQLException e) {
    		System.out.println("Error: " + e.getMessage());
    		throw new StoreException(e);
    	} 
    	
    	return kidToAdd;
    }

    // Kurs details: View anhand von Kurs kid die anzuzeigende Kurs, gibt den Kurs zurueck
    
    public static List<Kurs> viewKursTop(){
    	
    	List<Kurs> listTop = new ArrayList<Kurs>();
    	try {
    		connection = DBUtil.getExternalConnection();
    		PreparedStatement ps = connection
    				.prepareStatement("select b.name as bname, k.name as kname, freieplaetze as fp, Beschreibungstext from dbp156.kurs k inner join dbp156.benutzer b on b.bnummer = k.ersteller where k.ersteller = 1");
//    		ps.setInt(1,  ersteller);
    		ResultSet res =  ps.executeQuery();
    			while(res.next()) {
//    				String name = res.getString("name");
//    				String beschreibungstext = res.getString("beschreibungstext");
//    				int freiePlaetze = res.getInt("freiePlaetze");
//    				Kurs kurs = new Kurs();
    				Benutzer benutzer = new Benutzer();
                    benutzer.setBname(res.getString(1));
                    benutzer.setName(res.getString(2));
                    benutzer.setFreiePlaetze(res.getInt(3));
                    benutzer.setBeschreibungstext(res.getString(4));
                    listTop.add(benutzer);
    			}
    			connection.close();
    	} catch(Exception e){e.printStackTrace();} 
		return listTop; 
    }
    
    public static List<Bewerten> viewKursBottom(){
    	
    	List<Bewerten> listBottom = new ArrayList<Bewerten>();
    	try {
    		connection = DBUtil.getExternalConnection();
    		PreparedStatement ps = connection
    				.prepareStatement("select t2.name, t3.abgabetext, t1.note from (((select e.anummer, e.aid, b.note from dbp156.einreichen e inner join dbp156.bewerten b on e.aid = b.aid) as t1 inner join dbp156.aufgabe t2 on t1.anummer = t2.anummer) inner join dbp156.abgabe t3 on t1.aid = t3.aid) where t2.kid = 1");
    		ResultSet res =  ps.executeQuery();
    			while(res.next()) {
    				Bewerten bewerten = new Bewerten();
                    bewerten.setName(res.getString(1));
                    bewerten.setAbgabetext(res.getString(2));
                    bewerten.setNote(res.getInt(3));
                    listBottom.add(bewerten);
    			}
    			connection.close();
    	} catch(Exception e){e.printStackTrace();} 
		return listBottom; 
    }

    public void complete() {
        complete = true;
    }


    @Override
    public void close() throws IOException {
        if (connection != null) {
            try {
                if (complete) {
                    connection.commit();
                }
                else {
                    connection.rollback();
                }
            }
            catch (SQLException e) {
                throw new StoreException(e);
            }
            finally {
                try {
                    connection.close();
                }
                catch (SQLException e) {
                    throw new StoreException(e);
                }
            }
        }
    }

}
