package Concrete;

import Abstract.GameSaleService;
import Entities.Campagain;
import Entities.Game;
import Entities.GameSale;
import Entities.User;

public class GameSaleManager implements GameSaleService{

	@Override
	public void add(User user, Campagain campagain, Game game, GameSale gameSale) {
		double priceTotal = game.getPrice() - (game.getPrice() * campagain.getDiscount() / 100);
		System.out.println(user.getFirstName()+ " " + user.getLastName() + " isimli üye " + game.getName() + " isimli oyunu " + priceTotal +" fiyata satın almıştır.");
		
	}

	@Override
	public void delete(GameSale gameSale) {
		System.out.println(gameSale.getId() + " id'ye sahip satış silinmiştir.");
		
	}

	@Override
	public void update(GameSale gameSale) {
		System.out.println(gameSale.getGameId() + " id'ye satış güncellenmiştir.");
		
	}


}
