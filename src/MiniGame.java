import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public abstract class MiniGame
{

    //fields
    //private boolean isInput;
    //protected double timer_;
    protected JFrame frame_;
    protected JButton main_menu_; //TODO -- put this on screen
	protected JPanel panel_;

    protected boolean player_won_;
    long start_time_;
    long elapsed_time_;
    long timer_;

    //methods
<<<<<<< HEAD
    //protected abstract drawStuff();
    //protected abstract getInput();
    //protected abstract validateInput();
    //protected abstract giveHint();

    public MiniGame(long timer)
    {
        this.elapsed_time_ = 0L;
        this.timer_ = timer;
        this.start_time_ = System.currentTimeMillis();
    }
    
    public boolean playerWon()
=======
    protected abstract void drawStuff();
    protected abstract void getInput();
    protected abstract void validateInput();
    protected abstract void giveHint();
    protected abstract void decrementTimer();



//    public void run()
//    {
//        drawStuff();
//        getInput();
//
//	    while(!player_won_ && counter > 0)
//	    {
//
//	        if(counter == timer_/2)
//	            giveHint();
//
//	        decrementTimer();
//	    }
//
//	    if (!player_won_)
//	        endGame();
//    }

    public MiniGame(double timer)
>>>>>>> 6ad82dbbd88a2da43b16f4a1638e9aaf1e5c6454
    {
        while (!player_won_ && elapsed_time_ < timer_)
        {
            this.elapsed_time_ = (new Date()).getTime() - this.start_time_;
            frame_.repaint();
        }
        return this.player_won_;
    }
}
