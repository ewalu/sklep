package pl.atena.edu.sklep1;
import java.util.ArrayList;
import java.util.List;

public class Interfejsy {

	public static void main(String[] args) {
		OsobaFizyczna fiz = new OsobaFizyczna("Ewa", "£u");
		OsobaPrawna praw = new OsobaPrawna("Atenka");
		OsobaPrawna praw1 = new OsobaPrawna("Hestia","111111");
		
		List<Osoba> osoby = new ArrayList<>();
		osoby.add(fiz);
		osoby.add(praw);
		osoby.add(praw1);
		
		osoby.forEach(i -> System.out.println(i.nazwa()));
		osoby.forEach(i -> System.out.println(i.nazwa()));
		

	}

}
