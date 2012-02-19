

import java.util.ArrayList;


public class Level {
	public int w;
	public int h;
	private ArrayList <Building> builds;
	private byte[] buildsin;
	private byte[] Background;
	private Screen screen;
	private Camera cam;
	private Building[] Build;
	private ArrayList<Soldier> solds;
	
	public Level(Screen screen, Camera camera){
		this.w = screen.w/8;
		this.h = screen.h/8;
		this.screen = screen;
		Background = new byte[this.w*this.h];
		builds = new ArrayList<Building>();
		buildsin = new byte[this.w*this.h];
		Build = new Building[this.w*this.h];
		solds = new ArrayList<Soldier>();
		cam = camera;
	}
	
	public void AddBuilding(int x, int y, GameSource game){
		int xo = x/16;
		int yo = y/16;
		int Difx = (cam.x - screen.w/2);
		int Dify = cam.y - (screen.h-8)/2;
		int Sum = (Difx)/16;
		int Mul = (Dify)/16;
		if(!AnyBuildingInZone(x,y)){
			Build[xo+(yo+Mul)*this.w+Sum]= new Building(x,y,game);
			buildsin[xo+(yo+Mul)*this.w+Sum] = 1;
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
		 	int xo = xScroll/16;
	        int yo = yScroll/16;
	        int w = screen.w+15 >> 4;
	        int h = screen.h >> 4;
	        screen.setOffset(xScroll, yScroll);
	        for(int y = yo; y <= h + yo; y++)
	        {
	            for(int x = xo; x <= w + xo; x++){
	                Tile.tiles[Background[x+y*(this.w)]].render(screen, x*16, y*16,false);
	            	if(buildsin[x+y*(this.w)]==1){
	            		Build[x+y*(this.w)].Render(screen, x*16, y*16);
	            	}
	            }
	        }
	        screen.setOffset(0, 0);
	        renderSoldiers();
	}
	
	public void RenderBuildings(){
		for(int i = 0; i< builds.size();i++){
			builds.get(i).Render(screen,0,0);
		}
	}
	
	public void RenderPossibleBuildings(int xScroll, int yScroll){
	 	int xo = xScroll/16;
        int yo = yScroll/16;
        int w = screen.w + 15 >> 4;
        int h = screen.h >> 4;
        screen.setOffset(xScroll, yScroll);
        for(int y = yo; y <= h + yo; y++)
        {
            for(int x = xo; x <= w + xo; x++){
            	if(buildsin[x+y*(this.w)]==0){
            		Tile.tiles[Background[x+y*(this.w)]].render(screen, x*16, y*16,true);
            	}else{
            		Tile.tiles[Background[x+y*(this.w)]].render(screen, x*16, y*16,false);
            		Build[x+y*(this.w)].Render(screen, x*16, y*16);
            	}
            }

        }
        screen.setOffset(0, 0);
	}
	
	public void addSoldier(Soldier sol) {
		solds.add(sol);
	}
	
	private void renderSoldiers() {
		for (int i = 0; i< solds.size(); i++) {
			solds.get(i).render(screen);
		}
	}
	
	public void tick() {
		for (int i = 0; i < Build.length; i++) {
			if(buildsin[i] == 1) {
				Build[i].tick();
			}
		}
		for (int i = 0; i < solds.size(); i++) {
			solds.get(i).tick();
		}
		
	}
}
