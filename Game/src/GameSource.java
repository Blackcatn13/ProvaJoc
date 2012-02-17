import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Marc
 *
 */
public class GameSource extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Random random;
	private BufferedImage image;
	private int pixels[];
	private boolean running;
	private Screen screen;
	//private Screen lightScreen;
	private InputHandler input;
	private int colors[];
	private int tickCount;
	public int gameTime;
	private MouseHandler input1;
	private MouseClickHandler input2;
	private Level level;
	//private Level levels[];
	//private int currentLevel;
	//private ArrayList<Building> Builds;
	private Camera camera;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameSource game = new GameSource();
		game.setMinimumSize(new Dimension(480,360));
		game.setMaximumSize(new Dimension(480,360));
		game.setPreferredSize(new Dimension(480,360));
		JFrame frame = new JFrame("Prova");
		frame.setDefaultCloseOperation(3);
		frame.setLayout(new BorderLayout());
		frame.add(game,"Center");
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
		}
	public GameSource() {
		//random = new Random();
		image = new BufferedImage(160,120,1);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		running = false;
		input = new InputHandler(this);
		input1 = new MouseHandler(this);
		input2 = new MouseClickHandler(this);
		colors = new int[256];
		tickCount = 0;
		gameTime = 0;
		//Builds = new ArrayList<Building>();
		//levels = new Level[1];
		//currentLevel = 1;

	}
	
	public void start() {
		running = true;
		(new Thread(this)).start();
	}
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		double unprocessed = 0.0D;
		double nsPerTick = 16666666.666666666D;
		int frames = 0;
		int ticks = 0;
		long lastTimer1 = System.currentTimeMillis();
		init();
		while(running){
			long now = System.nanoTime();
			unprocessed += (double)(now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender;
			for(shouldRender = true; unprocessed >= 1.0D; shouldRender = true){
				ticks++;
				tick();
				unprocessed--;
			}
			
			try{
				Thread.sleep(2L);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(shouldRender){
				frames++;
				render();
			}
			if(System.currentTimeMillis()-lastTimer1 > 1000L){
				lastTimer1 += 1000L;
				System.out.println((new StringBuilder(String.valueOf(ticks))).append(" ticks, ").append(frames).append(" fps").toString());
				frames = 0;
				ticks = 0;
			}
		}
	}
	private void render() {
		// TODO Auto-generated method stub
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		
		int xScroll = camera.x - screen.w/2;
		int yScroll = camera.y - (screen.h-8)/2;
        
        level.RenderBackground(xScroll, yScroll);
        
		for(int y = 0; y < screen.h; y++)
        {
            for(int x = 0; x < screen.w; x++)
            {
                int cc = screen.pixels[x + y * screen.w];
                if(cc < 255)
                    pixels[x + y * screen.w] = colors[cc];
            }

        }
		Graphics g = bs.getDrawGraphics();
        g.fillRect(0, 0, getWidth(), getHeight());
        int ww = 480;
        int hh = 360;
        int xo = (getWidth() - ww) / 2;
        int yo = (getHeight() - hh) / 2;
        g.drawImage(image, xo, yo, ww, hh, null);
        g.dispose();
        bs.show();

        
        
	}
	private void tick() {
		// TODO Auto-generated method stub
		tickCount++;
		gameTime++;
		input2.tick();
		input.tick();
		camera.tick();
		if(input2.button1.down){
        	//Builds.add(new Building(input1.x,input1.y,this));
        	//Font.draw("Start game", screen, input1.x, input1.y, Color.get(0,15,50,165));
			level.AddBuilding(input1.x, input1.y, this);
			
        }
	}
	
	private void init(){
		int pp = 0;
        for(int r = 0; r < 6; r++)
        {
            for(int g = 0; g < 6; g++)
            {
                for(int b = 0; b < 6; b++)
                {
                    int rr = (r * 255) / 5;
                    int gg = (g * 255) / 5;
                    int bb = (b * 255) / 5;
                    int mid = (rr * 30 + gg * 59 + bb * 11) / 100;
                    int r1 = (((rr + mid * 1) / 2) * 230) / 255 + 10;
                    int g1 = (((gg + mid * 1) / 2) * 230) / 255 + 10;
                    int b1 = (((bb + mid * 1) / 2) * 230) / 255 + 10;
                    colors[pp++] = r1 << 16 | g1 << 8 | b1;
                }

            }

        }
        try{
        	screen = new Screen(160,120, new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/icons.png"))));
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        level = new Level(screen);
		level.InitBackground();
		camera = new Camera(input, input1);
	}
	public int MouseXPosition(){
		return input1.x;
	}
	public int MouseYPosition(){
		return input1.y;
	}
}
