
public class Soldier extends Entity {
	public Soldier(int x, int y, int time) {
		super(x,y,time);
	}
	
	public void tick() {
		actutime++;
		if (actutime == totaltime) {
			actutime = 0;
			x+=8;
		}
	}
	
	public void render(Screen screen) {
		int col1 = Color.get(-1,0,510,537);
		screen.render(x, y, 642, col1, 0);
		screen.render(x + 8, y, 643, col1, 0);
		screen.render(x, y + 8, 674, col1, 0);
		screen.render(x + 8, y + 8, 675, col1, 0);
	}
}
