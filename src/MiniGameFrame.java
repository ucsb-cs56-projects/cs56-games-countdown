import javax.swing.JFrame;

public class MiniGameFrame {

    JFrame mgFrame = new JFrame();

    public MiniGameFrame()
    {
        mgFrame.setTitle("PlaceHolder Title");
        mgFrame.setSize(250, 300);
        mgFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mgFrame.setVisible(true);
    }
}