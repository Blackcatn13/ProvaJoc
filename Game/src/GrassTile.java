
public class GrassTile extends Tile{
	
	public GrassTile(int id){
		super(id);
	}
	
	public void render(Screen screen, int x, int y, boolean possible){
		int col;
		if(possible){
			col = Color.get(-1,255,150,0);
		}else{
			col = Color.get(-1,50,150,0);
		}
		screen.render(x, y, 704, col, 0);
		screen.render(x+8, y, 705, col, 0);
		screen.render(x, y+8, 736, col, 0);
		screen.render(x+8, y+8, 737, col, 0);
	}
}
