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

    //Baza Danych
    private Map<Integer, User> users = new HashMap<>(); //tabela userów
    private Map<Integer, Akcja> actions = new HashMap<>();  //tabela akcji
    private Map<Integer, Set<Integer>> prawaDostepu = new HashMap<>();  //tabela przypisań (userid->{akcja1id, akcja2id})
    //koniec bazy


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

    public User createUser(User newbie) {
        newbie.setUserid(maxUserId++);
        users.put(newbie.getUserid(), newbie);
        prawaDostepu.put(newbie.getUserid(), new HashSet<>());
        return newbie;
    }

    public Akcja createAction(String actionName) {
        Akcja a = new Akcja();
        a.setNazwa(actionName);
        a.setAkcjaid(maxAkcjaId++);
        actions.put(a.getAkcjaid(), a);
        return a;
    }

    //Pozwala na wykonywanie akcji `actionId` przez usera `userId`
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

    public Collection<Akcja> getAllActions() {
        return actions.values();
    }

}
