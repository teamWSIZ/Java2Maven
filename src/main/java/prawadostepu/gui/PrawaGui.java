package prawadostepu.gui;

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
    private AccessService accessService;

    public PrawaGui(AccessService accessService) {
        this.accessService = accessService;
        showUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.append(accessService.getAllUsers().toString());
            }
        });
    }
}
