
public class SQLInjection extends MiniGame
{

    private String question;

    SQLInjection(long timer, String textField)
    {
        super(timer, textField);
        this.question = textField;
        super.frame_.setSize(550, 600);
        super.frame_.setTitle("SQL Injection!");
    };

    private String response;

    private static String[] possibleAnswers = {"a", "b", "c", "d"};

    //in terminal for now, so no gui yet

}
