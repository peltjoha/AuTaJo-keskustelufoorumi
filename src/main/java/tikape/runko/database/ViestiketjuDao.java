package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.Viestiketju;

/**
 *
 * @author tlinn
 */
public class ViestiketjuDao implements Dao<Viestiketju, Integer> {

    private Database database;

    @Override
    public Viestiketju findOne(Integer key) throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alue WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer id = rs.getInt("id");
        String otsikko = rs.getString("otsikko");
        String alue = rs.getString("alue");

        Viestiketju vk = new Viestiketju(id, otsikko, alue);

        rs.close();
        stmt.close();
        connection.close();

        return vk;
    }

    @Override
    public List<Viestiketju> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Alue");

        ResultSet rs = stmt.executeQuery();
        List<Viestiketju> ketjut = new ArrayList<>();

        while (rs.next()) {

            Integer id = rs.getInt("id");
            String otsikko = rs.getString("otsikko");
            String alue = rs.getString("alue");

            ketjut.add(new Viestiketju(id, otsikko, alue));
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
