package pl.atena.edu.sklep1;

public enum Rodzaj {
	@CheckAge
	PIWO (1) {
		public void opis() {
			System.out.println("To jest piwo");
		}
		
	},
	@CheckAge (wiek = 17)
	FAJKI (2) {
		public void opis() {
			System.out.println("To jest fajki");
		}
	},
	@CheckAge (wiek = 0)
	BANAN (3) {
		public void opis() {
			System.out.println("To jest banan");
		}
	},
	@CheckAge (wiek = 0)
	JABLKO (4) {
		public void opis() {
			System.out.println("To jest jab�ko");
		}
	};
	
	private int code;
	
	private Rodzaj(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public abstract void opis();
	
	

}
