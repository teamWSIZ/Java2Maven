package mzk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Linia {
    Integer id;     //id linii (osobny dla kazdego kierunku linii)
    String numerLinii;   //numerLinii linii jak na autobusie pisze
    String kierunek;    //ostatni przystanej na linii w tym kierunku

}
