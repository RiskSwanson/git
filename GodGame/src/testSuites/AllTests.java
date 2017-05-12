package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CellFactoryTest.class, CellTest.class, ChunkFactoryTest.class, InventoryTest.class,
		ItemFactoryTest.class, MobFactoryTest.class, MobTest.class, TreeTest.class })
public class AllTests {

}
