package pong.copy;
/*
 * @author Sean Randunne, Shalin Mehta
 * @teacher(Ms. Denna)
 * @version(12/17/2017)
 * This is the Block class which connects the functions of the Rackets and the goals
 */
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract 
class Block {
    private int width, height;
    private Pong game;
    private int up, down, left, right;
    private int x, xa;
    private int y, ya;
    /*
	 * @param(Pong game - the game board itself)
	 * @param(int up - keys to be pressed to move the rackets up)
	 * @param(int down - keys to be pressed to move the rackets down)
	 * @param(int left - keys to be pressed to move the rackets to the left)
	 * @param(int right - keys to be pressed to move the rackets to the right)
	 * @param(int width - the width of the racket)
	 * @param(int height - the height of the racket)
	 */
    public Block(Pong game, int up, int down, int left, int right, int x, int width, int height) {
        this.game = game;
        this.x = x;
        y = game.getHeight() / 3;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.width = width;
        this.height = height;
    }
    // updates the position of the blocks to make movement as seamless as possible
    public void update() {
        if (y > 0 && y < game.getHeight() - height - 29)
            y += ya;
        else if (y == 0)
            y++;
        else if (y == game.getHeight() - height - 29)
            y--;
        if (x > 0 && x < game.getWidth() - width - 29)
            x += xa;
        else if (x == 0)
            x++;
        else if (x == game.getWidth() - width - 29)
            x--;
        
    
    }
    /*
     * @param(int keycode - the keycode pressed by the players)
     * checks to see which way the play wants to go and does the action
     */
    public void pressed(int keyCode) {
        if (keyCode == up)
            ya = -1;
        else if (keyCode == down)
            ya = 1;
        else if(keyCode == left)
        {
        	xa = -1;
        }
        else if(keyCode == right)
        {
        	xa = 1;
        	
        }
        	
    }
    /*
     * @param(int keycode - the keycode pressed by the student)
     * stops the direction the rackets are going in
     */
    public void released(int keyCode) {
        if (keyCode == up || keyCode == down)
            ya = 0;
        if(keyCode == left || keyCode == right)
        	xa = 0;
    }
    /*
     * @return(Rectangle rect - a rectangle)
     * returns a new rectangle when ever called
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    /*
     * @param(Graphics g - a Graphics object)
     * fills the rectangle with color
     */
    public void paint(Graphics g) {
        g.fillRect(x, y, width, height);
        
    }
}