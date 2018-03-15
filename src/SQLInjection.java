import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SQLInjection extends MiniGame
{
	protected JTextField textField_;
	protected JTextArea textArea_;
    private String question; //This is never used
    private String response; //This is also never used
    private static String[] possibleAnswers = {"\" or \"\"=\"", "\" OR \"\"=\"", "\" OR 1=1\"", "\" or 1=1\""};
    private JButton answer = new JButton("\" OR \"\"=\"");
    private JButton fake_answer1 = new JButton("1=1");
    private JButton fake_answer2 = new JButton("admin OR \"\"");
    private JButton fake_answer3 = new JButton("SELECT * FROM Users");
    private JLabel outcome_;

    SQLInjection(long timer, String textArea)
    {
        super(timer);
        this.setSize(550, 600);
        this.outcome_ = new JLabel();
        this.textArea_ = new JTextArea(textArea);
        this.textArea_.setEditable(false);
        this.add(this.textArea_);
        this.setVisible(true);
        this.question = textArea;

        JPanel buttonPanel  = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        this.add(buttonPanel);
        buttonPanel.add(answer);
        buttonPanel.add(fake_answer1);
        buttonPanel.add(fake_answer2);
        buttonPanel.add(fake_answer3);
        answer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (event.getSource() == answer)
                {
                    boolean input_is_valid = true;
                    SQLInjection.this.endResult(input_is_valid);
                }
            }
        });

        fake_answer1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (event.getSource() == fake_answer1)
                {
                    boolean input_is_valid = false;
                    SQLInjection.this.endResult(input_is_valid);
                }
            }
        });

        fake_answer2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (event.getSource() == fake_answer2)
                {
                    boolean input_is_valid = false;
                    SQLInjection.this.endResult(input_is_valid);
                }
            }
        });
        fake_answer3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (event.getSource() == fake_answer3)
                {
                    boolean input_is_valid = false;
                    SQLInjection.this.endResult(input_is_valid);
                }
            }
        });
        this.add(outcome_);
    };


    public boolean validateInput(String input)
    {
        SQLInjection.this.player_won_ = false;

        for (String answer : possibleAnswers)
        {
            if (input.equals(answer))
                SQLInjection.this.player_won_ = true;
        }

        return SQLInjection.this.player_won_;
    }

    public void endResult(boolean input_is_valid)
    {
        if (input_is_valid)
            this.outcome_.setText("WINNER!");
        else
            this.outcome_.setText("LOSER!");
    }
}
