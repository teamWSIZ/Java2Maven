package Browar;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Ile ktorych skladnikow dany typ napoju wymaga...
 */

@Data
public class Napoj {
    String nazwa;

    //ilosci skladnikow, czyli dla kazdego mozliwego skladnika ile go potrzeba...
    Map<Skladnik, Integer> skladniki = new HashMap<>();

    //to jest konstruktor; tylko podajac nazwe mozna tworzyc instancje napojow
    public Napoj(String nazwa) {
        this.nazwa = nazwa;
    }

    public void addSkladnik(String nazwaSkladnika, Integer ilosc) {
        skladniki.put(new Skladnik(nazwaSkladnika), ilosc);
    }
}
