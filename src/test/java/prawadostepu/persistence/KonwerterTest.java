package prawadostepu.persistence;

import org.junit.Test;
import prawadostepu.model.Akcja;
import prawadostepu.model.User;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created on 25.06.16, at 10:58
 */
public class KonwerterTest {


    @Test
    public void shouldKonwertUser() throws Exception {
        User u = new User();
        u.setUserid(3);
        u.setName("AAaa");
        u.setPesel("123AA");

        String zkonwertowany = Konwerter.userToString(u);
        assertThat(zkonwertowany).isEqualTo("3,AAaa,123AA");



        User u2 = Konwerter.stringToUser(Konwerter.userToString(u));
        assertThat(u2).isEqualTo(u);
    }

    @Test
    public void shouldKonwertAkcja() throws Exception {
        Akcja a = new Akcja();
        a.setAkcjaid(1);
        a.setNazwa("XX");
        String poKonwersji = Konwerter.akcjaToString(a);
        assertThat(poKonwersji).isEqualTo("1,XX");
    }

}