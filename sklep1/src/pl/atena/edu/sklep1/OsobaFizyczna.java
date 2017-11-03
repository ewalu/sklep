package pl.atena.edu.sklep1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OsobaFizyczna implements Osoba {
	public static final int PELNOLETNOSC = 18;
	private String imie;
	private String nazwisko;
	private int wiek;
	private int wzrost;
	List<Towar> towaryKupione = new ArrayList<>();
	private Zwierze zwierze;
	
	public static class Zwierze {
		private String gatunek;
		private String imie;
		public Zwierze (String gatunek) {
			this.gatunek = gatunek;
		}
		
		public Zwierze (String gatunek, String imie) {
			this(gatunek);
			this.imie = imie;
		}
		
		public String toString() {
			return String.format("Zwierze [gatnek=%s, imie=%s]", gatunek, imie);
		}
	}
	
	public String nazwa() {
		return this.imie+" "+this.nazwisko;
	}
	
	public void dodajZwierze(String gatunek) {
		zwierze = new Zwierze(gatunek);
	}
	
	public void dodajZwierze(String gatunek, String imie) {
		zwierze = new Zwierze(gatunek, imie);
	}
	
	public void wyswietlZwierze() {
		System.out.print(this+" posiada ");
		System.out.println(zwierze);
	}
	
	public void kup(Towar towar, int ilosc, BigDecimal cenapro) {
		Towar towarkupiony = new Towar(towar.rodzaj(), towar.uzywka(), cenapro, ilosc);
		System.out.println(this.imie+" kupuje "+towar.rodzaj()+" "+ilosc);
		
		towaryKupione.add(towarkupiony);
	
	}
	
	//konstruktory
	public OsobaFizyczna() {
		System.out.println("Jestem osoba");
	}
	
	public OsobaFizyczna(int wiek) {
		this.wiek = wiek;
	}
	
	public OsobaFizyczna(int wiek, int wzrost) {
		this(wiek); //wywo³uje powy¿szy konstruktor
		this.wzrost = wzrost;
	}
	
	public OsobaFizyczna(String imie, String nazwisko) {
		this(imie);
		this.nazwisko = nazwisko;
	}
	
	public OsobaFizyczna(String imie, String nazwisko, int wiek, int wzrost) {
		this(wiek, wzrost);
		this.nazwisko = nazwisko;
		this.imie = imie;
	}
	
	private OsobaFizyczna(String imie) {
		this.imie = imie;
	}
	
	public static OsobaFizyczna instance(String imie) {
		return new OsobaFizyczna(imie);
	}
	
	public void dodajLat(int lata) {
		this.wiek += lata;
	}
	
	public boolean pelnoletni() {
		return this.wiek < PELNOLETNOSC ? false: true;
	}

	@Override //adnotacja nadpisanie
	public String toString() {
		return String.format("Osoba [imie=%s, nazwisko=%s, wiek=%s, wzrost=%s]", imie, nazwisko, wiek, wzrost);
	}
	
	public void wyswietlzakupy() {
		System.out.println();
		System.out.println(this.imie);
		this.towaryKupione.forEach(i -> System.out.println(i.rodzaj()+" iloœæ: "+i.ilosc()+" cena: "+i.cena()));
		System.out.println();
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public int getWzrost() {
		return wzrost;
	}

	public void setWzrost(int wzrost) {
		this.wzrost = wzrost;
	}

	public static int getPelnoletnosc() {
		return PELNOLETNOSC;
	}


	
	

}
