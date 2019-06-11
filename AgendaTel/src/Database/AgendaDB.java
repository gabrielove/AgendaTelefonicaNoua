package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Logic.Contact;

public class AgendaDB {
		
	
	public static ArrayList<Contact> SearchByName(String keyword) throws Exception{

		try {
			Connection con = getConnection();
			Statement s = con.createStatement();
			String search = "SELECT * FROM agendadb.agenda WHERE nume = '" + keyword + "'";
			ResultSet result = s.executeQuery(search);
			ArrayList<Contact> array = new ArrayList<Contact>();
			while((result!=null) && (result.next()))
				{
			    Contact newContact = new Contact(result.getString("nume"),result.getString("prenume"),result.getString("fix"),result.getString("mobil"),result.getString("mail"));
			    newContact.set_id(result.getInt("_id"));
				array.add(newContact);
				}

			
			return array;
			
			
			
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	
	
	public static void Update(int id, Contact contact) throws Exception{
		try {
			Connection con = getConnection();
			
			PreparedStatement del = con.prepareStatement(String.format("UPDATE agendadb.agenda SET nume = '%s', prenume = '%s', fix = '%s', mobil = '%s', mail = '%s' WHERE _id = '"+id+"';",
					contact.getNume(),
					 contact.getPrenume(),
					 contact.getNrTelMobil(),
					 contact.getNrTelFix(),
					 contact.getEmail(),
					 contact.get_id()));
			System.out.println(del);
			
			del.executeUpdate();
					
			
		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Modificat contact");}
	}
	
	
	public static void DeleteAt(int id) throws Exception{
		try {
			Connection con = getConnection();
			
			PreparedStatement del = con.prepareStatement("DELETE FROM agenda WHERE _id = " + id);
			del.executeUpdate();
					
			
		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Deleted contact");}
	}
	
	
	
	public static ArrayList<Contact> GetAll() throws Exception{
		try {
			Connection con = getConnection();
			
			PreparedStatement getall = con.prepareStatement("SELECT * FROM agenda");
			ResultSet result = getall.executeQuery();
			
			ArrayList<Contact> array = new ArrayList<Contact>();
            while(result.next()){
                System.out.print(result.getString("nume"));
                Contact newContact = new Contact(result.getString("nume"),result.getString("prenume"),result.getString("fix"),result.getString("mobil"),result.getString("mail"));
                newContact.set_id(result.getInt("_id"));
                array.add(newContact);
            }
            System.out.println("Got all results!");
            return array;
					
			
		}catch(Exception e) {System.out.println(e);}
		finally {
			System.out.println("Get Done!");
			}
		return null;
		}

	public static void Post(Contact contact) throws Exception{
		try {
			Connection con = getConnection();
			
			PreparedStatement post = con.prepareStatement("INSERT INTO agenda(nume,prenume,fix,mobil,mail)"
					+ "										 VALUES ('"+contact.getNume()+"','"
																		+contact.getPrenume()+"','"
																			+contact.getNrTelFix()+"','"
																			   +contact.getNrTelMobil()+"','"
																			   		+contact.getEmail()+"')");
			post.executeUpdate();
					
			
		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Inserted contact");}
	}
	
	public static void CreateTable() throws Exception{
		try {
			Connection con = getConnection();
			
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS agenda(_id int NOT NULL AUTO_INCREMENT,"
					+ " nume varchar(255), "
					+ "prenume varchar(255), "
					+ "fix varchar(255), "
					+ "mobil varchar(255), "
					+ "mail varchar(255), "
					+ "PRIMARY KEY(_id))");
			create.executeUpdate();
			
		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Function complete.");}
	}
	
	public static Connection getConnection() throws Exception{

		
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/agendadb";
			String username = "root";
			String password = "Password2019";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			//System.out.println("Connected");
			return conn;
		}catch(Exception e) {System.out.println(e);}
		
		return null;
	}
	
}
