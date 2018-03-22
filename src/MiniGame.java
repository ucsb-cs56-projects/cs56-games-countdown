import java.util.Date;
import javax.swing.*;

public abstract class MiniGame extends JPanel   
{
    //fields
    //private boolean isInput;
    //protected double timer_;
    protected boolean player_won_;
    long start_time_;
    long elapsed_time_;
    long timer_;
    protected static final int LEFTARROW_KEY_ = 37;
    protected static final int UPARROW_KEY_ = 38;
    protected static final int RIGHTARROW_KEY_ = 39;
    protected static final int DOWNARROW_KEY_ = 40;


    //methods
    //protected abstract drawStuff();
    //protected abstract getInput();
    //protected abstract validateInput();
    //protected abstract giveHint();

    //TODO -- add an instructional panel before starting the game. A player should see a list of controls and their function for whatever game. Obviously override in derived classes.
    public MiniGame(long timer)
    {
        super();
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
