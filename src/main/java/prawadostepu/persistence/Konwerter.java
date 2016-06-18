package prawadostepu.persistence;

import prawadostepu.model.Akcja;
import prawadostepu.model.User;

/**
 * Created on 18.06.16, at 11:01
 *
 * Klasa do konwersji między liniami pliku csv, a instancjami klas z pakietu "model"
 *
 */
public class Konwerter {
    public static User stringToUser(String csvLinia) {
        // wchodzi: "4,Xiao,123AB" --> ma wyjść user
        String[] dane = csvLinia.split(",");
        User u = new User();
        u.setUserid(Integer.valueOf(dane[0]));
        u.setName(dane[1]);
        u.setPesel(dane[2]);
        return u;
    }

    public static String userToString(User u) {
        String rezulat = "" + u.getUserid() + "," + u.getName() + "," + u.getPesel();
        return rezulat;
    }
    public static Akcja stringToAkcja(String csvLinia) {
        return null;
    }
    public static String akcjaToString(Akcja akcja) {
        return null;
    }
}
