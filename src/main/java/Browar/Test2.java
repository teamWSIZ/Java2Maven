package Browar;

/**
 * Created by mareckip on 16.04.16.
 */
public class Test2 {
    public static void main(String[] args) {

        Napoj pepsi = new Napoj("Pepsi");
        pepsi.addSkladnik("Woda", 10);
        pepsi.addSkladnik("Cukier", 4);
        pepsi.addSkladnik("Kofeina", 1);

        Napoj pepsiLight = new Napoj("PepsiLight");
        pepsiLight.addSkladnik("Woda", 10);
        pepsiLight.addSkladnik("Cukier", 4);
        pepsiLight.addSkladnik("Kofeina", 1);

        MagazynSkladnikow sklad = new MagazynSkladnikow();
        sklad.dodajSkladnik("Woda", 1000);
        sklad.dodajSkladnik("Cukier", 1000);
        sklad.dodajSkladnik("Kofeina", 0);

        System.out.println(sklad.czyMoznaWyprodukowac(pepsi));

    }
}
