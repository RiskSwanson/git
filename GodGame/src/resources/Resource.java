package resources;

import items.ItemFactory;
import map.Locatable;
import mobs.Mob;

public abstract class Resource extends Locatable implements iResource {
	
	protected int NumberRemaining;
	protected ItemFactory ItemFactory = new ItemFactory();
	protected String DropItemType;
	
	public Resource(int x, int y, int z){
		super(x, y, z);
	}
	
	public int getRemaining(){
		return NumberRemaining;
	}
	
	public void provideResource(Mob mob){
		NumberRemaining -= 1;
		mob.giveItem(ItemFactory.createItem(DropItemType));
	}
}
