package map;

public class Cell {
	public enum CellType {DIRT, GRASS};
	public boolean isActive;
	public CellType cellType;
	public Cell (boolean active, CellType celltype){
		isActive = active;
		cellType = celltype;
	}
}
