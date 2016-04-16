package Browar;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data
public class MagazynSkladnikow {
    Map<Skladnik,Integer> zapas = new HashMap<>();

    public void dodajSkladnik(String nazwaSkaldnika, Integer ilosc) {
        zapas.put(new Skladnik(nazwaSkaldnika), ilosc);
    }

    public boolean czyMoznaWyprodukowac(Napoj napoj) {
        //trzeba sprawdzic czy jest dosc kazdego ze skladnikow?
        for(Skladnik s : napoj.getSkladniki().keySet()) {
            int ilePotrzeba = napoj.getSkladniki().get(s);
            if (zapas.getOrDefault(s,0)<ilePotrzeba) {
                return false;
            }
        }
        return true;
    }


}
