package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.Viesti;
import tikape.runko.domain.Viestiketju;

/**
 *
 * @author tlinn
 */
public class ViestiketjuDao implements Dao<Viestiketju, Integer> {

    private Database database;
    private ViestiDao viestiDao;

    public ViestiketjuDao(Database database, ViestiDao viestiDao) {
        this.database = database;
        this.viestiDao = viestiDao;
    }

    @Override
    public Viestiketju findOne(Integer key) throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Viestiketju WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer id = rs.getInt("id");
        String otsikko = rs.getString("otsikko");
        String alue = rs.getString("alue");

        List<Viesti> kaikkiViestit = viestiDao.findAll();
        List<Viesti> ketjunViestit = new ArrayList<>();

        for (Viesti v : kaikkiViestit) {

            if (v.getViestiketju() == id) {
                ketjunViestit.add(v);
            }
        }

        Viestiketju vk = new Viestiketju(id, otsikko, alue, ketjunViestit);

        rs.close();
        stmt.close();
        connection.close();

        return vk;
    }

    @Override
    public List<Viestiketju> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Viestiketju");

        ResultSet rs = stmt.executeQuery();
        List<Viestiketju> ketjut = new ArrayList<>();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String otsikko = rs.getString("otsikko");
            String alue = rs.getString("alue");

            List<Viesti> kaikkiViestit = viestiDao.findAll();
            List<Viesti> ketjunViestit = new ArrayList<>();

            for (Viesti v : kaikkiViestit) {

                if (v.getViestiketju() == id) {
                    ketjunViestit.add(v);
                }
            }

            ketjut.add(new Viestiketju(id, otsikko, alue, ketjunViestit));
        }

        rs.close();
        stmt.close();
        connection.close();

        return ketjut;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
