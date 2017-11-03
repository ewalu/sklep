package pl.atena.edu.sklep1;

public enum Rodzaj {
	PIWO (1) {
		public void opis() {
			System.out.println("To jest piwo");
		}
		
	},
	FAJKI (2) {
		public void opis() {
			System.out.println("To jest fajki");
		}
	},
	BANAN (3) {
		public void opis() {
			System.out.println("To jest banan");
		}
	},
	JABLKO (4) {
		public void opis() {
			System.out.println("To jest jab³ko");
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
