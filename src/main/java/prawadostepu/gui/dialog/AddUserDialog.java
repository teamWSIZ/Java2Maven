package prawadostepu.gui.dialog;

import prawadostepu.model.User;

import javax.swing.*;
import java.awt.event.*;

public class AddUserDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField userName;
    private JTextField pesel;
    private JTextField adres;
    private User doWypelnienia;

    public AddUserDialog(User doWypelnienia) {
        this.doWypelnienia = doWypelnienia; //zapamietujemy referencję, czyli "adres pamięci" gdzie zostawić dane
                                            //nowego użytkownika
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        doWypelnienia.setName(userName.getText());
        doWypelnienia.setPesel(pesel.getText());
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        doWypelnienia.setName(null);
        dispose();
    }

    public static void main(String[] args) {
        AddUserDialog dialog = new AddUserDialog(new User());
        dialog.pack();
        System.out.println("Główny wątek to: " + Thread.currentThread().getName());
        System.out.println("----");
        dialog.setVisible(true);
        System.out.println("Po wszystkim ");
//        System.exit(0);
    }
}
