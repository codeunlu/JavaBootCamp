package Abstract;

import Entities.Campagain;
import Entities.Game;
import Entities.GameSale;
import Entities.User;

public interface GameSaleService {
	public void add(User user, Campagain campagain, Game game, GameSale gameSale);
	public void delete(GameSale gameSale);
	public void update(GameSale gameSale);
}
