package testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CellFactoryTest.class, ChunkFactoryTest.class, InventoryTest.class, ItemFactoryTest.class,
		MobFactoryTest.class, TreeTest.class })
public class AllTests {

}
