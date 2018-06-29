package pong.copy;
/*
 * @author Sean Randunne, Shalin Mehta
 * @teacher(Ms. Denna)
 * @version(12/17/2017)
 * This is the Pong class which executes the PongPanel game
 */
import java.awt.Color;
import javax.swing.JFrame;


public class Pong{
    private final static int WIDTH = 700, HEIGHT = 450;
    private static PongPanel panel;
    private static JFrame myFrame;
    //instantiates everything for the JFrame and its properties
    public Pong() {
    	myFrame = new JFrame();
    	myFrame.setBackground(Color.GREEN);
    	myFrame.setSize(WIDTH, HEIGHT);
        myFrame.setTitle("Pong");
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new PongPanel(this);
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
    //@return(the PongPanel)
    public PongPanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
    	new Pong();
    }
}
