package pong;
/*
 * @author Sean Randunne, Shalin Mehta
 * @teacher(Ms. Denna)
 * @version(5/9/2018)
 * This is the Ball class which performs all of the functions for the ball
 */
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JOptionPane;

public class Puck {
    private static final int WIDTH = 30, HEIGHT = 30;
    private AirHockey game;
    private int x, y, xa = 2, ya = 2;

    /*
     * @param(AirHockey game - the game board)
     * instantiates the game and creates the x and y coordinates 
     * that the positioning of the ball is dependent on
     */
    public Puck(AirHockey game) {
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }
    // updates the position of the ball so that the ball 
    //appears to be moving in a direction
    public void update() throws IOException {
        x += xa;
        y += ya;
        
        if(game.getPanel().getBlock(3).getBounds().intersects(getBounds()))
            {
                game.getPanel().increaseScore(3);
            }
        if(game.getPanel().getBlock(4).getBounds().intersects(getBounds()))
            {
                game.getPanel().increaseScore(4);
            }
        
        
        if (x < 0) {
            
            xa = -xa;
            
        }
        
        else if (x > game.getWidth() - WIDTH - 7) {
              xa = -xa;
        }
        else if (y < 0 || y > game.getHeight() - HEIGHT - 29)
            ya = -ya;
        if (game.getPanel().getScore(5) > 4)
        {
            JOptionPane.showMessageDialog(null, "Team 1 wins. "
            		+ "The game will be reset.", "AirHockey", JOptionPane.PLAIN_MESSAGE);
        	game.getPanel().resetScore();
        }
        else if (game.getPanel().getScore(6) > 4)
        {
            JOptionPane.showMessageDialog(null, "Team 2 wins. "
            		+ "The game will be reset.", "AirHockey", JOptionPane.PLAIN_MESSAGE);
            game.getPanel().resetScore();
        }
        checkCollision();
    }
    //checks for a collision between the ball and one of the goals or rackets
    //of there is a collision it inverts the x coordinate so that the ball 
    //starts to move in the oppoistie direction
    public void checkCollision() {
        if (game.getPanel().getBlock(1).getBounds().intersects(getBounds()) ||
            game.getPanel().getBlock(2).getBounds().intersects(getBounds()) || 
            game.getPanel().getBlock(3).getBounds().intersects(getBounds()) || 
            game.getPanel().getBlock(4).getBounds().intersects(getBounds()))
            xa = -xa;
            
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawString("TEAM 1", 1, 30);
        g.drawString("TEAM 2", 600, 30);
        g.draw3DRect(350, 0, 4, 470, true);
        g.fillRect(350, 0, 4, 470);
        g.setColor(Color.BLACK);
        g.draw3DRect(-6, 120, 75, 200, true);
        g.draw3DRect(630, 120, 75, 200, true);
        g.drawOval(300, 160, 100, 100);
        g.drawArc(20, 165, 100,100, 270, 180);
        g.drawArc(580, 165, 100,100, 90, 180);
      
        
    }
}