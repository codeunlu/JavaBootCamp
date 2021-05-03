package abstractClasses;

public abstract class GameCalculator {
	
	/* public void calculator() {
		System.out.println("Puanınız: 100");
	}
	*/
	
	public abstract void calculator();
	
	// olduğu gibi kullan anlamına geliyor 
	// final ibaresi override edilemez
	public final void gameOver() {
		System.out.println("Oyun bitti!");
	}

}
