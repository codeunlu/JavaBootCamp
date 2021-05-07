package eTicaretDemo.core.concretes;

import java.util.regex.Pattern;

import eTicaretDemo.core.abstracts.FormValidatorService;

public class FormValidatorManager implements FormValidatorService{
	
	@Override
	public boolean isEmail(String email) {
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);
		if (email.isEmpty()) {
			System.out.println("Email boş bırakılamaz.");
			return false;
		}
		boolean status = pattern.matcher(email).matches();
		if(status) {
			System.out.println("Email doğrulandı.");
			return true;
		}else {
			System.out.println("Email alanını düzgün giriniz!");
			return false;
		}
	}
	
	@Override
	public boolean isInput(String input, String message) {
		if(input.isEmpty()) {
			System.out.println(message);
			return false;
		}else if(input.length() >= 2){
			System.out.println("alan doğrulandı");
			return true;
		}else {
			System.out.println(message);
			return false;
		}
	}
	
	@Override
	public boolean isPassword(String password) {
		if(password.isEmpty()) {
			System.out.println("Şifre alanı boş bırakılamaz!");
			return false;
		}else if(password.length() >= 6) {
			System.out.println("Şifre doğrulandı.");
			return true;
		}else {
			System.out.println("Şifreniz 6 veya 6 karakterden fazla olmalı!");
			return false;
		}
	}

}
