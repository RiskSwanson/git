package resources;

public class Tree extends Resource implements iResource {
	
	public final int BEGINNING_NUMBER = 10;
	
	public Tree (int x, int y, int z){
		super (x,y, z);
		NumberRemaining = BEGINNING_NUMBER;
		DropItemType = "Wood";
	}
}
