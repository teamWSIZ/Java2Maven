package Browar;

import lombok.Data;

@Data
public class Skladnik {
    String nazwa;

    public Skladnik(String nazwa) {
        this.nazwa = nazwa;
    }
}
