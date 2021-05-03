public class Main {

	public static void main(String[] args) {
		Logger[] loggers = {
			new EmailLogger(),
			new DatabaseLogger()
		};
		CustomerManager customerManager = new CustomerManager(loggers);
		
		Customer mustafa = new Customer(1,"Mustafa","�NL�");
		customerManager.add(mustafa);
	}

}
