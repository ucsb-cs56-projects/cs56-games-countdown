import java.awt.Graphics;

class Maze extends MiniGame
{
    public Maze(long timer)
    {
        super(timer);
        this.setSize(500,500);
    }
    public void paint(java.awt.Graphics g)
    {
        for (int i = 0; i < 500; ++i)
            for (int j = 0; j < 500; j += 10)
                g.drawLine(i, j, i + 10, j);
    }
}