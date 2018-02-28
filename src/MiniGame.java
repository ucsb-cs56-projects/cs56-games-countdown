import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public abstract class MiniGame
{

    //fields
    //private boolean isInput;
    //protected double timer_;
    protected boolean player_won_;
    //protected double counter = timer_;

    //methods
    protected abstract drawStuff();
    //protected abstract getInput();
    //protected abstract validateInput();
    //protected abstract giveHint();

    public MiniGame()
    {

    }

    public MiniGame(double timer)
    {
	//this.timer_ = timer;
    }

    public void run()
    {
	    while(!player_won_)
	    {
            this.drawStuff();
	    }
    }

}
