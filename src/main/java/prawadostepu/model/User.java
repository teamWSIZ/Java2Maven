package prawadostepu.model;

import lombok.Data;

@Data
public class User {
    Integer userid;
    String name;
    @Override
    public String toString() {
        return name + "(" + userid + ")";
    }
}
