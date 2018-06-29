package pong;
/*
 * @author Sean Randunne, Shalin Mehta
 * @teacher(Ms. Denna)
 * @version(5/9/2018)
 * This is the AirHockey class which executes the IceRink game
 * After 5 goals the game ands and restarts
 * to move player 1 use keys a, w, s, and d
 * to move player 2 use the up, down, left, and right keys
 * reference: https://codereview.stackexchange.com/questions/27197/pong-game-in-java
 */
import java.awt.Color;
import javax.swing.JFrame;


public class AirHockey{
    private final static int WIDTH = 700, HEIGHT = 450;
    private static IceRink panel;
    private static JFrame myFrame;
    //instantiates everything for the JFrame and its properties
    public AirHockey() {
    	myFrame = new JFrame();
    	myFrame.setBackground(Color.GREEN);
    	myFrame.setSize(WIDTH, HEIGHT);
        myFrame.setTitle("AirHockey");
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new IceRink(this);
        myFrame.add(panel);
        myFrame.setVisible(true);
    }
    
    /*
     * @return(the width of the JFrame)
     */
    public int getWidth()
    {
    	return myFrame.getWidth();
    }
    
    //@return(the height of the JFrame)
    public int getHeight()
    {
    	return myFrame.getHeight();
    }
    //@return(the IceRink)
    public IceRink getPanel() {
        return panel;
    }

    public static void main(String[] args) {
    	new AirHockey();
    }
}
