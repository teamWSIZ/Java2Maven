package mzk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Linia {
    Integer liniaId;     //liniaId linii (osobny dla kazdego kierunku linii)
    String nazwaLinii;   //nazwaLinii linii jak na autobusie pisze
    String kierunek;    //ostatni przystanej na linii w tym kierunku

}
