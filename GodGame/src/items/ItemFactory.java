package items;

public class ItemFactory {
	public Item createItem(String itemType){
		Item item;
		switch (itemType){
			case "Wood":
				item = new Wood();
				break;
			case "Seed":
				item = new Seed();
				break;
			default:
				item = new Seed();
				break;
		}
		return item;
	}
}
