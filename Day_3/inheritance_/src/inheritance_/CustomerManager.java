package inheritance_;

public class CustomerManager {
	/*
	 * public void add(IndividualCustomer customer) {
	 * System.out.println(customer.customerNumber + " kaydedildi."); }
	 * 
	 * public void add(CorporateCustomer customer) {
	 * System.out.println(customer.customerNumber + " kaydedildi."); }
	 */
	public void add(Customer customer) {
		System.out.println(customer.customerNumber + " kaydedildi.");
	}
	
	
	// birden fazla müşteri eklemek için  - bulk insert 
	public void addMultiple(Customer[] customers) {
		for(Customer customer : customers) {
			add(customer);
		}
	}
}
