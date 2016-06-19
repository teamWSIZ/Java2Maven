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

    public static String MENU_EDIT_UNDO = "Undo";
    public static String MENU_EDIT_REDO = "Redo";
    public static String MENU_EDIT_COPY = "Copy";
    public static String MENU_EDIT_PASTE = "Paste";
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

        JMenu menu1 = new JMenu("File");
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

        JMenu menu2 = new JMenu("Edit");
        JMenuItem item2_1 = new JMenuItem(Zdarzenia.MENU_EDIT_UNDO);
        JMenuItem item2_2 = new JMenuItem(Zdarzenia.MENU_EDIT_REDO);
        JMenuItem item2_3 = new JMenuItem(Zdarzenia.MENU_EDIT_COPY);
        JMenuItem item2_4 = new JMenuItem(Zdarzenia.MENU_EDIT_PASTE);
        item2_1.addActionListener(this);
        item2_2.addActionListener(this);
        item2_3.addActionListener(this);
        item2_4.addActionListener(this);

        item2_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        item2_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
        item2_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        item2_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        menu2.add(item2_1);
        menu2.add(item2_2);
        menu2.add(item2_3);
        menu2.add(item2_4);

        //tworzenie submenu
        JMenu aa = new JMenu("asasa");
        JMenuItem a1 = new JMenuItem("a1");
        JMenuItem a2 = new JMenuItem("a2");
        JMenuItem a3 = new JMenuItem("a3");
        aa.add(a1);
        aa.add(a2);
        aa.add(a3);
        menu2.add(aa);


        menuBar.add(menu1);
        menuBar.add(menu2);
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
