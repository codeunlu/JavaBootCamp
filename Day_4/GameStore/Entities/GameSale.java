package Entities;

public class GameSale{
	private int id;
	private int userId;
	private int gameId;
	private double price;
	
	public GameSale() {}

	public GameSale(int id, int userId, int gameId, double price) {
		this.id = id;
		this.userId = userId;
		this.gameId = gameId;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
