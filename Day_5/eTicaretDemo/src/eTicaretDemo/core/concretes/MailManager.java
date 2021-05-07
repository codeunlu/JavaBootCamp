package eTicaretDemo.core.concretes;

import eTicaretDemo.core.abstracts.MailService;

public class MailManager implements MailService{

	@Override
	public void sendMail(String email, String content) {
		System.out.println(email + " adresine doğrulama maili gönderilmiştir.");
		System.out.println("Üyelik aktivite linkiniz: " + content);
		
	}

}
