import java.util.ArrayList;


public class Level {
	public int w;
	public int h;
	private ArrayList <Building> builds;
	private byte[] Background;
	private Screen screen;
	
	public Level(Screen screen){
		this.w = screen.w/8;
		this.h = screen.h/8;
		this.screen = screen;
		Background = new byte[this.w*this.h];
	}
	
	public void AddBuilding(int x, int y, GameSource game){
		builds.add(new Building(x,y,game));
	}
	
	public void InitBackground(){
		for(int i = 0; i < w*h;i++){
				Background[i]=Tile.grass.Id;
		}
		Background[53] = Tile.rock.Id;
		Background[100] = Tile.rock.Id;
		Background[255] = Tile.rock.Id;
		Background[299] = Tile.rock.Id;
		Background[200] = Tile.rock.Id;
		Background[180] = Tile.rock.Id;
		Background[150] = Tile.rock.Id;
		Background[0] = Tile.rock.Id;
		
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
	                Tile.tiles[Background[x+y*w]].render(screen, x*16, y*16);

	        }

	        screen.setOffset(0, 0);
		/*for(int i = 0; i < Background.length;i++){
			Tile.tiles[Background[i]].render(screen,(i%10)*16 ,(i/10)*16);
		}*/
	}
}
