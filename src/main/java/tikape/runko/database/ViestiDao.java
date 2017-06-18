package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.Viesti;

/**
 *
 * @author tlinn
 */
public class ViestiDao implements Dao<Viesti, Integer> {

    private Database database;

    @Override
    public Viesti findOne(Integer key) throws SQLException {

        // Tarvitsemmeko oman id:n viesteille, jotta findOne-metodin saa implementoitua?
        // Alla oleva siis sen osalta väärin.
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Viesti WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        String viesti = rs.getString("viesti");
        String timestamp = rs.getString("timestamp");
        String kayttaja = rs.getString("kayttaja");
        String viestiketju = rs.getString("viestiketju");

        Viesti v = new Viesti(viesti, timestamp, kayttaja, viestiketju);

        rs.close();
        stmt.close();
        connection.close();

        return v;
    }

    @Override
    public List<Viesti> findAll() throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Viesti");

        ResultSet rs = stmt.executeQuery();
        List<Viesti> viestit = new ArrayList<>();
        
        while (rs.next()) {
            
            String viesti = rs.getString("viesti");
            String timestamp = rs.getString("timestamp");
            String kayttaja = rs.getString("kayttaja");
            String viestiketju = rs.getString("viestiketju");

            viestit.add(new Viesti(viesti, timestamp, kayttaja, viestiketju));
        }

        rs.close();
        stmt.close();
        connection.close();

        return viestit;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
