import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SQLInjection extends MiniGame
{

    private String question;
    private String response;
    private static String[] possibleAnswers = {"\" or \"\"=\"", "\" OR \"\"=\"", "\" OR 1=1\"", "\" or 1=1\""};
    private JButton submit = new JButton("Submit");

    SQLInjection(long timer, String textField)
    {
        super(timer, textField);
        this.question = textField;
        super.frame_.setSize(550, 600);
        super.frame_.setTitle("SQL Injection!");
        super.panel_.add(submit);

        submit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (event.getSource() == submit)
                {
                    if (validateInput(SQLInjection.super.textField_.getText()))
                        System.out.println("Player won!");
                    else
                        System.out.println("Player lost!");

                   SQLInjection.super.panel_.add(endResult(validateInput(SQLInjection.super.textField_.getText())));

                }
            }
        });
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

    public JTextField endResult(boolean submission)
    {
        JTextField result = new JTextField();
        result.setEditable(false);

        if (submission)
            result.setText("WINNER!");
        else
            result.setText("LOSER! DARSHH");

        return result;
    }

}
