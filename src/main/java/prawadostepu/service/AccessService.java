package prawadostepu.service;


import lombok.extern.slf4j.Slf4j;
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

    //Tworzenie usera o zadanej nazwie
    public User createUser(String userName) {
        User u = new User();
        u.setName(userName);
        u.setUserid(maxUserId++);
        users.put(u.getUserid(), u);
        //nadanie pustego zbioru praw dla nowego usera
        prawaDostepu.put(u.getUserid(), new HashSet<>());
        return u;
    }

    //Tworzenie userów na podstawie niepełnej klasy User (z dialogu, bez id)
    public User createUser(User newbie) {
        newbie.setUserid(maxUserId++);
        users.put(newbie.getUserid(), newbie);
        prawaDostepu.put(newbie.getUserid(), new HashSet<>());
        return newbie;
    }

    //Tworzenie akcji o zadanej nazwie
    public Akcja createAction(String actionName) {
        Akcja a = new Akcja();
        a.setNazwa(actionName);
        a.setAkcjaid(maxAkcjaId++);
        actions.put(a.getAkcjaid(), a);
        return a;
    }

    //Tworzenie akcji na podstwie niepełnej klasy Akcja (z dialogu, bez id)
    public Akcja createAction(Akcja dodawana) {
        dodawana.setAkcjaid(maxAkcjaId++);
        actions.put(dodawana.getAkcjaid(), dodawana);
        return dodawana;
    }

    //Pozwala na wykonywanie akcji `actionId` przez usera `userId`
    public void allowAccess(Integer userId, Integer actionId) {
        if (!users.containsKey(userId) || !actions.containsKey(actionId)) return;
        prawaDostepu.get(userId).add(actionId);
    }

    //Sprawdzenie zezwolenia na wykonanie akcji actionId przez usera userId
    public boolean isAllowed(Integer userId, Integer actionId) {
        if (!users.containsKey(userId) || !actions.containsKey(actionId)) return false;
        return prawaDostepu.get(userId).contains(actionId);
    }

    //Wszystkie actionId dozwolone dla usera userId
    public Set<Integer> getUsersAllowedActions(Integer userId) {
        return prawaDostepu.get(userId);
    }

    public void deleteAction(Integer actionId) {
        for(Integer u : prawaDostepu.keySet()) {
            prawaDostepu.get(u).remove(actionId);
            System.out.println(prawaDostepu.get(u));
        }
        actions.remove(actionId);
    }

    //Wszyscy userzy
    public Collection<User> getAllUsers() {
        return users.values();
    }

    //Wszystkie akcje
    public Collection<Akcja> getAllActions() {
        return actions.values();
    }

    public Akcja getActionDetails(Integer actionId) {
        return actions.get(actionId);
    }

}
