import javax.swing.*;

/**
 * Created by mareckip on 16.04.16.
 */
public class Gui {
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JPanel mp;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gui");
        frame.setContentPane(new Gui().mp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
