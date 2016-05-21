package mzk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementTrasy {
    Integer elementTrasyId;
    Integer liniaId;
    String nazwaTrasy;
    String nazwaPrzystanku;
    Double latitude;
    Double longitude;
    String nazwaLinii;
}

//
//
//{"liniaId":"915","trasaid":"71",
//        "przystanekid":"188",
//        "liniaid":"12",
//        "trasa":"Trasa podstawowa linii 14 w kierunku Cyga\u0144ski Las",
//        "przystanek":"Osiedle Polskich Skrzyde\u0142",
//        "latitude":"",
//        "longitude":"",
//        "linianumer":"14"
//    }
