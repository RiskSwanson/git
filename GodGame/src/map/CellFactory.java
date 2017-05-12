package map;

public class CellFactory {
	public Cell CreateCell (int x, int y, int z, String cellType){
		Cell myReturn;
		switch(cellType){
			case "Soil":
				myReturn = new Soil(x,y,z);
				break;
			default:
				myReturn = new Soil(x,y,z);
				break;
		}
		return myReturn;
	}
}
