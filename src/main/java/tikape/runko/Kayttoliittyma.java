package tikape.runko;

import java.sql.SQLException;
import java.util.*;
import tikape.runko.database.*;
import tikape.runko.domain.*;

public class Kayttoliittyma {

    private Scanner lukija;
    private Database database;
    private ViestiDao viestiDao;
    private ViestiketjuDao viestiketjuDao;
    private AlueDao alueDao;
    private KayttajaDao kayttajaDao;

    public Kayttoliittyma(Database database, Scanner lukija) {
        this.lukija = lukija;
        this.database = database;
        this.viestiDao = new ViestiDao(this.database);
        this.viestiketjuDao = new ViestiketjuDao(database, viestiDao);
        this.alueDao = new AlueDao(database, viestiketjuDao);
        this.kayttajaDao = new KayttajaDao(database, viestiDao);
    }

    public void kaynnista() throws SQLException {
        
        while (true) {

            System.out.println("Valitse mitä haluat käsitellä:");
            System.out.println("(1) Alueet");
            System.out.println("(2) Viestiketjut");
            System.out.println("(3) Viestit");
            System.out.println("(4) Käyttäjät");
            System.out.println("(0) Lopeta");
            System.out.print("> ");

            String vastaus = lukija.nextLine();

            if (vastaus.equals("0")) {
                break;
            }
            if (vastaus.equals("1")) {
                alueet();
            }
            if (vastaus.equals("2")) {
                viestiketjut();
            }
            if (vastaus.equals("3")) {
                viestit();
            }
            if (vastaus.equals("4")) {
                kayttajat();
            }

            // tekstikäyttöliittymän perusrunko, jokaisen valinnan alle 
            // näytä/lisää/poista, SQL-toteutus
        }
    }

    private void alueet() throws SQLException {

        while (true) {
            System.out.println("");
            System.out.println("Alueet:");
            System.out.println("(1) Listaa alueet");
            System.out.println("(0) Poistu");
            System.out.print("> ");

            String vastaus = lukija.nextLine();

            if (vastaus.equals("0")) {
                break;
            }
            if (vastaus.equals("1")) {
                
                List<Alue> alueet = alueDao.findAll();
                
                for (Alue alue : alueet) {
                    System.out.println(alue);
                }
            }
        }
    }

    private void viestiketjut() {

        while (true) {
            System.out.println("Viestiketjut:");
            System.out.println("(1) Listaa viestiketjut");
            System.out.println("(0) Poistu");
            System.out.println("> ");

            String vastaus = lukija.nextLine();

            if (vastaus.equals("0")) {
                break;
            }
            if (vastaus.equals("1")) {

                // hae ja tulosta näytölle viestiketjut tietokannasta
            }
        }
    }

    private void viestit() {

        while (true) {
            System.out.println("Viestit:");
            System.out.println("(1) Listaa viestit");
            System.out.println("(0) Poistu");
            System.out.println("> ");

            String vastaus = lukija.nextLine();

            if (vastaus.equals("0")) {
                break;
            }

            if (vastaus.equals("1")) {

                // hae ja tulosta kaikki viestit tietokannasta 
            }
        }
    }

    private void kayttajat() {

        while (true) {
            System.out.println("Käyttäjät:");
            System.out.println("(1) Listaa käyttäjät");
            System.out.println("(0) Poistu");
            System.out.println("> ");

            String vastaus = lukija.nextLine();

            if (vastaus.equals("0")) {
                break;
            }

            if (vastaus.equals("1")) {

                // hae ja tulosta kaikki käyttäjät tietokannasta 
            }
        }
    }

}
