import javax.swing.JFrame;

public class GameFrame
{
    public static void main(String[] args)
    {

        MainGameFrame frame = new MainGameFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(350, 400);
    }
}