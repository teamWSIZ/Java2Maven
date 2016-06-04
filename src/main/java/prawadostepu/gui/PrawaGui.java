package prawadostepu.gui;

import prawadostepu.gui.dialog.AddUserDialog;
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
                textArea1.setText("Obecny wątek to : " + Thread.currentThread().getName());
                if (!passwordField1.getText().equals("AA")) return;

                User dodawany = new User();
                AddUserDialog dialog = new AddUserDialog(dodawany);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);    //czeka na akcje użytkownika
                if (dodawany.getName()==null) {
                    //nastąpił cancel
                    System.out.println("Był cancel");
                    return;
                }

                User dodany = accessService.createUser(dodawany);
                JOptionPane.showMessageDialog(null, "Dodano usera " +
                        dodany.getName() + " (id: " + dodany.getUserid() + ")");
                refreshGuiView();
            }
        });

        refreshGuiView();
    }
}













