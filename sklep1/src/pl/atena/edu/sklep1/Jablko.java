package pl.atena.edu.sklep1;
import java.math.BigDecimal;

public class Jablko extends Towar {
	
	public Jablko(Rodzaj rodzaj, boolean uzywka) {
		super(rodzaj, uzywka);
		
	}
	
	public Jablko(Rodzaj rodzaj, boolean uzywka, BigDecimal cena) {
		super(rodzaj, uzywka, cena);
	}
	
	public Jablko(Rodzaj rodzaj, boolean uzywka, BigDecimal cena, int ilosc) {
		super(rodzaj, uzywka, cena, ilosc);
	}

	public static void main(String[] args) {
		// TODO Auto

	}

}
