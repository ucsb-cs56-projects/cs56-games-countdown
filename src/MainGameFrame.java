
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainGameFrame extends JFrame
{
    public static void main(String[] args)
    {
        MainGameFrame frame = new MainGameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
    }

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
                    LightsOut lights_out = new LightsOut(60000L);
                    boolean player_won = lights_out.playerWon();
                    if (player_won)
                        System.out.println("Player won!");
                    else
                        System.out.println("Player lost!");

                    SQLInjection sqlQuiz = new SQLInjection(500L, "You've come across a website with a form for a username and password.\n" +
                            "After further inspection, you were able to discover that how the website\n" +
                            "stores and accesses its username and password:\n\n" + "uName = getRequestString('username');\n" +
                            "uPass = getRequestString('userpassword');\n\n" +
                            "sql: 'SELECT * FROM Users WHERE Name = ' + uName + ' AND Pass = ' + uPass + '\n\n" +
                            "To beat this challenge you need to login 'without' a username or password.");
                }
            }
        });
    }
}