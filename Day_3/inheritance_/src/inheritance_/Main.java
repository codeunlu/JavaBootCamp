package inheritance_;

public class Main {

	public static void main(String[] args) {
		
		IndividualCustomer individualCustomer = new IndividualCustomer();
		individualCustomer.id = 1;
		individualCustomer.customerNumber = "1324";
		individualCustomer.firstName = "Mustafa";
		individualCustomer.lastName = "ÜNLÜ";
		individualCustomer.nationalIdentity = "22013746690";
		
		CorporateCustomer corporateCustomer = new CorporateCustomer();
		corporateCustomer.id = 2;
		corporateCustomer.customerNumber = "1324";
		corporateCustomer.companyName = "HalkBankası";
		corporateCustomer.taxNumber = "123125123";
		
		CustomerManager customerManager = new CustomerManager();
		/* customerManager.add(corporateCustomer);
		customerManager.add(individualCustomer);*/
		
		Customer[] customers = {
				individualCustomer,
				corporateCustomer
				
		};		
		customerManager.addMultiple(customers);
		
		

	}

}
