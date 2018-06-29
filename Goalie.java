package pong;
/*
 * @author Sean Randunne, Shalin Mehta
 * @teacher(Ms. Denna)
 * @version(5/9/2018)
 * This is the Goalie class which creates all of the information for the goals.
 */
public class Goalie extends Block
{
	/*
	 * @param(AirHockey game - the game board itself)
	 * @param(int up - keys to be pressed to move the rackets up)
	 * @param(int down - keys to be pressed to move the rackets down)
	 * @param(int left - keys to be pressed to move the rackets to the left)
	 * @param(int right - keys to be pressed to move the rackets to the right)
	 * @param(int width - the width of the racket)
	 * @param(int height - the height of the racket)
	 */
	public Goalie(AirHockey game, int up, int down, int left, int right, int x, 
			int width, int height)
	{
		super(game, up, down, left, right, x, width, height);
	}
}
