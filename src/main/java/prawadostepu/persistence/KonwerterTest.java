package prawadostepu.persistence;

import prawadostepu.model.User;

/**
 * Created on 18.06.16, at 11:23
 */
public class KonwerterTest {
    public static void main(String[] args) {
        User u = new User();
        u.setUserid(3);
        u.setName("AAaa");
        u.setPesel("123AA");
        String zkonwertowany = Konwerter.userToString(u);
        if (!zkonwertowany.equals("3,AAaa,123AA")) {
            throw new RuntimeException("Zła konwersja");
        }
        User u2 = Konwerter.stringToUser(Konwerter.userToString(u));
        if (!u2.equals(u)) {
            System.out.println(u2);
            throw new RuntimeException("Zła konwersja");
        }


    }
}
