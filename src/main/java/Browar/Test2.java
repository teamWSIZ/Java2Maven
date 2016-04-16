package Browar;

/**
 * Created by mareckip on 16.04.16.
 */
public class Test2 {
    public static void main(String[] args) {

        Napoj pepsi = new Napoj("Pepsi");
        pepsi.addSkladnik(new Skladnik("Woda"), 10);
        pepsi.addSkladnik(new Skladnik("Cukier"), 4);
        pepsi.addSkladnik(new Skladnik("Kofeina"), 1);

        Napoj pepsiLight = new Napoj("PepsiLight");
        pepsi.addSkladnik(new Skladnik("Woda"), 10);
        pepsi.addSkladnik(new Skladnik("Cukier"), 3);
        pepsi.addSkladnik(new Skladnik("Kofeina"), 2);





    }
}
