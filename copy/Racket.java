package pong.copy;
/*
 * @author Sean Randunne, Shalin Mehta
 * @teacher(Ms. Denna)
 * @version(12/17/2017)
 * This is the Racket class 
 * which passes all of the racket information to the Racket class
 */
public class Racket extends Block
{
	/*
	 * @param(Pong game - the game board itself)
	 * @param(int up - keys to be pressed to move the rackets up)
	 * @param(int down - keys to be pressed to move the rackets down)
	 * @param(int left - keys to be pressed to move the rackets to the left)
	 * @param(int right - keys to be pressed to move the rackets to the right)
	 * @param(int width - the width of the racket)
	 * @param(int height - the height of the racket)
	 */
	public Racket(Pong game, int up, int down, int left, int right, int x, 
			int width, int height)
	{
		super(game,up,down, left, right, x, width,height);
	}
}