package pl.atena.edu.sklep1;

import java.math.BigDecimal;

public class Towar implements ITowar {
	private Rodzaj rodzaj;
	private BigDecimal cena;
	private int ilosc;
	private boolean uzywka;
	
	
	public Towar(Rodzaj rodzaj, boolean uzywka) {
		this.rodzaj = rodzaj;
		this.uzywka = uzywka;
	}
	
	public Towar(Rodzaj rodzaj, boolean uzywka, BigDecimal cena) {
		this(rodzaj, uzywka);
		this.cena = cena;
	}
	
	public Towar(Rodzaj rodzaj, boolean uzywka, BigDecimal cena, int ilosc) {
		this(rodzaj, uzywka, cena);
		this.ilosc = ilosc;
	}
	public void zwiekszIlosc(int ilosc) {
		this.ilosc+=ilosc;
	}
	
	public BigDecimal obnizCene(int promo) {
		BigDecimal cenapro;
		cenapro = BigDecimal.valueOf(100-promo).multiply(this.cena).divide(BigDecimal.valueOf(100));
		return cenapro;
	}
	
	public void zerujIlosc() {
		this.ilosc = 0;
	}

	@Override
	public Rodzaj rodzaj() {
		return this.rodzaj;
	}
	public BigDecimal cena() {
		return this.cena.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	public int ilosc() {
		return this.ilosc;
	}
	public boolean uzywka(){
		return this.uzywka;
	}

}