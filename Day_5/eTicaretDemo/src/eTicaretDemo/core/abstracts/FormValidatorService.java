package eTicaretDemo.core.abstracts;

public interface FormValidatorService {
	boolean isInput(String input, String message);
	boolean isEmail(String email);
	boolean isPassword(String password);
}
