package mobs;

public class MobFactory {
	public Mob CreateMob (int x, int y, int z, String type){
		Mob myReturn;
		switch (type){
		case "Human":
			myReturn = new Human(x,y,z);
			break;
		default:
			myReturn = new Squirrel (x,y,z);
			break;
			
		}
		return myReturn;
	}
}
