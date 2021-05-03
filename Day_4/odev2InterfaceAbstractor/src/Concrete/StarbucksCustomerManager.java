package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {
	
	private CustomerCheckService customerCheckService;
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}
	
	@Override
	public void save(Customer customer){
		if(customerCheckService.checkIfRealPerson(customer)) {
			System.out.println("Saved to db: " + customer.getFirstName());
		}else {
			throw new ArithmeticException("Not a valid person");
		}
	}

}
