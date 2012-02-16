
public class GrassTile extends Tile{
	
	public GrassTile(int id){
		super(id);
	}
	
	public void render(Screen screen, int x, int y){
		int col = Color.get(-1,50,150,0);
		screen.render(x, y, 640, col, 0);
		screen.render(x+8, y, 641, col, 0);
		screen.render(x, y+8, 672, col, 0);
		screen.render(x+8, y+8, 673, col, 0);
	}
}
