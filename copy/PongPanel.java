package pong.copy;
/*
 * @author Sean Randunne, Shalin Mehta
 * @teacher(Ms. Denna)
 * @version(12/17/2017)
 * This is the PongPanel class 
 * which brings all of the Rackets, Balls, and Goals into one central game
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
    private Pong game;
    private Ball ball;
    private Block player1,player2, goal1, goal2;
    private int score1, score2;
    /*
     * @param(Pong game - the game board)
     * creates the players, goals and the ball needed to play the game
     */
    public PongPanel(Pong game) {
        this.game = game;
        setBackground(Color.GREEN);
        ball = new Ball(game);
        player1 = new Racket(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, 
        		KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, game.getWidth() - 150, 10, 60);
        player2 = new Racket(game, KeyEvent.VK_W, KeyEvent.VK_S, 
        		KeyEvent.VK_A, KeyEvent.VK_D,  150, 10, 60);
        goal1 = new Goalie(game, 20, 20, 20, 20, 0, 10, 140);
        goal2 = new Goalie(game, 20, 20, 20, 20, game.getWidth() - 15, 10, 140);
        
        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }
    /*
     * @param(int playerNo - the )
     * @return(Block player - returns the player 
     * based on the parameter that is passed in)
     * 
     */
    public Block getBlock(int blockNo) {
        if (blockNo == 1)
            return player1;
        else if (blockNo == 2)
        	return player2;
        else if(blockNo == 3)
            return goal1;
        else
            return goal2;
        	
        
    }
    /*
     * @param(int playerNo - the number of the player that got the goal)
     * increases the score based on who scored a goal
     */
    public void increaseScore(int playerNo) throws IOException {
        if (playerNo == 3)
        {
            score2++;
            play("applause_y.wav");
            JOptionPane.showMessageDialog(null, "Team 2 scores!!!!!!!", "Pong", JOptionPane.PLAIN_MESSAGE);
           
        }
        else if(playerNo == 4)
        {
            score1++;
            play("applause_y.wav");
            JOptionPane.showMessageDialog(null, "Team 1 scores!!!!!", "Pong", JOptionPane.PLAIN_MESSAGE);
        }
    }
    /*
     * @param(String audioFilePath - the name of audio file)
     * plays an audio file when passed in the name of a valid .wav audio file
     */
    public static void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);
 
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();
            boolean playCompleted = false;
            while (!playCompleted) {
                try {
                    Thread.sleep(1000);
                    playCompleted = true;
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
             
            audioClip.close();
             
        } catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }
    }
    /*
     * @param(int playerNo - the number of the player)
     * @return(the score of the player the playerNo is referring to)
     */
    public int getScore(int playerNo) {
        if (playerNo == 5)
            return score1;
        else
            return score2;
    }
    // updates the position of the ball, player, and the goal 
    //so that the action seems fluid
    private void update() throws IOException {
        ball.update();
        player1.update();
        player2.update();
        goal1.update();
        goal2.update();
    }
    /*
     * @param(ActionEvent e - the key clicked by the user)
     * performs the action of the key clicked by the user
     */
    public void actionPerformed(ActionEvent e) {
        try {
			update();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        repaint();
    }
    /*
     * @param(KeyEvent e - the code of the key clicked by the players)
     * when the key is pressed it moves the rackets
     */
    public void keyPressed(KeyEvent e) {
        player1.pressed(e.getKeyCode());
        player2.pressed(e.getKeyCode());
    }
    /*
     * @param(KeyEvent e - the code of the key clicked by the players)
     * when the key is released by the player it stops moving the racket
     */
    public void keyReleased(KeyEvent e) {
        player1.released(e.getKeyCode());
        player2.released(e.getKeyCode());
        
    }
    /*
     * @param(KeyEvent e - the code of the key clicked by the players)
     * does nothing if the user tries to type something
     */
    public void keyTyped(KeyEvent e) {
        ;
    }
    /*@param(Graphics g - creates a graphic object)
     * draws everything in the soccer field
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g.drawString(game.getPanel().getScore(5) + " : " + game.getPanel().getScore(6), game.getWidth() / 2 -21, 30);
        g.setColor(Color.BLACK);
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
        goal1.paint(g);
        goal2.paint(g);
    }
}