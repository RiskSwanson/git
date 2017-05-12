package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;

import items.*;
import mobs.Mob;
import mobs.Squirrel;

public class MobTest {

	int z = 0;
	
	@Test
	public void NewMobHasCorrectX() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int expected = x;
		int actual = m.getX();
		
		assertEquals(expected, actual);
	}

	@Test
	public void NewMobHasCorrectY() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int expected = y;
		int actual = m.getY();
		
		assertEquals(expected, actual);
	}

	@Test
	public void MovingMobNorthHasCorrectY() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int move = 7;
		
		m.MoveNorth(move);
		
		int expected = y-7;
		int actual = m.getY();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void MovingMobNorthHasCorrectX() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int move = 7;
		
		m.MoveNorth(move);
		
		int expected = x;
		int actual = m.getX();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void MovingMobSouthHasCorrectY() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int move = 7;
		
		m.MoveSouth(move);
		
		int expected = y+move;
		int actual = m.getY();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void MovingMobSouthHasCorrectX() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int move = 7;
		
		m.MoveSouth(move);
		
		int expected = x;
		int actual = m.getX();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void MovingMobWestHasCorrectY() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int move = 7;
		
		m.MoveWest(move);
		
		int expected = y;
		int actual = m.getY();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void MovingMobWestHasCorrectX() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int move = 7;
		
		m.MoveWest(move);
		
		int expected = x-move;
		int actual = m.getX();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void MovingMobEastHasCorrectY() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int move = 7;
		
		m.MoveEast(move);
		
		int expected = y;
		int actual = m.getY();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void MovingMobEastHasCorrectX() {
		int x = 1;
		int y = 5;
		Mob m = new Squirrel(x, y, z);
		
		int move = 7;
		
		m.MoveEast(move);
		
		int expected = x+move;
		int actual = m.getX();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void GiveOneItemToMob(){
		int x = 1;
		int y = 2;
		Item item = new Wood();
		Mob m = new Squirrel (x,y,z);
		m.giveItem(item);
		
		int expected = 1;
		int actual = m.countItem(item.getClass());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void GiveTwoSameItemsToMob(){
		int x = 1;
		int y = 2;
		Item item = new Wood();
		Mob m = new Squirrel (x,y,z);
		m.giveItem(item);
		Item item2 = new Wood();
		m.giveItem(item2);
		
		int expected = 2;
		int actual = m.countItem(item.getClass());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void GiveTwoDifferentItemsToMob(){
		int x = 1;
		int y = 2;
		Item item = new Wood();
		Item item2 = new Seed();
		Mob m = new Squirrel (x,y,z);
		m.giveItem(item);
		m.giveItem(item2);
		
		int expected = 1;
		int actual = m.countItem(item.getClass());
		assertEquals(expected, actual);
		actual = m.countItem(item2.getClass());
		assertEquals(expected, actual);
	}
	
	@Test
	public void RemoveItemFromMob(){
		int x = 1;
		int y = 2;
		Item item = new Wood();
		Mob m = new Squirrel (x,y,z);
		m.giveItem(item);
		m.giveItem(item);
		m.removeItem(item.getClass());
		
		int expected = 1;
		int actual = m.countItem(item.getClass());
		
		assertEquals(expected, actual);
	}
}
