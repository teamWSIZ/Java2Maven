package Browar;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MagazynNapojow {
    Map<Skladnik,Integer> zapas = new HashMap<>();
}
