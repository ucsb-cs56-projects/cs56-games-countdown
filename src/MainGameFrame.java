import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainGameFrame extends JFrame
{
    private static final String MAIN_MENU_ = "main menu";
    private static final String ACTIVE_GAME_ = "active game";
    private static final int TOP_MENU_SIZE_ = 50;
    CardLayout card_layout_;
    JPanel main_panel_;
    JPanel main_menu_;
    JPanel top_menu_;
    JPanel minigame_panels_;
    JSplitPane split_pane_;
    private Minigame active_minigame_;

    public static void main(String[] args)
    {
        MainGameFrame frame = new MainGameFrame();
    }

    public MainGameFrame()
    {
        super();

        card_layout_ = new CardLayout();
        main_panel_ = new JPanel(card_layout_);

        main_menu_ = new JPanel();  
        JButton start_lights_out = new JButton("Play 'Lights Out!'");        
        main_menu_.add(start_lights_out);
        JButton start_maze = new JButton("Play 'Maze'");
        main_menu_.add(start_maze);
        JButton start_SQL_inj = new JButton("Try 'SQL Injection'");
        main_menu_.add(start_SQL_inj);
        JButton start_WhackAMole = new JButton("Try 'Whack-a-Mole!'");
        main_menu_.add(start_WhackAMole);
        main_panel_.add(main_menu_, MAIN_MENU_);

        top_menu_ = new JPanel();
        JButton main_menu_button = new JButton("Return to main menu");
        top_menu_.add(main_menu_button);     
        split_pane_ = new JSplitPane();
        split_pane_.setOrientation(JSplitPane.VERTICAL_SPLIT);
        split_pane_.setDividerLocation(TOP_MENU_SIZE_);
        split_pane_.setTopComponent(top_menu_);        
        split_pane_.setEnabled(false);
        
        this.setTitle("COUNTDOWN");
        this.setLayout(new GridLayout());
        this.setContentPane(main_panel_);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.setSize(750, 750);
        this.setVisible(true);

        start_lights_out.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==start_lights_out)
                {                  
                    LightsOut lights_out = new LightsOut(60000L);                         
                    MainGameFrame.this.setActiveGame(lights_out);
                }
            }
        });

        start_maze.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==start_maze)
                {                  
                    Maze maze = new Maze(60000L);                         
                    MainGameFrame.this.setActiveGame(maze);
                }
            }
        });

        start_SQL_inj.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==start_SQL_inj)
                {

                     SQLInjection sqlQuiz = new SQLInjection(500L, "You've come across a website with a form for a username and password.\n" +
                             "After further inspection, you were able to discover that how the website\n" +
                             "stores and accesses its username and password:\n\n" + "uName = getRequestString('username');\n" +
                             "uPass = getRequestString('userpassword');\n\n" +
                             "sql: 'SELECT * FROM Users WHERE Name = ' + uName + ' AND Pass = ' + uPass + '\n\n" +
                             "To beat this challenge you need to login 'without' a username or password.\n\n" +
                             "Which of the following 4 inputs if inserted in a login form would bypass the login?"
                     );
                    MainGameFrame.this.setActiveGame(sqlQuiz);
                }
            }
        });

        start_WhackAMole.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource()==start_WhackAMole)
                {
                    WhackAMole wam = new WhackAMole(1000L);
                    MainGameFrame.this.setActiveGame(wam);
                }
            }
        });
        
        main_menu_button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                //go back to main menu
                MainGameFrame.this.card_layout_.removeLayoutComponent(split_pane_);
                MainGameFrame.this.card_layout_.show(main_panel_, MAIN_MENU_);
            }
        });
    }

    public void setActiveGame(MiniGame minigame)
    {
        this.split_pane_.setBottomComponent(minigame);
        this.main_panel_.add(split_pane_);
        this.card_layout_.next(main_panel_);
        minigame.setFocusable(true);
        minigame.requestFocusInWindow();
    }

}