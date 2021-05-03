package Concrete;

import Abstract.CampagainService;
import Entities.Campagain;

public class CampagainManager implements CampagainService{

	@Override
	public void add(Campagain campagain) {
		System.out.println(campagain.getName() + " kampanya eklenmiştir.");
	}

	@Override
	public void delete(Campagain campagain) {
		System.out.println(campagain.getName() + " kampanya silinmiştir.");		
	}

	@Override
	public void update(Campagain campagain) {
		System.out.println(campagain.getName() + " kampanya güncellenmiştir.");				
	}

}
