package pl.atena.edu.sklep1;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sprzedaz {

	public static void main(String[] args) throws SecurityException, IOException {
		
		Logger logger = Logger.getLogger(Sprzedaz.class.getCanonicalName());
		logger.setLevel(Level.ALL);
		
		logger.setUseParentHandlers(false);
		//Handler handler = new ConsoleHandler();
		FileHandler handler = new FileHandler("%h/Wyjatki%u.log",true);
		handler.setLevel(Level.ALL);
		logger.addHandler(handler);
		
		logger.warning("Pierwsze logowanie");
		logger.info("Drugie logowanie");
		
		//System.out.println(Rodzaj.JABLKO.ordinal()+" "+Rodzaj.PIWO.getCode());
		OsobaFizyczna osoba1 = new OsobaFizyczna("Jan","Janek", 17, 60);
		OsobaFizyczna osoba2 = new OsobaFizyczna("Ewa","£ugin", 18, 60);
		OsobaFizyczna osoba3 = new OsobaFizyczna("Klara","Jakaœ", 19, 60);
		OsobaFizyczna osoba4 = new OsobaFizyczna();
		Towar Piwo = new Towar(Rodzaj.PIWO, true, BigDecimal.valueOf(1.9), 90);
		Towar Banan = new Towar(Rodzaj.BANAN, false, BigDecimal.valueOf(2), 200);
		Towar Fajki = new Towar(Rodzaj.FAJKI, true, BigDecimal.valueOf(2), 100);
		Jablko Jablko = new Jablko(Rodzaj.JABLKO, false, BigDecimal.valueOf(1), 120);
		List<Towar> towary = new ArrayList<>();
		towary.add(Piwo);
		towary.add(Banan);
		towary.add(Fajki);
		towary.add(Jablko);
		
		Sklep browar1 = new SklepBiedra("Biedra");
		Sklep browar2 = new SklepZabka("¯abka");

		browar1.dostawa(towary);
		browar2.dostawa(towary);
		browar1.wyswietlstan();
		browar2.wyswietlstan();
		browar1.sortujTowary();
		browar1.wyswietlstan();
		
		try {
		browar1.sprzedaj(osoba1, Fajki);
		} catch (ExceptionPelnoletni ex) {
			System.out.println(ex.getLocalizedMessage());
			
		};
		//browar1.sprzedaj(osoba1, Fajki);
		//browar1.sprzedaj(osoba2, Fajki, 2);
		//browar1.sprzedaj(osoba2, Fajki);
		//browar1.sprzedaj(osoba3, Fajki, 4);
		//browar1.sprzedaj(osoba1, Banan, 201);
		//browar1.sprzedaj(osoba2,Piwo,2);
		osoba2.wyswietlzakupy();
		osoba1.wyswietlzakupy();
		osoba3.wyswietlzakupy();
		browar1.wyswietlstan();
		browar2.wyswietlstan();
		
		browar2.zmienCenyMc();
		browar2.wyswietlstan();
		
		
		
		//browar1.sprzedaj(osoba4,Piwo);

		
	}

}
