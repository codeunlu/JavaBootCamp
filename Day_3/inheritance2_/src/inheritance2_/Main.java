package inheritance2_;

public class Main {

	public static void main(String[] args) {
		
		CustomerManager customerManager = new CustomerManager();
		customerManager.add(new EmailLogger());
		
	}

}
