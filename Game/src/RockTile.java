
public class RockTile extends Tile{
	
	public RockTile(int id){
		super(id);
	}
	
	public void render(Screen screen, int x, int y){
		int col = Color.get(-1,250,500,0);
		screen.render(x, y, 704, col, 0);
		screen.render(x+8, y, 705, col, 0);
		screen.render(x, y+8, 736, col, 0);
		screen.render(x+8, y+8, 737, col, 0);
	}
}
