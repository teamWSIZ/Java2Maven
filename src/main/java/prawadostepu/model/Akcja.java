package prawadostepu.model;

import lombok.Data;

@Data
public class Akcja {
    Integer akcjaid;
    String nazwa;

    @Override
    public String toString() {
        return nazwa + "(" + akcjaid + ")";
    }
}
