package poligon.AppMenu;

import javax.swing.*;

/**
 * Created on 6/18/16 : 8:16 AM.
 */
public class TestGuiStart {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TestGui");
        frame.setContentPane(new TestGui(frame).getMp());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
