package Abstract;

import Entities.User;

public abstract class BaseUserManager implements UserService{

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+" ismiyle üye oluşturuldu.");
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getId() + " id sine sahip " + user.getFirstName()+" "+user.getLastName()+" isimli üye silinmiştir!");
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " isimli üyenin bilgileri güncellendi.");
	}

}
