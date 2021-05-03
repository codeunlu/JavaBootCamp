import java.time.LocalDate;

import Abstract.BaseUserManager;
import Adapter.MernisServiceAdapter;
import Concrete.AuthUserManager;
import Concrete.CampagainManager;
import Concrete.GameManager;
import Concrete.GameSaleManager;
import Entities.Campagain;
import Entities.Game;
import Entities.GameSale;
import Entities.User;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setFirstName("Mustafa");
		user.setLastName("ÜNLÜ");
		user.setNationalityId("22013746690");
		user.setBirthDay(LocalDate.of(1995, 5, 16));
		
		BaseUserManager baseUserManager = new AuthUserManager(new MernisServiceAdapter());
		baseUserManager.add(user);
		baseUserManager.delete(user);
		baseUserManager.update(user);
		
		System.out.println("****************************");
		
		// Kampanya oluştur
		Campagain campagain = new Campagain();
		campagain.setId(1);
		campagain.setName("Bayram Kampyanası");
		campagain.setDiscount(15);
		
		CampagainManager campagainManager = new CampagainManager();
		campagainManager.add(campagain);
		campagainManager.delete(campagain);
		campagainManager.update(campagain);
		
		System.out.println("****************************");
		
		// Oyun Oluştur
		Game game = new Game();
		game.setId(1);
		game.setName("COD4 War");
		game.setPrice(150);
		
		GameManager gameManager = new GameManager();
		gameManager.add(game);
		gameManager.delete(game);
		gameManager.update(game);
		
		System.out.println("****************************");
		
		// Oyun Satışı Oluştur
		GameSale gameSale = new GameSale();
		gameSale.setId(1);
		gameSale.setGameId(game.getId());
		gameSale.setUserId(user.getId());
		gameSale.setPrice(game.getPrice());
		
		GameSaleManager gameSaleManager = new GameSaleManager();
		gameSaleManager.add(user, campagain, game, gameSale);
		gameSaleManager.delete(gameSale);
		gameSaleManager.update(gameSale);
	}

}
