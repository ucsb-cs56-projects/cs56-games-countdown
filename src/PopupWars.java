import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Clock;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PopupWars extends MiniGame
{

    private BufferedImage mole_;
    private boolean mole_whacked_ = false;

    PopupWars(long timer)
    {
        super(timer);
        try {
            this.setImage();
        }
        catch (IOException IE) {
            System.out.println("IO Error");
        }
        this.setVisible(true);

        moveMole();

    }

    private void setImage() throws IOException
    {
        mole_ = ImageIO.read(new File("mole.jpg"));
    }

    @Override
    public void paintComponent(java.awt.Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(this.mole_, this.randomLocation(), this.randomLocation(), null);

    }

    public int randomLocation()
    {
        int x = (int)(Math.random() * 600);
        return x;
    }

    Runnable moveMoleRunnable = new Runnable()
    {
        public void run()
        {
            repaint();
        }
    };

    public void moveMole()
    {
        ScheduledExecutorService mole_mover = Executors.newScheduledThreadPool(1);
        mole_mover.scheduleAtFixedRate(moveMoleRunnable, 0, 150, TimeUnit.MILLISECONDS);
        if (mole_whacked_)
            return;

    }


}
