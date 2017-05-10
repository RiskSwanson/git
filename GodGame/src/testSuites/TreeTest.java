package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;

import items.Wood;
import mobs.Mob;
import mobs.Squirrel;
import resources.Tree;

public class TreeTest {
	
	int x = 1;
	int y = 1;
	int z = 0;

	@Test
	public void MobCutTree_MobHasCorrectNumberOfItem() {
		int x = 1;
		int y = 1;
		int z = 0;
		Tree t = new Tree(x, y, z);
		Mob m = new Squirrel(x, y, z);
		
		t.provideResource(m);
		int expected = 1;
		int actual = m.countItem(Wood.class);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void MobCutTree_TreeHasCorrectNumberOfItem() {
		Tree t = new Tree(x, y, z);
		Mob m = new Squirrel(x, y, z);
		
		t.provideResource(m);
		int expected = t.BEGINNING_NUMBER-1;
		int actual = t.getRemaining();
		
		assertEquals(expected, actual);
	}

}
