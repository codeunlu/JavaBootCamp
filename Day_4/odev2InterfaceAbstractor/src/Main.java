import java.time.LocalDate;

import Adapters.MernisServiceAdapter;
import Abstract.BaseCustomerManager;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer customerStarbucks = new Customer();
		customerStarbucks.setId(1);
		customerStarbucks.setFirstName("Mustafa");
		customerStarbucks.setLastName("ÜNLÜ");
		customerStarbucks.setNatioanlityId("22013746690");
		customerStarbucks.setDateOfBirth(LocalDate.of(1995, 5, 16));
		
		Customer customerNero = new Customer();
		customerNero.setId(1);
		customerNero.setFirstName("Kamile");
		customerNero.setLastName("KOÇ");
		customerNero.setNatioanlityId("22343716650");
		customerNero.setDateOfBirth(LocalDate.of(1985, 9, 12));
		
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.save(customerStarbucks);
		

	}

}
