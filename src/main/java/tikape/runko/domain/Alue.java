/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.domain;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jipel
 */
public class Alue {
    
    private Integer id;
    private String nimi;
    private Integer viestien_lm;
    private String viimeisin_viesti;

    public Alue(Integer id, String nimi, Integer viestien_lm, String viimeisin_viesti) {
        this.id = id;
        this.nimi = nimi;
        this.viestien_lm = viestien_lm;
        this.viimeisin_viesti = viimeisin_viesti;      
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public Integer getViestien_lm() {
        return viestien_lm;
    }

    public void setViestien_lm(Integer viestien_lm) {
        this.viestien_lm = viestien_lm;
    }

    public String getViimeisin_viesti() {
        String viimeisin_viesti = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
        return viimeisin_viesti;
    }
    
    public void setViimeisin_viesti(String viimeisin_viesti) {
        this.viimeisin_viesti = viimeisin_viesti;
    }

}
