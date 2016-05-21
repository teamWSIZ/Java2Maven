package mzk;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mareckip on 21.05.16.
 */
public class B {
    public static void main(String[] args) {
        Instant w = Instant.now();
        System.out.println(w);
        String dateTime = DateTimeFormatter.ISO_ZONED_DATE_TIME.format(
                ZonedDateTime.ofInstant(w, ZoneId.systemDefault())
        );

        //todo: wyciągnąć czas z instant; sprawdzić porównanie chwil czasowych
    }
}
