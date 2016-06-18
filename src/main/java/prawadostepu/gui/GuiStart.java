package prawadostepu.gui;

import prawadostepu.model.Akcja;
import prawadostepu.model.User;
import prawadostepu.service.AccessService;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * Created by pm on 5/28/16.
 */
public class GuiStart {

    public static AccessService createOurService() {
        AccessService serwis = new AccessService();
        User u1 = serwis.createUser("Alpha");
        User u2 = serwis.createUser("Beta");
        System.out.println(serwis.getUsersAllowedActions(u1.getUserid()));
        Akcja a1 = serwis.createAction("GET");
        Akcja a2 = serwis.createAction("DELETE");
        serwis.allowAccess(u1.getUserid(), a1.getAkcjaid());
        serwis.allowAccess(u1.getUserid(), a2.getAkcjaid());
        return serwis;
    }

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Nie będzie nimbusa :(");
        }
        JFrame frame = new JFrame("PrawaGui");
        frame.setContentPane(new PrawaGui(createOurService()).xxx);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
