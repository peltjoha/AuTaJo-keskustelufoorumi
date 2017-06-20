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

        // Dao-oliot tietokantatauluille etc tarvittaessa
        AlueDao alueDao = new AlueDao(database);
        
        // Tekstikäyttöliittymän käynnistys
        
        Scanner lukija = new Scanner(System.in);
        Kayttoliittyma kayttis = new Kayttoliittyma(database, lukija);
        
        kayttis.kaynnista();

        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("viesti", "tervehdys");

            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

        get("/alueet", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alueet", alueDao.findAll());

            return new ModelAndView(map, "alueet");
//                    + "<form method=\"POST\" action=\"/alueet\">\n"
//                    + "Nimi:<br/>\n"
//                    + "<input type=\"text\" name=\"nimi\"/><br/>\n"
//                    + "<input type=\"submit\" value=\"Lisää alue\"/>\n"
//                    + "</form>";
        }, new ThymeleafTemplateEngine());

        get("/alueet/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alue", alueDao.findOne(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "alue");
//                <form method="POST" action="/alueet/:id">
//                Otsikko:<br/>
//                <input type="text" name="otsikko"/><br/>
//                Viesti:<br/>
//                <input type="text" name="viesti"/><br/>
//                Lähettäjä:<br/>
//                <input type="text" name="kayttaja"/><br/>
//                <input type="submit" value="Luo keskustelunavaus"/>
//                </form>;
        }, new ThymeleafTemplateEngine());
        
//        // alueen luominen
//        post("/alueet", (req, res) -> {
//            String nimi = req.queryParams("nimi");
//
//            Alue alue = AlueDao.setNimi(nimi);
//            
//            res.redirect("/");
//
//        });
//        
//        // uuden keskustelunavauksen luominen
//        post("/alueet/:id", (req, res) -> {
//            String otsikko = req.queryParams("otsikko");
//            String viesti = req.queryParams("viesti");
//            String kayttaja = req.queryParams("kayttaja");
//
//            Viestiketju viestiketju = ViestiketjuDao.setOtsikko(otsikko);
//            Viesti viesti = ViestiDao.setViesti(viesti);
//            Kayttaja kayttaja = KayttajaDao.setNimimerkki(kayttaja);
//            
//            res.redirect("/s/alueet/";
//
//        });
    }
}
