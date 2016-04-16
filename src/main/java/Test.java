import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {


        //mapy w Javie:
        // {klucz} --> {wartość}
        // {key} --> {value}
        Map<String, Integer> mapa = new HashMap<>();

        mapa.put("Woda", 10);
        mapa.put("Woda", 15);
        mapa.put("Cukier", 7);

        //sprwadzenie ile wody?
        System.out.println(mapa.get("Woda"));

        System.out.println(mapa.keySet());
        System.out.println(mapa.values());

        for(String klucz : mapa.keySet()) {
            System.out.println("klucz: " + klucz + " wartosc:" + mapa.get(klucz));
        }

        System.out.println(mapa.containsKey("Alkohol"));
        System.out.println(mapa.containsKey("Cukier"));

        int ileAloholu = mapa.getOrDefault("Alkohol",0);
        System.out.println(ileAloholu);


    }
}
