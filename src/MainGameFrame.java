
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainGameFrame extends JFrame
{

    //JFrame Frame;
    //JButton Button1;

    public MainGameFrame()
    {
        super("COUNTDOWN");
        JPanel panel = new JPanel();
        JButton Button1 = new JButton("Start Game");
        panel.add(Button1);

        this.getContentPane().add(panel);

        Button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==Button1)
                {
                    MiniGameFrame mg = new MiniGameFrame();
                    //Call a function from MiniGameFrame to actually
                    //make the minigame
                }
            }
        });
    }
}