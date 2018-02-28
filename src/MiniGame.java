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
