package pl.atena.edu.sklep1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.UnaryOperator;

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
	
	protected UnaryOperator<BigDecimal> modyfikujCene (){
		int month = LocalDate.now().getMonthValue();
		
		if (month % 2 == 0) {
			return item -> item.multiply(BigDecimal.valueOf(0.9));
		} else
			return item -> item.multiply(BigDecimal.valueOf(1.05));
	}
	
	public BigDecimal obnizCene(int promo) {
		BigDecimal cenapro;
		cenapro = BigDecimal.valueOf(100-promo).multiply(this.cena).divide(BigDecimal.valueOf(100));
		return cenapro;
	}
	
	public void ustawCene() {
		UnaryOperator<BigDecimal> modyfikator = modyfikujCene();
		this.cena = modyfikator.apply(cena);
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
	public boolean uzywka() {
		return this.uzywka;
	}

	/**
	 * @return the rodzaj
	 */
	public Rodzaj getRodzaj() {
		return rodzaj;
	}

	/**
	 * @param rodzaj the rodzaj to set
	 */
	public void setRodzaj(Rodzaj rodzaj) {
		this.rodzaj = rodzaj;
	}

	/**
	 * @return the cena
	 */
	public BigDecimal getCena() {
		return cena;
	}

	/**
	 * @param unaryOperator the cena to set
	 */
	public void setCena(BigDecimal nowaCena) {
		this.cena = nowaCena;
	}

	/**
	 * @return the ilosc
	 */
	public int getIlosc() {
		return ilosc;
	}

	/**
	 * @param ilosc the ilosc to set
	 */
	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	/**
	 * @return the uzywka
	 */
	public boolean isUzywka() {
		return uzywka;
	}

	/**
	 * @param uzywka the uzywka to set
	 */
	public void setUzywka(boolean uzywka) {
		this.uzywka = uzywka;
	}

}