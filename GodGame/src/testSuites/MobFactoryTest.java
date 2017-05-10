package testSuites;

import static org.junit.Assert.*;

import org.junit.Test;

import mobs.Human;
import mobs.Mob;
import mobs.MobFactory;
import mobs.Squirrel;

public class MobFactoryTest {

	int z= 0;
	
	@Test
	public void MobFactoryCreatesHumanWithCorrectWord() {
		int x = 0;
		int y = 0;
		String type = "Human";
		MobFactory mf = new MobFactory();
		Mob actual = mf.CreateMob(x, y, z, type);
		
		Mob expected = new Human(x,y,z);
		
		assertEquals(expected.getClass(), actual.getClass());
	}
	
	@Test
	public void MobFactoryCreatesSquirrelWithWrongWord() {
		int x = 0;
		int y = 0;
		String type = "Humna";
		MobFactory mf = new MobFactory();
		Mob actual = mf.CreateMob(x, y, z, type);
		
		Mob expected = new Squirrel(x,y,z);
		
		assertEquals(expected.getClass(), actual.getClass());
	}

}
