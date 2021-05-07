package eTicaretDemo.dataAccess.abstracts;

import eTicaretDemo.entities.concretes.Customer;

public interface CustomerDao {
	void add(Customer customer);
	void delete(Customer customer);
	boolean check(Customer customer);
	boolean active(String code);
	boolean login(String email, String password);

}
