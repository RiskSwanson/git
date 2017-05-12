package map;

public class CellFactory {
	public Cell CreateCell (boolean active, Cell.CellType cellType){
		Cell myReturn = new Cell(active, cellType);
		return myReturn;
	}
}
