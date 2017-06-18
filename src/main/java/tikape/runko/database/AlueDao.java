package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.Alue;

/**
 *
 * @author tlinn
 */
public class AlueDao implements Dao<Alue, Integer> {

    private Database database;

    @Override
    public Alue findOne(Integer key) throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alue WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer id = rs.getInt("id");
        String nimi = rs.getString("nimi");
        Integer viestien_lm = rs.getInt("viestien_lm");
        String viimeisin_viesti = rs.getString("viimeisin_viesti");

        Alue a = new Alue(id, nimi, viestien_lm, viimeisin_viesti);

        rs.close();
        stmt.close();
        connection.close();

        return a;
    }

    @Override
    public List<Alue> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alue");

        ResultSet rs = stmt.executeQuery();
        List<Alue> alueet = new ArrayList<>();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String nimi = rs.getString("nimi");
            Integer viestien_lm = rs.getInt("viestien_lm");
            String viimeisin_viesti = rs.getString("viimeisin_viesti");

            alueet.add(new Alue(id, nimi, viestien_lm, viimeisin_viesti));
        }

        rs.close();
        stmt.close();
        connection.close();

        return alueet;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
