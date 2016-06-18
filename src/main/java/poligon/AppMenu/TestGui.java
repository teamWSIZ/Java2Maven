package poligon.AppMenu;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created on 6/18/16 : 8:14 AM.
 */


/**
 * Wylistowane wszystkie akcje dostępne w aplikacji.
 * W części z @Controller będziemy sprawdzali która to była...
 */
class Zdarzenia {
    public static String MENU_FILE_OPEN = "Open";
    public static String MENU_FILE_SAVE = "Save";
    public static String MENU_EXIT = "Exit";

}

public class TestGui implements ActionListener {
    //Komponenty GUI
    private JPanel mp;
    private JTextField textField1;
    private JButton alphaButton;
    private JButton betaButton;
    private JButton gammaButton;

    //Nasze dodatki
    private JFrame frejm;


    public TestGui(JFrame ramka) {
        frejm = ramka;
        textField1.setText("Abra kadabra");

        //Układanie menu (JMenuBar->JMenu->JMenuItem);
        //Nasłuchiwacze zapięte do JMenuItem
        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("Menu1");
        JMenuItem item1_1 = new JMenuItem(Zdarzenia.MENU_FILE_OPEN);
        JMenuItem item1_2 = new JMenuItem(Zdarzenia.MENU_FILE_SAVE);
        JMenuItem item1_3 = new JMenuItem(Zdarzenia.MENU_EXIT);
        item1_1.addActionListener(this);
        item1_2.addActionListener(this);
        item1_3.addActionListener(this);
        item1_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.SHIFT_MASK + ActionEvent.CTRL_MASK));
        item1_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        menu1.add(item1_1);
        menu1.add(item1_2);
        menu1.add(item1_3);


        menuBar.add(menu1);
        frejm.setJMenuBar(menuBar);     //zapięcie menu do ramki aplikacji

        //////// menu jest gotowe

        //Podpięcie nazw i centralnych zdarzeń pod inne komponenty
        alphaButton.setText(Zdarzenia.MENU_FILE_OPEN);
        alphaButton.addActionListener(this);




    }

    /**
     * Centralne miejsce zarządzania zdarzeniami
     */

    //@Controller
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String zdarzenie = actionEvent.getActionCommand();
        if (zdarzenie.equals(Zdarzenia.MENU_FILE_OPEN)) {
            System.out.println("Opening file...");
        }
        else if (zdarzenie.equals(Zdarzenia.MENU_FILE_SAVE)) {
            System.out.println("zapisuje...");
        }
        else if (zdarzenie.equals(Zdarzenia.MENU_EXIT)) {
            System.exit(0);
        } else {
            System.out.println("---> " + zdarzenie);
        }


    }

    public JPanel getMp() {
        return mp;
    }
}
