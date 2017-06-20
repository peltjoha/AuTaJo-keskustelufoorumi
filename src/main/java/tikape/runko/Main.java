package tikape.runko;

import java.util.Scanner;
import java.util.HashMap;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import tikape.runko.database.Database;
import tikape.runko.database.KayttajaDao;
import tikape.runko.database.ViestiDao;
import tikape.runko.database.AlueDao;
import tikape.runko.database.ViestiketjuDao;

public class Main {

    public static void main(String[] args) throws Exception {
        Database database = new Database("jdbc:sqlite:autajo.db");
        database.init();

        // Tekstikäyttöliittymän käynnistys
        
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma kayttis = new Kayttoliittyma(database, lukija);
        
        kayttis.kaynnista();
        
        ViestiDao viestiDao = new ViestiDao(database);
        ViestiketjuDao viestiketjuDao = new ViestiketjuDao(database, viestiDao);
        AlueDao alueDao = new AlueDao(database, viestiketjuDao);

        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("viesti", "tervehdys");

            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

        get("/alueet", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alueet", alueDao.findAll());

            return new ModelAndView(map, "alueet");
        }, new ThymeleafTemplateEngine());

        get("/alueet/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alue", alueDao.findOne(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "alue");
        }, new ThymeleafTemplateEngine());
    }
}
