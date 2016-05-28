package prawadostepu.service;

import prawadostepu.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pm on 5/28/16.
 */
public class TestPraw {
    public static void main(String[] args) {
        //User 1,2,3
        //Akcja 2,4,6,8

        Set<Integer> s = new HashSet<>();
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, Set<Integer>> prawa = new HashMap<>();     //


        s.add(2);
        s.add(4);
        s.add(5);
        System.out.println(s);
        System.out.println(s.contains(3));
        System.out.println(s.contains(5));

        map.put(1, "root");     //klucz -> wartosc
        map.put(2, "tor");
        map.put(3, "prezydent");

        System.out.println(map.get(2));
        System.out.println(map.get(12));

        prawa.put(1, new HashSet<>());
        prawa.get(1).add(1);
        prawa.get(1).add(12);
        prawa.put(2, new HashSet<>());
        prawa.get(2).add(2);
        prawa.get(2).add(3);
        System.out.println(prawa);

        Set<User> pracownicy = new HashSet<>();
        User u1 = new User();
        u1.setName("Alpah");
        u1.setUserid(1);
        pracownicy.add(u1);
        User u2 = new User();
        u2.setName("Norah");
        u2.setUserid(2);
        pracownicy.add(u2);

        System.out.println(pracownicy);
        for(User u : pracownicy) {
            if (u.getUserid().equals(2)) {
                u.setName("Xiao");
            }
        }
        System.out.println(pracownicy);

        Map<Integer, User> kadra = new HashMap<>();
        kadra.put(u1.getUserid(), u1);
        kadra.put(u2.getUserid(), u2);

        System.out.println(kadra.get(2));


    }
}
