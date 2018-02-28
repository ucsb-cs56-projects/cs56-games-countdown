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
    {
        return this.player_won_;
    }

    public MiniGame(double timer)
    {
        while (!player_won_ && elapsed_time_ < timer_)
        {
            this.elapsed_time_ = (new Date()).getTime() - this.start_time_;
            frame_.repaint();
        }
    }
}
