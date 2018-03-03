import java.util.Date;
import javax.swing.*;

public abstract class MiniGame extends JFrame
{

    //fields
    //private boolean isInput;
    //protected double timer_;
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
        super();    
		this.setVisible(true);
        this.elapsed_time_ = 0L;
        this.timer_ = timer;
        this.start_time_ = System.currentTimeMillis();
    }

    public boolean playerWon()
    {
       // while (!player_won_ && elapsed_time_ < timer_)
       // {
        //    this.elapsed_time_ = (new Date()).getTime() - this.start_time_;
        //    frame_.repaint();
       // }
        return this.player_won_;
    }
}
