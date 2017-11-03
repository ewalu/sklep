package pl.atena.edu.sklep1;
import java.math.BigDecimal;

public class SklepBiedra extends Sklep {
	public static final int PIWOPRO = 7;
	public static final int FAJKIPRO = 6;
	public static final int BANANPRO = 1;
	public static final int JABLKOPRO = 0;
	
	public SklepBiedra(String nazwa) {
		super(nazwa);
	}

	@Override
	public BigDecimal promocja(Towar towar) {
		switch(towar.rodzaj()) {
		case PIWO:
			return towar.obnizCene(PIWOPRO);
		case FAJKI:
			return towar.obnizCene(FAJKIPRO);
		case BANAN:
			return towar.obnizCene(BANANPRO);
		case JABLKO:
			return towar.obnizCene(JABLKOPRO);
		}
		return towar.cena();

	}

}
