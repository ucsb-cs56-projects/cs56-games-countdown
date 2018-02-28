public abstract class MiniGame
{

    //fields
    private boolean isInput;

    protected double timer_;
    protected boolean player_won_;
    protected double counter = timer_;


    //methods
    protected abstract void drawStuff();
    protected abstract void getInput();
    protected abstract void validateInput();
    protected abstract void giveHint();
    protected abstract void decrementTimer();

    public MiniGame(double timer)
    {
	    this.timer_ = timer;
    }

    public boolean endGame()
    {
        return player_won_;
    }


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

}
