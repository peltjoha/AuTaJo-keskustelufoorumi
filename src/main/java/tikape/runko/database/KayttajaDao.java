/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.Kayttaja;
import tikape.runko.domain.Viesti;

public class KayttajaDao implements Dao<Kayttaja, Integer> {

    private Database database;
    private ViestiDao viestiDao;

    public KayttajaDao(Database database, ViestiDao viestiDao) {
        this.database = database;
        this.viestiDao = viestiDao;
    }

    @Override
    public Kayttaja findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Kayttaja WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer id = rs.getInt("id");
        String nimimerkki = rs.getString("nimimerkki");

        List<Viesti> kaikkiViestit = viestiDao.findAll();
        List<Viesti> kayttajanViestit = new ArrayList<>();

        for (Viesti v : kaikkiViestit) {

            if (v.getKayttaja() == id) {
                kayttajanViestit.add(v);
            }
        }

        Kayttaja k = new Kayttaja(id, nimimerkki, kayttajanViestit);

        rs.close();
        stmt.close();
        connection.close();

        return k;
    }

    @Override
    public List<Kayttaja> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Kayttaja");

        ResultSet rs = stmt.executeQuery();
        List<Kayttaja> kayttajat = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String nimimerkki = rs.getString("nimimerkki");

            List<Viesti> kaikkiViestit = viestiDao.findAll();
            List<Viesti> kayttajanViestit = new ArrayList<>();

            for (Viesti v : kaikkiViestit) {

                if (v.getKayttaja() == id) {
                    kayttajanViestit.add(v);
                }
            }

            kayttajat.add(new Kayttaja(id, nimimerkki, kayttajanViestit));
        }

        rs.close();
        stmt.close();
        connection.close();

        return kayttajat;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }
}
