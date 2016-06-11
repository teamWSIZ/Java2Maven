package prawadostepu.service;

import prawadostepu.model.Akcja;
import prawadostepu.model.User;

/**
 * Created by pm on 5/28/16.
 */
public class TestAccessService {
    public static void main(String[] args) {
        AccessService serwis = new AccessService();

        User u1 = serwis.createUser("Alpha");
        User u2 = serwis.createUser("Beta");
        System.out.println(serwis.getUsersAllowedActions(u1.getUserid()));

        Akcja a1 = serwis.createAction("GET");
        Akcja a2 = serwis.createAction("DELETE");
        serwis.allowAccess(u1.getUserid(), a1.getAkcjaid());
        serwis.allowAccess(u1.getUserid(), a2.getAkcjaid());
        System.out.println(serwis.getUsersAllowedActions(u1.getUserid()));
        System.out.println(serwis.getUsersAllowedActions(u2.getUserid()));

        System.out.println(serwis.isAllowed(u1.getUserid(), a2.getAkcjaid()));
        System.out.println(serwis.isAllowed(u2.getUserid(), a2.getAkcjaid()));

        System.out.println(serwis.getAllUsers());

    }
}
