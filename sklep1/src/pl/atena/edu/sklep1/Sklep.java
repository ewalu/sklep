package pl.atena.edu.sklep1;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

public abstract class Sklep {
	List<Towar> towaryWsklepie = new ArrayList<>();
	List<Towar> dostawa = new ArrayList<>();
	private String nazwa;
	
	public Sklep(String nazwa) {
		this.nazwa = nazwa;
	}
	
	//dostarczenie do sklepu towar�w w postaci listy obiekt�w towar (tworz� nowe obiekty dla sklepu)
	public void dostawa(List<Towar> dostawka) {
		dostawka.forEach(i -> {
		Towar towar = new Towar(i.rodzaj(), i.uzywka(), i.cena(), i.ilosc());
		towaryWsklepie.add(towar);
		}
		);
	}
	
	private void sprawdzWiekAd(OsobaFizyczna osoba, Towar towar) {
		Objects.requireNonNull(osoba);
		Objects.requireNonNull(towar.getRodzaj());

		Rodzaj rodzajtowaru = towar.getRodzaj();
		//System.out.println(rodzajtowaru);
		
		try {
			Field field = rodzajtowaru.getClass().getField(rodzajtowaru.name());
			//System.out.println(field);
			CheckAge ca = field.getAnnotation(CheckAge.class);
			if (field == null){
				return;
			}
			if (osoba.getWiek() < ca.wiek()){
				throw new IllegalArgumentException("Adnotacja: Osoba ma mniej ni� "+ca.wiek()+" lat.");
			
			}
			} catch (SecurityException | NoSuchFieldException e) {
			e.printStackTrace();
			}

}
	//sprzeda� osobie jednej sztuki towaru
	public void sprzedaj(OsobaFizyczna osoba, Towar towar) throws ExceptionPelnoletni{
		sprzedaj(osoba, towar, 1);
	}
	
	public void sprzedaj(OsobaFizyczna osoba, Towar towar, int ilosc) throws ExceptionPelnoletni{
		//wyliczam cen� po promocji
		BigDecimal cenapro = this.promocja(towar);
		
		sprawdzWiekAd(osoba, towar);
			
		/*if (towar.uzywka()) {
			osoba.pelnoletni();
		}*/
		
		//sprzeda� w zale�no�ci od pe�noletno�ci i stanu w sklepie
		if (this.stan(ilosc, towar) == 1) {
			//osoba kupuje towar w konkretnej ilo�ci i cenie
			osoba.kup(towar, ilosc, cenapro);
			towaryWsklepie.forEach(i -> {
				if (i.rodzaj() == towar.rodzaj()) {
					i.zwiekszIlosc(-ilosc);
				}
			}
			
					);
		}
		else if (this.stan(ilosc,towar) == 0) {
			
			System.out.println("Drogi kliencie "+osoba.getImie()+", nie mamy tyle "+towar.rodzaj());
			towaryWsklepie.forEach(i -> {
				if (i.rodzaj() == towar.rodzaj()) {
					osoba.kup(towar,i.ilosc(), cenapro);
					i.zerujIlosc();
				}
			}
			);
		}
	}
	
	
	
	private int stan(int zamowienie, Towar towar) {
		for(int i=0; i<towaryWsklepie.size(); i++) {
			if (towaryWsklepie.get(i).rodzaj() == towar.rodzaj()) {
				if (towaryWsklepie.get(i).ilosc() >= zamowienie) {
					return 1;
				}
				else return 0;
			}
		}
		return 0;
	}
	
	public void wyswietlstan() {
		System.out.println();
		System.out.println(this.nazwa);
		this.towaryWsklepie.forEach(i -> System.out.println(i.rodzaj()+" "+i.ilosc()+" "+i.cena()));
		System.out.println();
	}
	
	public void sortujTowary() {
		this.towaryWsklepie.sort(new Comparator<Towar>() {
			public int compare(Towar o1, Towar o2) {
				if (o1.ilosc() > o2.ilosc()) {
					return 1;
					
				}else if (o1.ilosc() < o2.ilosc()) {
					return -1;
				}else return 0;
			}
			
		}
		);
	}
	
	
	public void zmienCenyMc () {
		towaryWsklepie.forEach(item -> {
			item.ustawCeneMc();
		});
	}
		

	@Override
	public String toString() {
		return String.format("Sklep [nazwa=%s]", nazwa);
	}
	
	public abstract BigDecimal promocja(Towar towar);
	
}
