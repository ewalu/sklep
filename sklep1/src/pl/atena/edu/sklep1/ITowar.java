package pl.atena.edu.sklep1;
import java.math.BigDecimal;

public interface ITowar {
	Rodzaj rodzaj();
	BigDecimal cena();
	int ilosc();
	boolean uzywka();
	
}
