package prawadostepu.persistence;

import prawadostepu.model.Akcja;
import prawadostepu.model.User;

import java.io.*;
import java.util.*;

/**
 * Created on 18.06.16, at 11:01
 *
 * Udostępnia możliwość zapisu i odczytu danych z pliku
 *
 * todo: lepsza filtracja i raportowanie błędów odczytu/konwersji
 */
public class DataRepository {
    String userFileName;
    String akcjaFileName;
    String allowedActionsFileName;

    public DataRepository(String userFileName, String akcjaFileName, String allowedActionsFileName) {
        this.userFileName = userFileName;
        this.akcjaFileName = akcjaFileName;
        this.allowedActionsFileName = allowedActionsFileName;
    }

    public void saveUserData(Collection<User> doZapisania) {
        try {
            File fwr = new File(userFileName);
            if (!fwr.exists()) fwr.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fwr));
            for (User u : doZapisania) {
                writer.write(Konwerter.userToString(u));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException("Błąd zapisu");
        }
    }

    public void saveAkcjaData(Collection<Akcja> doZapisania) {
        try {
            File fwr = new File(akcjaFileName);
            if (!fwr.exists()) fwr.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fwr));
            for (Akcja a : doZapisania) {
                writer.write(Konwerter.akcjaToString(a));
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException("Błąd zapisu");
        }
    }

    public void saveAllowedActions(Map<Integer, Set<Integer>> dane) {
        try {
            File fwr = new File(akcjaFileName);
            if (!fwr.exists()) fwr.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fwr));

            for(Integer userid : dane.keySet()) {

            }
//
//            for (Akcja a : doZapisania) {
//                writer.write(Konwerter.akcjaToString(a));
//                writer.newLine();
//            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException("Błąd zapisu");
        }
    }

    public List<User> loadUserData() {
        List<User> wynik = new ArrayList<>();

        File frd = new File(userFileName);
        if (!frd.exists()) return null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(frd));
            String line;
            while(true) {
                line = reader.readLine();
                if (line==null) break;
                System.out.println("# " + line);
                wynik.add(Konwerter.stringToUser(line));
            }
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException("Błąd odczytu pliku");
        }
        return wynik;
    }

    public void saveAkcjaData(List<Akcja> doZapisania) {

    }


    public List<Akcja>  loadAkcjaData() {
        return null;
    }

}
