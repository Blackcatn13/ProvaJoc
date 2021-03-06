

public class Building {
	
	public int x,y,x1,y1,timeout,time;
	private GameSource gamehandle;	
	private boolean soldier;
	
	public Building(int X, int Y, GameSource game){
		x = X;
		y = Y;
		x1 = X+16;
		y1 = Y+16;
		gamehandle = game;
		timeout = 60;
		time = 0;
		soldier = false;
	}
	
	public void Render(Screen screen, int x ,int y){
		int col = Color.get(-1,111,510,537);
		int col1 = Color.get(-1,333, 730, 759);
		int xt,yt;
		xt = gamehandle.MouseXPosition();
		yt = gamehandle.MouseYPosition();
		if( xt < x1 && xt > x && yt > y && yt < y1){
			screen.render(x, y, 640, col1, 0);
			screen.render(x+8, y, 641, col1, 0);
			screen.render(x, y+8, 672, col1, 0);
			screen.render(x+8, y+8, 673, col1, 0);
		}else{
			screen.render(x, y, 640, col, 0);
			screen.render(x+8, y, 641, col, 0);
			screen.render(x, y+8, 672, col, 0);
			screen.render(x+8, y+8, 673, col, 0);
		}
	}
	
	public void tick(){
		time++;
		if(time == timeout && !soldier) {
			time = 0;
			gamehandle.getLevel().addSoldier(new Soldier(x+16,y,50));
			soldier = true;
		}
	}
}
