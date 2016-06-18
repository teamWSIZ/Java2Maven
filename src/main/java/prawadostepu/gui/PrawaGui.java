package prawadostepu.gui;

import prawadostepu.gui.dialog.AddActionDialog;
import prawadostepu.gui.dialog.AddUserDialog;
import prawadostepu.model.Akcja;
import prawadostepu.model.User;
import prawadostepu.persistence.DataRepository;
import prawadostepu.service.AccessService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

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
    private JButton allowActionButton;
    private JButton addNewActionButton;
    private JButton checkIfSelectedActionButton;
    private JButton printAllowedActionsOfButton;
    private JButton deleteSelectedActionButton;
    private JButton saveUsersToFileButton;
    private AccessService accessService;

    private DataRepository dataRepository;

    //Odświeża combo-boxy z danymi
    private void refreshGuiView() {
        actionCombo.removeAllItems();
        for(Akcja a : accessService.getAllActions()) actionCombo.addItem(a);
        userCombo.removeAllItems();
        for(User u : accessService.getAllUsers()) userCombo.addItem(u);
    }

    //Sprawdza czy hasło wpisane w GUI jest poprawne
    private boolean isPasswordCorrect() {
        if (passwordField1.getText().equals("AA")) return true;
        JOptionPane.showMessageDialog(null, "Wrong password", "Wrong password", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public PrawaGui(AccessService accessService) {
        this.accessService = accessService;
        this.dataRepository = new DataRepository("fileUsers.csv", "fileAkcjas.csv");

        showUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                refreshGuiView();
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!isPasswordCorrect()) return;

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

        allowActionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPasswordCorrect()) return;
                Integer userId = ((User) userCombo.getSelectedItem()).getUserid();
                if (userId==null) return;
                Integer actionId = ((Akcja) actionCombo.getSelectedItem()).getAkcjaid();
                if (actionId==null) return;
                accessService.allowAccess(userId, actionId);
                JOptionPane.showMessageDialog(null, "Dodano akcje id=" +
                        actionId + "  do usera id=" + userId + "!");
            }
        });

        refreshGuiView();


        addNewActionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPasswordCorrect()) return;
                Akcja dodawana = new Akcja();
                AddActionDialog dialog = new AddActionDialog(dodawana);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                if (dodawana.getNazwa()==null) {
                    return; //klient nacisnął cancel
                }
                Akcja dodana = accessService.createAction(dodawana);
                JOptionPane.showMessageDialog(null, "Dodano akcje " +
                        dodana.getNazwa() + " (id: " + dodana.getAkcjaid() + ")");
                refreshGuiView();
            }
        });
        printAllowedActionsOfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                Integer userId = ((User) userCombo.getSelectedItem()).getUserid();
                if (userId==null) return;
                Set<Integer> dozwolone = accessService.getUsersAllowedActions(userId);
                for(Integer actionId : dozwolone) {
                    textArea1.append(accessService.getActionDetails(actionId).getNazwa());
                    textArea1.append("\n");
                }
            }
        });

        deleteSelectedActionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPasswordCorrect()) return;
                Integer actionId = ((Akcja) actionCombo.getSelectedItem()).getAkcjaid();
                if (actionId==null) return;
                accessService.deleteAction(actionId);
                refreshGuiView();
            }
        });
        saveUsersToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataRepository.saveUserData(accessService.getAllUsers());
                JOptionPane.showMessageDialog(null, "Zapis userów OK");
            }
        });
    }
}













