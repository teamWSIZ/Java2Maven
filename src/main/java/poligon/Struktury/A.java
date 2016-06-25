package poligon.Struktury;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on 25.06.16, at 11:14
 */
public class A {
    public static void main(String[] args) {

        Set<Integer> s =new HashSet<>();
        s.add(1);
        s.add(15);
        s.add(3);
        s.add(3);
        s.add(3);
        s.add(-1);
        System.out.println(s);

        Map<Integer, String> m = new HashMap<>();
        m.put(1, "Xiao");
        m.put(2, "Wu");
        m.put(14, "Xi");
        System.out.println(m.keySet());
        System.out.println(m.values());
        for(Integer k : m.keySet()) {
            System.out.println("klucz: " + k + " wartosc: " + m.get(k));
        }

        Map<Integer, Set<Integer>> dane = new HashMap<>();
        dane.put(1, new HashSet<>());
        dane.get(1).add(3);
        dane.get(1).add(4);
        dane.get(1).add(8);

        dane.put(5, new HashSet<>());
        dane.get(5).add(3);
        dane.get(5).add(8);

        System.out.println(dane.keySet());
        for(Integer k : dane.keySet()) {
            System.out.println("klucz: " + k + " wartosc: " + dane.get(k));
        }



    }
}
