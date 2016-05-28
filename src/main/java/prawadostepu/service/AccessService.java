package prawadostepu.service;


import prawadostepu.model.Akcja;
import prawadostepu.model.User;

import java.util.*;

public class AccessService {
    //users
    //actions
    //prawa
    //przypisanie userow do praw
    //tworzenie userow
    //tworzenie akcji
    //zapytanie o prawa userid do akcjaid
    //id's
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Akcja> actions = new HashMap<>();
    private Map<Integer, Set<Integer>> prawaDostepu = new HashMap<>();

    int maxUserId = 0;
    int maxAkcjaId = 0;

    public User createUser(String userName) {
        User u = new User();
        u.setName(userName);
        u.setUserid(maxUserId++);
        users.put(u.getUserid(), u);
        //nadanie pustego zbioru praw dla nowego usera
        prawaDostepu.put(u.getUserid(), new HashSet<>());
        return u;
    }

    public Akcja createAction(String actionName) {
        Akcja a = new Akcja();
        a.setNazwa(actionName);
        a.setAkcjaid(maxAkcjaId++);
        actions.put(a.getAkcjaid(), a);
        return a;
    }

    public void allowAccess(Integer userId, Integer actionId) {
        if (!users.containsKey(userId) || !actions.containsKey(actionId)) return;
        prawaDostepu.get(userId).add(actionId);
    }

    public boolean isAllowed(Integer userId, Integer actionId) {
        if (!users.containsKey(userId) || !actions.containsKey(actionId)) return false;
        return prawaDostepu.get(userId).contains(actionId);
    }

    public Set<Integer> userAllowedActions(Integer userId) {
        return prawaDostepu.get(userId);
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }

}
