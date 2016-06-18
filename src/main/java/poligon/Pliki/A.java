package poligon.Pliki;

import java.io.*;

/**
 * Created on 6/18/16 : 6:54 AM.
 */
public class A {
    public static void main(String[] args) throws Exception {
        File fwr = new File("fff.txt");
        if (!fwr.exists()) fwr.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fwr));
        for (int i = 0; i < 10; i++) {
            writer.write("Abra kadabra" + i);
            writer.newLine();
        }
        writer.flush();
        writer.close();
        ///--------- now read

        File frd = new File("fff.txt");
        if (!frd.exists()) return;  //lipa
        BufferedReader reader = new BufferedReader(new FileReader(frd));
        String line;
        while(true) {
            line = reader.readLine();
            if (line==null) break;
            System.out.println("# " + line);
        }
    }
}
