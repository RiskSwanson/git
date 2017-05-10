package map;

public abstract class Locatable {
	protected int X;
	protected int Y;
	protected int Z;
	
	public Locatable (int x, int y, int z){
		X = x;
		Y = y;
		Z = z;
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
}
