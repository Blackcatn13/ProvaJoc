import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MouseHandler implements MouseMotionListener{
	public int x,y;
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX()/3;
		y = e.getY()/3;
		//System.out.println(x+","+y);
	}
	
	public MouseHandler(GameSource game){
		game.addMouseMotionListener(this);
	}

}
