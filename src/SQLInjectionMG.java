public class SQLInjectionMG extends MiniGame
{

    private String response;

    private static const String[] possibleAnswers = {"a", "b", "c", "d"};

    //in terminal for now, so no gui yet
    protected void drawStuff()
    {
        System.out.println("You've come across a website...")
    }

    protected boolean getInput()
    {
        System.out.println("Enter the injection: ")
        Scanner scan = new Scanner(System.in);
        response = scan.nextLine();
    }

    protected void validateInput()
    {

    }
}
