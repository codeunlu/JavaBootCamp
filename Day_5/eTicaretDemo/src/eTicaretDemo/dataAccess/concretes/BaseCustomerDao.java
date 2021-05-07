package eTicaretDemo.dataAccess.concretes;

import java.util.ArrayList;

import eTicaretDemo.dataAccess.abstracts.CustomerDao;
import eTicaretDemo.entities.concretes.Customer;

public class BaseCustomerDao implements CustomerDao{
	
	ArrayList<Customer> customers = new ArrayList<Customer>();
	
	
	@Override
	public void add(Customer customer) {
		customers.add(customer);
		System.out.println("Başarıyla kayıt oldunuz: " + customer.getFirstName() + " " + customer.getLastName());
	}

	@Override
	public void delete(Customer customer) {
		int index = customers.indexOf(customer.getEmail());
		customers.remove(index);
		System.out.println("Üye silinmiştir!");
	}
	
	@Override
	public boolean check(Customer customer) {
		for(Customer checkUser : customers) {
			if(checkUser.getEmail() == customer.getEmail()) {
				System.out.println("Bu email adresi kullanılmaktadır!");
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean activeUpdate(String activeCode) {
		for(Customer checkUser : customers) {
			if(checkUser.getActiveCode() == activeCode) {
				System.out.println(checkUser.getFirstName()+ " " + checkUser.getLastName()+ " üyeliğiniz aktifleştirildi.");
				checkUser.setActive(true);
				return true;
			}
		}
		System.out.println("Üye aktif kodları uyuşmamaktadır!");
		return false;
		
	}

	
	@Override
	public boolean login(String email, String password) {
		for(Customer checkUser : customers) {
			if(checkUser.getEmail() == email && checkUser.getPassword() == password) {
				System.out.println("Başarıyla giriş yapılıyor.");
				return true;
			}
		}
		System.out.println("Üye giriş bilgileri hatalıdır!");
		return false;
	}

}
