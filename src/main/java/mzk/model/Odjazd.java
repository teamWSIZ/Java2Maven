package mzk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Odjazd {
    Integer przystanekTrasaId;
    Integer typ;
    Integer godzina;
    Integer min;
    String atrybuty;
}

//{"przystanektrasaid":"12",
// "typ":"0","godzina":"9",
// "min":"24",
// "atrybuty":"i"},