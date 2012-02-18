
public class Camera {
	public int x,y;
	private InputHandler input;
	private MouseHandler input1;
	
	public Camera(InputHandler Input, MouseHandler Input1){
		x = 80;
		y = 56;
		input = Input;
		input1 = Input1;
	}
	
	public void tick(){
		if(input.down.down && y < 183) y++;
		if(input.up.down && y > 56) y--;
		if(input.left.down && x > 80) x--;
		if(input.right.down && x < 239) x++;
		if(input1.x > 155 && x < 239) x++;
		if(input1.x < 5 && x > 80) x--;
		if(input1.y > 100 && y < 183) y++;
		if(input1.y < 5 && y > 56) y--;
		
	}
}
