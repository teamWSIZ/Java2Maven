package mzk;

import mzk.model.Linia;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mareckip on 21.05.16.
 */
public class A {
    public static void main(String[] args) {
        Linia numer8 = new Linia();

        numer8.setKierunek("Dworzec");
        numer8.setLiniaId(11);
        numer8.setNazwaLinii("53a");
        System.out.println(numer8);
        Linia l20 = new Linia(1, "20", "Beskidzkie");

        List<Linia> linieBB = new ArrayList<>();
//        linieBB.add(numer8);
//        linieBB.add(l20);

        Map<Integer, Linia> linieBbNowe = new HashMap<>();


        long st = System.currentTimeMillis();

        int nLini = 100000;
        for (int i = 0; i < nLini; i++) {
            Linia nowa = new Linia(i+100,String.valueOf(i), "Kierunek-" + i);
            linieBB.add(nowa);
//            linieBbNowe.put(nowa.getLiniaId(), nowa);
        }

        long en = System.currentTimeMillis();
        System.out.println("Tworzenie linii trawło " + (en-st) + "[ms]");

        //jak znaleźć linie o Linia.liniaId = 115 ??
        st = System.currentTimeMillis();
        for(Linia l : linieBB) {
            if (l.getLiniaId().equals(115)) {
                System.out.println("Linia 115 to: " + l);
            }
        }
//        System.out.println(linieBbNowe.get(115));
        en = System.currentTimeMillis();
        System.out.println("Szukanie linii trawło " + (en-st) + "[ms]");


//        System.out.println(linieBB);


        Instant w = Instant.now();
        System.out.println(w);

    }


}
