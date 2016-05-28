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

    private void refresh() {
        actionCombo.removeAllItems();
        for(Akcja a : accessService.getAllActions()) actionCombo.addItem(a);
        userCombo.removeAllItems();
        for(User u : accessService.getAllUsers()) userCombo.addItem(u);
    }

    public PrawaGui(AccessService accessService) {
        this.accessService = accessService;

        showUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refresh();
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!passwordField1.getText().equals("AA")) return;
                accessService.createUser(textField1.getText());
                refresh();
            }
        });

        refresh();
    }
}
