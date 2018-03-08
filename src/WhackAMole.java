import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.ScheduledFuture;

public class WhackAMole extends MiniGame
{

    private BufferedImage mole_;
    private boolean mole_whacked_ = false;
    private JButton mole_button_ = new JButton();
    private static ScheduledFuture<?> self;
    private static JTextField win_message_ = new JTextField("Winner!");
    private static JTextField lose_message_ = new JTextField("Loser!");


    WhackAMole(long timer)
    {
        super(timer);
        try {
            this.setImage();
        }
        catch (IOException IE) {
            System.out.println("IO Error");
        }

        mole_button_.setIcon(new ImageIcon(mole_));

        super.add(mole_button_);

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
        super.add(mole_button_);
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
            mole_button_.setLocation(randomLocation(), randomLocation());

            mole_button_.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    if (event.getSource() == mole_button_)
                    {
                        mole_whacked_ = true;
                        self.cancel(false);
                        displayResults();
                    }
                }
            });
            repaint();
        }
    };

    public void moveMole()
    {

        ScheduledExecutorService mole_mover = Executors.newScheduledThreadPool(1);
        self = mole_mover.scheduleAtFixedRate(moveMoleRunnable, 0, 250, TimeUnit.MILLISECONDS);

    }


    public void displayResults()
    {
        if (mole_whacked_)
        {
            super.add(win_message_);
            super.player_won_ = true;
            win_message_.setVisible(true);
            win_message_.setEditable(false);
        }
        else
        {
            super.add(lose_message_);
            super.player_won_ = false;
            lose_message_.setVisible(true);
            lose_message_.setEditable(false);
        }

        super.revalidate();

    }

}
