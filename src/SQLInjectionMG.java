public class SQLInjectionMG extends MiniGame
{

    private String response;

    private static String[] possibleAnswers = {"a", "b", "c", "d"};

    //in terminal for now, so no gui yet
    protected void drawStuff()
    {
        System.out.println("You've come across a website with a form for a username and password.\n" +
                "After further inspection, you were able to discover that how the website\n" +
                "stores and accesses its username and password:\n\n" + "uName = getRequestString('username');\n" +
                        "uPass = getRequestString('userpassword');\n\n" +
                "sql = 'SELECT * FROM Users WHERE Name ="' + uName + '" AND Pass ="' + uPass + '"'\n\n"
                "To beat this challenge you need to login 'without' a username or password.")
    }

    protected void getInput()
    {
        System.out.println("Enter the injection: ")
        Scanner scan = new Scanner(System.in);
        response = scan.nextLine();

        while (timer_ != 0)
            validateInput();

    }

    protected void validateInput()
    {
        player_won_ = false;
        for (int i = 0; i < possibleAnswers.length(); i++)
        {
            if (possibleAnswers[i] == response)
            {
                player_won_ = true;
                return;
            }
        }
        if (!player_won_)
        {
            System.out.println("Incorrect. Please try again.")
            getInput();
        }
    }

    protected void miniGameWon()
}
