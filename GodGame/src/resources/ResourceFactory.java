package resources;

public class ResourceFactory {
	public Resource CreateResource(String type, int x, int y, int z){
		Resource myReturn;
		
		switch (type){
		case "Tree":
			myReturn = new Tree(x, y, z);
			break;
		default:
			myReturn = new LongGrass(x, y, z);
			break;
		}
		
		return myReturn;
	}
}
