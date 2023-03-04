

import javax.swing.*;
import java.sql.*;



	public class Sqliteconnection {
	    Connection con = null;
	    public static Connection dbConnector(){
	        try{
	           Class.forName("org.sqlite.JDBC");
	           Connection con = DriverManager.getConnection("jdbc:sqlite:/Users/josearmandoguerrero/Documents/Greengates/CS/IA/computerscienceia.sqlite");
	           JOptionPane.showMessageDialog(null, "Connection Successful");
	           return con;
	        }
	        catch(Exception e){
	            JOptionPane.showMessageDialog(null, e);
	            return null;

	        }

	    }
	}