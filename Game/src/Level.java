import java.util.ArrayList;


public class Level {
	public int w;
	public int h;
	private ArrayList <Building> builds;
	
	public Level(int w, int h){
		this.w = w/8;
		this.h = h/8;
	}
	
	public void AddBuilding(int x, int y, GameSource game){
		builds.add(new Building(x,y,game));
	}
}
