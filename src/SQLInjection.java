import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SQLInjection extends MiniGame
{
	protected JTextField textField_;
	protected JTextArea textArea_;
    private String question; //This is never used
    private String response; //This is also never used
    private static String[] possibleAnswers = {"\" or \"\"=\"", "\" OR \"\"=\"", "\" OR 1=1\"", "\" or 1=1\""};
    private JButton submit = new JButton("Submit");
    private JLabel outcome_;

    SQLInjection(long timer, String textArea)
    {
        super(timer);
        this.outcome_ = new JLabel();
        this.textArea_ = new JTextArea(textArea);
        this.textArea_.setEditable(false);
        this.add(this.textArea_);
        this.textField_ = new JTextField(25);
        this.add(this.textField_);
        this.setVisible(true);
        this.question = textArea;
        this.setSize(550, 600);

        this.add(submit);
        submit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (event.getSource() == submit)
                {
                    boolean input_is_valid = validateInput(SQLInjection.this.textField_.getText());
                    if (input_is_valid)
                        System.out.println("Player won!");
                    else
                        System.out.println("Player lost!");
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
            this.outcome_.setText("LOSER! DARSHH");
    }
}
