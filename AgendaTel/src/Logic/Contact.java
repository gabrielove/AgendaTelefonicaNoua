package Logic;

public class Contact {
	
	private String Nume;
	private String Prenume;
	private String NrTelFix;
	private String NrTelMobil;
	private String Email;
	private int _id;

	public Contact(String n, String p, String ntf, String ntm, String mail){
		this.Nume = n;
		this.Prenume = p;
		this.NrTelFix = ntf;
		this.NrTelMobil = ntm;
		this.Email = mail;
	}
	
	public void DiplayContact() {
		System.out.println("--------------");
		System.out.println("Contact cu ID: " + _id);
		System.out.println("--------------");

		
		System.out.println("Nume: " + Nume);
		System.out.println("Prenume " + Prenume);
		System.out.println("Telefon Fix: " + NrTelFix);
		System.out.println("Telefon Mobil: " + NrTelMobil);
		System.out.println("Email: " + Email);
		System.out.println("--------------");

	}


	public String getNume() {
		return Nume;
	}

	public void setNume(String nume) {
		Nume = nume;
	}

	public String getPrenume() {
		return Prenume;
	}

	public void setPrenume(String prenume) {
		Prenume = prenume;
	}

	public String getNrTelFix() {
		return NrTelFix;
	}

	public void setNrTelFix(String nrTelFix) {
		NrTelFix = nrTelFix;
	}

	public String getNrTelMobil() {
		return NrTelMobil;
	}

	public void setNrTelMobil(String nrTelMobil) {
		NrTelMobil = nrTelMobil;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

}
