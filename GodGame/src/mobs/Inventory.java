package mobs;

import java.util.HashMap;
import java.util.LinkedList;

import items.Item;

public class Inventory extends HashMap<Class, LinkedList<Item>> {
	public void addItem(Item item){
		if (!this.containsKey(item.getClass())){
			LinkedList<Item> itemList = new LinkedList<Item>();
			itemList.add(item);
			this.put(item.getClass(), itemList);
		}
		else{
			this.get(item.getClass()).add(item);
		}
	}
	
	public void removeItem(Class itemType){
		if (this.containsKey(itemType))
			if (countItems(itemType)>1)
				this.get(itemType).removeLast();
			else
				this.remove(itemType);
	}
	
	public int countItems(Class itemType){
		return this.get(itemType).size();
	}
}
