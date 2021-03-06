import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class MouseClickHandler implements MouseListener{
	private GameSource game;
	public ArrayList<button> buttons;
    public button button1;
    public button House;
    
	public class button{
		 public void toggle(boolean pressed)
	        {
	            if(pressed != down)
	                down = pressed;
	            if(pressed)
	                presses++;
	        }

	        public void tick()
	        {
	            if(absorbs < presses)
	            {
	                absorbs++;
	                clicked = true;
	            } else
	            {
	                clicked = false;
	            }
	        }

	        public int presses;
	        public int absorbs;
	        public boolean down;
	        public boolean clicked;
	        final MouseClickHandler this$0;

	        public button()
	        {
	        	super();
	            this$0 = MouseClickHandler.this;
	            buttons.add(this);
	        }
	}
	
	public void releaseAll(){
		for(int i=0;i<buttons.size();i++){
			((button)buttons.get(i)).down = false;
		}
	}
	
	public void tick(){
		for(int i=0;i<buttons.size();i++){
			((button)buttons.get(i)).tick();
		}
	}
	public MouseClickHandler(GameSource game){
		buttons = new ArrayList<button>();
		button1 = new button();
		House = new button();
        game.addMouseListener(this);
        this.game = game;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON1){
			if(((e.getX()/3) < 9) && ((e.getX()/3) > 1) && ((e.getY()/3) > 113) && ((e.getY()/3) <= 120)){
				if(game.House){
					game.House= false;
				}else{
					game.House = true;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent ME) {
		// TODO Auto-generated method stub
		toggle(ME, true);
	}

	@Override
	public void mouseReleased(MouseEvent ME) {
		// TODO Auto-generated method stub
		toggle(ME, false);
	}
	
	private void toggle(MouseEvent ME, boolean pressed){
		if(ME.getButton() == MouseEvent.BUTTON1){
			if(ME.getX()/3 < 9 && ME.getX()/3 > 1 && ME.getY()/3 > 113 && ME.getY()/3 < 120){
				House.toggle(pressed);
			}
			else{
				button1.toggle(pressed);
			}
		}
	}

}
