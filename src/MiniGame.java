public abstract class MiniGame
{

    //fields
    private boolean isInput;

    protected double timer_;
    protected boolean player_won_;
    protected double counter = timer_;


    //methods
    protected abstract drawStuff();
    protected abstract getInput();
    protected abstract validateInput();
    protected abstract giveHint();
    protected void decrementTimer();

    public MiniGame(double timer)
    {
	this.timer_ = timer;
    }

    public endGame()
    {

    }

    public void run()
    {
        drawStuff();
        getInput();

	    while(!player_won_ && counter > 0)
	    {


	        if(counter = timer_/2)
	            giveHint();

	        decrementTimer();
	    }

	    if (!player_won_)
	        endGame();
    }

}
