package prawadostepu.model;

import lombok.Data;

@Data
public class User {
    Integer userid;
    String name;
    String pesel;
    @Override
    public String toString() {
        return name + "(id: " + userid + ", pesel:" + pesel + ")";
    }
}
