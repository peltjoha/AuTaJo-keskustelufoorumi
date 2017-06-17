package tikape.runko;

import java.util.*;
import tikape.runko.database.*;

public class Kayttoliittyma {

    private Scanner lukija;
    private Database database;

    public Kayttoliittyma(Database database, Scanner lukija) {
        this.lukija = lukija;
        this.database = database;
    }

    public void kaynnista() {

        while (true) {

            System.out.println("Valitse mitä haluat käsitellä:");
            System.out.println("(1) Viestialueet");
            System.out.println("(2) Viestit");
            System.out.println("(3) Käyttäjät");
            System.out.println("(0) Lopeta");
            System.out.print("> ");

            String vastaus = lukija.nextLine();
            
            if (vastaus.equals("0")) {
                break;
            }
            
            // tekstikäyttöliittymän perusrunko, jokaisen valinnan alle 
            // näytä/lisää/poista, SQL-toteutus

        }
    }
