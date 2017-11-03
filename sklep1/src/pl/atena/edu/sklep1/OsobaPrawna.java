package pl.atena.edu.sklep1;

public class OsobaPrawna implements Osoba, OsobaPraw {
	private String nazwa;
	private String nip ="brak";
	
	public OsobaPrawna(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public OsobaPrawna(String nazwa, String nip) {
		this.nazwa = nazwa;
		this.nip = nip;
	}

	@Override
	public String nazwa() {
		return this.nazwa+" "+this.nip;
	}
	
	public String nip() {
		return this.nip;
	}

}
