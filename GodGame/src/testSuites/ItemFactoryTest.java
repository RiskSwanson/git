package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;

import items.Item;
import items.ItemFactory;

public class ItemFactoryTest {

	@Test
	public void ItemFactoryReturnsWood() {
		ItemFactory iF = new ItemFactory();
		String expected = "Wood";
		
		Item i = iF.createItem(expected);
		
		assertEquals(expected, i.Name);
	}

}
