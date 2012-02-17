
public class Tile {
	public final byte Id;
	public static Tile tiles[] = new Tile[256];
	public static Tile grass;
	public static Tile rock;
	
	public Tile(int id){
		this.Id = (byte)id;
		if(tiles[id] != null){
			throw new RuntimeException("Duplicate tile ids!");
		}else{
			tiles[id] = this;
			return;
		}
	}
	
	public void render(Screen screen1, int i, int j, boolean possible){
		
	}
	
	public void tick(int i, int j){
		
	}
	
	static{
		grass = new GrassTile(0);
		rock = new RockTile(1);
	}
	
}
