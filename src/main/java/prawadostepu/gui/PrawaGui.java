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
import java.awt.event.KeyEvent;
import java.util.Set;



class MenuString {

    public static String MENU_ADMIN = "Admin";
    public static String MENU_ADMIN_SAVE = "Open";
    public static String MENU_ADMIN_LOAD = "Save";
    public static String MENU_EXIT = "Exit";

    public static String MENU_USERS = "User";
    public static String MENU_USERS_NEW = "Create new user";
    public static String MENU_USERS_SHOWACTIONS = "Show allowed actions";

    public static String MENU_ACTIONS = "Action";
    public static String MENU_ACTIONS_NEW = "Create new action";
    public static String MENU_ACTIONS_SHOWUSERS = "Show users for this actions";
}




public class PrawaGui implements ActionListener {
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

    private JFrame okno;    //glowne okno aplikacji
    private AccessService accessService;    //serwis zapamietujący wszystkie dane
    private DataRepository dataRepository;  //operacje zapisu/odczytu praw na/z dysku

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

    public PrawaGui(AccessService accessService, JFrame frame) {
        this.accessService = accessService;
        this.dataRepository = new DataRepository("fileUsers.csv", "fileAkcjas.csv", "allowedAkcjas.csv");
        this.okno = frame;

        this.createMenu();
        System.out.println("cstr");



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
                dataRepository.saveAkcjaData(accessService.getAllActions());
                JOptionPane.showMessageDialog(null, "Dane zostały zapisane");
            }
        });
    }


    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu(MenuString.MENU_ACTIONS);
        JMenuItem item1_1 = new JMenuItem(MenuString.MENU_ADMIN_LOAD);
        JMenuItem item1_2 = new JMenuItem(MenuString.MENU_ADMIN_SAVE);
        JMenuItem item1_3 = new JMenuItem(MenuString.MENU_EXIT);
        item1_1.addActionListener(this);
        item1_2.addActionListener(this);
        item1_3.addActionListener(this);
        menu1.add(item1_1);
        menu1.add(item1_2);
        menu1.add(item1_3);

        JMenu menu2 = new JMenu(MenuString.MENU_USERS);
        JMenuItem item2_1 = new JMenuItem(MenuString.MENU_ADMIN_LOAD);
        JMenuItem item2_2 = new JMenuItem(MenuString.MENU_ADMIN_SAVE);
        item2_1.addActionListener(this);
        item2_2.addActionListener(this);
        menu2.add(item2_1);
        menu2.add(item2_2);

        JMenu menu3 = new JMenu(MenuString.MENU_ACTIONS);
        JMenuItem item3_1 = new JMenuItem(MenuString.MENU_ADMIN_LOAD);
        JMenuItem item3_2 = new JMenuItem(MenuString.MENU_ADMIN_SAVE);
        item3_1.addActionListener(this);
        item3_2.addActionListener(this);
        menu3.add(item3_1);
        menu3.add(item3_2);


        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        okno.setJMenuBar(menuBar);
    }


    /**
     * Centralne miejsce zarządzania zdarzeniami
     */

    //@Controller
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String zdarzenie = actionEvent.getActionCommand();
        //todo: obsłużyć zdarzenia z menu; przełączyć akcje z buttonów do centralnego rzarządzania tutaj
        System.out.println("Wybrano --> " + zdarzenie);


    }
}













