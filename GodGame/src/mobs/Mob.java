package mobs;

import items.Item;
import map.Locatable;

public abstract class Mob extends Locatable {
	protected int Health;
	private Inventory inventory = new Inventory();
	
	public Mob (int x, int y, int z){
		super(x, y, z);
	}
	
	public void MoveNorth( int amountToMove){
		Y -=amountToMove;
	}
	
	public void MoveSouth( int amountToMove){
		Y +=amountToMove;
	}
	
	public void MoveWest( int amountToMove){
		X -=amountToMove;
	}
	
	public void MoveEast( int amountToMove){
		X +=amountToMove;
	}
	
	public void MoveUp (int amountToMove){
		Z +=amountToMove;
	}
	
	public void MoveDown (int amountToMove){
		Z -=amountToMove;
	}
	
	public int getHealth(){
		return Health;
	}
	
	public void increaseHealth(int amount){
		Health+=amount;
	}
	
	public void decreaseHealth(int amount){
		Health-=amount;
	}
	
	public void giveItem(Item item){
		inventory.addItem(item);
	}
	
	public void removeItem(Class itemType){
		inventory.removeItem(itemType);
	}
	
	public int countItem(Class itemType){
		return inventory.countItems(itemType);
	}
}

 
