public abstract class MiniGame
{
    //fields
    protected double timer_;
    protected boolean player_won_;
    
    //methods
    public MiniGame(double timer)
    {
	this.timer_ = timer;
    }
    public void run()
    {
	while(!player_won_ && timer_ > 0)
	{
	    //drawstuff
	    //get input
	    //decrement timer
	}
    }

    protected abstract drawStuff();
    protected abstract getInput();
    protected void decrementTimer();    
}
