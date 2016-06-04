package prawadostepu.gui;

import prawadostepu.model.Akcja;
import prawadostepu.model.User;
import prawadostepu.service.AccessService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pm on 5/28/16.
 */
public class PrawaGui {
    public JPanel xxx;
    private JTextArea textArea1;
    private JButton showUsersButton;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton addUserButton;
    private JComboBox actionCombo;
    private JComboBox userCombo;
    private AccessService accessService;

    //Odświeża combo-boxy z danymi
    private void refreshGuiView() {
        actionCombo.removeAllItems();
        for(Akcja a : accessService.getAllActions()) actionCombo.addItem(a);
        userCombo.removeAllItems();
        for(User u : accessService.getAllUsers()) userCombo.addItem(u);
        textField1.setText("");
    }

    public PrawaGui(AccessService accessService) {
        this.accessService = accessService;

        showUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshGuiView();
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!passwordField1.getText().equals("AA")) return;

                User dodany = accessService.createUser(textField1.getText());
                JOptionPane.showMessageDialog(null, "Dodano usera " +
                        dodany.getName() + " (id: " + dodany.getUserid() + ")");
                refreshGuiView();
            }
        });

        refreshGuiView();
    }
}













