package Display;

import java.util.ArrayList;
import java.util.Scanner;

import Database.AgendaDB;
import Logic.Contact;


public class Menu {
    private Scanner scan = new Scanner(System.in);
    private static AgendaDB db = new AgendaDB();
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

	private static ArrayList<Contact> getContacts() {
        try {
            return AgendaDB.GetAll();
        } catch (Exception e) {
            // return null; // option
            throw new AssertionError("cannot get contacts");
        }
    }
		
	
    
	public void DisplayMenu()
	{
	    try {
			AgendaDB.getConnection();
			AgendaDB.CreateTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String alegere;
	    Integer alegereInt;
	   do{
		    contacts = getContacts();
			System.out.println("");
			System.out.println("");
			System.out.println("---------------");
			System.out.println("Meniu Principal");
			System.out.println("---------------");
			System.out.println("Contacte");
			System.out.println("---------------");
			if(contacts.size() != 0) {
			for(int i = 0; i < contacts.size(); i++) {
					contacts.get(i).DiplayContact();
			}
			}else
				System.out.println("Agenda goala");
			System.out.println("---------------");

			System.out.println("Adaugati contact = 1; Stergeti contact = 2; Modificare contact = 3; Cautati dupa nume = 4;");
			System.out.println("Introduceti o alegere: ");

			alegere = scan.nextLine();
			
			alegereInt = insertNumber(alegere);

    } while(alegereInt < 1 || alegereInt > 4);
	   
		switch(alegereInt) {
		case 1:
			AddContact();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
			default:
				System.out.println("Ati introdus gresit, reintroduceti:");
				

		}
	}

	
public void AddContact() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------");
		System.out.println("Adaugare Contact");
		System.out.println("---------------");
		System.out.println("Introduceti Nume:");
		String nume = scan.nextLine();
		System.out.println("Introduceti Prenume:");
		String pnume = scan.nextLine();
		System.out.println("Introduceti Telefon Mobil:");
		String nr = scan.nextLine();
		System.out.println("Introduceti Telefon Fix:");
		String nrfix = scan.nextLine();
		System.out.println("Introduceti Mail:");
		String mail = scan.nextLine();
		
		Contact contact = new Contact(nume, pnume, nr, nrfix, mail);
		try {
			AgendaDB.Post(contact);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("S-a adaugat contactul");

		DisplayMenu();
		}

	
	public void DeleteContact() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------");
		System.out.println("Adaugare Contact");
		System.out.println("---------------");
		System.out.println("Introduceti Nume:");
		String nume = scan.nextLine();
		System.out.println("Introduceti Prenume:");
		String pnume = scan.nextLine();
		System.out.println("Introduceti Telefon Mobil:");
		String nr = scan.nextLine();
		System.out.println("Introduceti Telefon Fix:");
		String nrfix = scan.nextLine();
		System.out.println("Introduceti Mail:");
		String mail = scan.nextLine();
		
		Contact contact = new Contact(nume, pnume, nr, nrfix, mail);
		try {
			AgendaDB.Post(contact);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("S-a adaugat contactul");

		DisplayMenu();
		}


	public void ModifyContact() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------");
		System.out.println("Adaugare Contact");
		System.out.println("---------------");
		System.out.println("Introduceti Nume:");
		String nume = scan.nextLine();
		System.out.println("Introduceti Prenume:");
		String pnume = scan.nextLine();
		System.out.println("Introduceti Telefon Mobil:");
		String nr = scan.nextLine();
		System.out.println("Introduceti Telefon Fix:");
		String nrfix = scan.nextLine();
		System.out.println("Introduceti Mail:");
		String mail = scan.nextLine();
		
		Contact contact = new Contact(nume, pnume, nr, nrfix, mail);
		try {
			AgendaDB.Post(contact);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("S-a adaugat contactul");

		DisplayMenu();
		}

	public void SearchByName() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------");
		System.out.println("Adaugare Contact");
		System.out.println("---------------");
		System.out.println("Introduceti Nume:");
		String nume = scan.nextLine();
		System.out.println("Introduceti Prenume:");
		String pnume = scan.nextLine();
		System.out.println("Introduceti Telefon Mobil:");
		String nr = scan.nextLine();
		System.out.println("Introduceti Telefon Fix:");
		String nrfix = scan.nextLine();
		System.out.println("Introduceti Mail:");
		String mail = scan.nextLine();
		
		Contact contact = new Contact(nume, pnume, nr, nrfix, mail);
		try {
			AgendaDB.Post(contact);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("S-a adaugat contactul");

		DisplayMenu();
		}

public Integer insertNumber(String alegere) {
	Integer alegereInt1;
	
	while(true) {
		try {
			alegereInt1 = Integer.parseInt(alegere);
        	break;
		}
        catch(NumberFormatException  e) {
        	System.out.println("Ati introdus gresit, reintroduceti:");
        	alegere = scan.nextLine();
        }
		}
	return alegereInt1;
}
}
