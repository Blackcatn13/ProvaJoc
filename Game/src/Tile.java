
public class Tile {
	public final byte Id;
	public static Tile tiles[] = new Tile[256];
	public static Tile grass;
	
	public Tile(int id){
		this.Id = (byte)id;
		if(tiles[id] != null){
			throw new RuntimeException("Duplicate tile ids!");
		}else{
			tiles[id] = this;
			return;
		}
	}
	
	public void render(Screen screen1, int i, int j){
		
	}
	
	public void tick(int i, int j){
		
	}
	
	static{
		grass = new GrassTile(0);
	}
	
}
