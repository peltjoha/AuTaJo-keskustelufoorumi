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
<form method="POST" action="/opiskelijat">
Nimi:<br/>
<input type="text" name="nimi"/><br/>
Osoite:<br/>
<input type="text" name="osoite"/><br/>
<input type="submit" value="Lisää opiskelija"/>
</form>
        }, new ThymeleafTemplateEngine());
        
        // alueen luominen
        post("/alueet", (req, res) -> {
            String nimi = req.queryParams("nimi");

            User user = userDao.findByUsernameAndPassword(username, password);

            if (user == null) {
                res.redirect("/");
                return "";
            }

            req.session(true).attribute("user", user);
            res.redirect("/s/users/" + user.getId());
            return "";
        });
        
        // uuden viestin luominen
        post("/alueet/:id", (req, res) -> {
            String viesti = req.queryParams("viesti");

            User user = userDao.findByUsernameAndPassword(username, password);

            if (user == null) {
                res.redirect("/");
                return "";
            }

            req.session(true).attribute("user", user);
            res.redirect("/s/users/" + user.getId());
            return "";
        });
    }
}
