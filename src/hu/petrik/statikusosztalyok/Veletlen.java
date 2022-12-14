package hu.petrik.statikusosztalyok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {
    private Veletlen() {
    }

    private static final Random rnd = new Random();
    private static List<String> vezNevek = feltolt("files/veznev.txt");
    private static List<String> ferfiKerNevek = feltolt("files/ferfikernev.txt");
    private static List<String> noiKerNevek = feltolt("files/noikernev.txt");

    private static List<String> sportagak = feltolt("files/sportag.txt");
    private static List<String> sportegyesuletek = feltolt("files/egyesulet.txt");

    private static List<String> feltolt(String fajlnev) {
        List<String> lista = new ArrayList<>();
        try {
            Scanner file = null;

            file = new Scanner(new File(fajlnev));

            while (file.hasNext()) {
                String sor = file.nextLine();
                lista.add(sor);
            }

            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;

    }


    public static int velEgesz(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    public static char velKarakter(char min, char max) {
        return (char) velEgesz(min, max);
    }

    public static String velVezetekNev() {

        return vezNevek.get(rnd.nextInt(vezNevek.size()));

    }


    public static String velKeresztNev(boolean nem) {
        String keresztNev;
        if (nem) {
            keresztNev = velFerfiKeresztNev();
        } else {
            keresztNev = velNoiiKeresztNev();
        }
        return keresztNev;
    }

    private static String velFerfiKeresztNev() {

        return ferfiKerNevek.get(rnd.nextInt(ferfiKerNevek.size()));
    }

    private static String velNoiiKeresztNev() {
        return noiKerNevek.get(rnd.nextInt(noiKerNevek.size()));
    }

    public static String velTeljesNev(boolean nem) {
        return velVezetekNev() + " " + velKeresztNev(nem);
    }

    public static String velDatum(int ev1, int ev2) {
        int ev = Veletlen.velEgesz(ev1, ev2);
        int honap = Veletlen.velEgesz(1, 12);
        int nap = Veletlen.velEgesz(1, 31);
        return ev + "-" + honap + "-" + nap;
    }

    public static String velMobil() {


        int a = Veletlen.velEgesz(100, 999);
        int b = Veletlen.velEgesz(11, 99);
        int c = Veletlen.velEgesz(11, 99);
        return "+36 (30) " + a + "-" + b + "-" + c;
    }

    public static String velSportag() {
        return sportagak.get(rnd.nextInt(sportagak.size()));
    }

    public static String velSporegyesulet() {
        return sportegyesuletek.get(rnd.nextInt(sportegyesuletek.size()));
    }
}
