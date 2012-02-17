import java.util.ArrayList;


public class Level {
	public int w;
	public int h;
	private ArrayList <Building> builds;
	private byte[] buildsin;
	private byte[] Background;
	private Screen screen;
	
	public Level(Screen screen){
		this.w = screen.w/8;
		this.h = screen.h/8;
		this.screen = screen;
		Background = new byte[this.w*this.h];
		builds = new ArrayList<Building>();
		buildsin = new byte[this.w*this.h];
		for(int i = 0;i<buildsin.length;i++){
			buildsin[i] = 0;
		}
	}
	
	public void AddBuilding(int x, int y, GameSource game){
		if(!AnyBuildingInZone(x,y)){
			builds.add(new Building(x,y,game));
		}
	}
	
	private boolean AnyBuildingInZone(int x, int y) {
		boolean Any;
		Any = false;
		return Any;
	}

	public void InitBackground(){
		for(int i = 0; i < w*h;i++){
				Background[i]=Tile.grass.Id;
		}
	}
	
	public void RenderBackground(int xScroll, int yScroll){
		 	int xo = xScroll >> 4;
	        int yo = yScroll >> 4;
	        int w = screen.w + 15 >> 4;
	        int h = screen.h + 15 >> 4;
	        screen.setOffset(xScroll, yScroll);
	        for(int y = yo; y <= h + yo; y++)
	        {
	            for(int x = xo; x <= w + xo; x++)
	                Tile.tiles[Background[x+y*w]].render(screen, x*16, y*16,false);

	        }

	        screen.setOffset(0, 0);
	        RenderBuildings();
	}
	
	public void RenderBuildings(){
		for(int i = 0; i< builds.size();i++){
			builds.get(i).Render(screen);
		}
	}
	
	public void RenderPossibleBuildings(int xScroll, int yScroll){
	 	int xo = xScroll >> 4;
        int yo = yScroll >> 4;
        int w = screen.w + 15 >> 4;
        int h = screen.h + 15 >> 4;
        screen.setOffset(xScroll, yScroll);
        for(int y = yo; y <= h + yo; y++)
        {
            for(int x = xo; x <= w + xo; x++){
            	if(buildsin[x+y*w]==0){
            		Tile.tiles[Background[x+y*w]].render(screen, x*16, y*16,true);
            	}else{
            		Tile.tiles[Background[x+y*w]].render(screen, x*16, y*16,false);
            	}
            }

        }
        screen.setOffset(0, 0);
        RenderBuildings();
	}
}
