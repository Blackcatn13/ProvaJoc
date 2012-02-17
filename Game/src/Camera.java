
public class Camera {
	int x,y;
	InputHandler input;
	
	public Camera(InputHandler Input){
		x = 80;
		y = 56;
		input = Input;
	}
	
	public void tick(){
		if(input.down.down && y < 120) y++;
		if(input.up.down && y > 56) y--;
		if(input.left.down && x > 80) x--;
		if(input.right.down && x < 160) x++;
	}
}
