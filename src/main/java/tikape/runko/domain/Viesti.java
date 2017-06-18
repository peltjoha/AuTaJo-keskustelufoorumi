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
public class Viesti {
//    private Integer id;
    private String viesti;
    private String timestamp;
    private String kayttaja;
    private String viestiketju;

    public Viesti(String viesti, String timestamp, String kayttaja, String viestiketju) {
        this.viesti = viesti;
        this.timestamp = timestamp;
        this.kayttaja = kayttaja;
        this.viestiketju = viestiketju;
    }

    public String getTimestamp() {
        
        // palauttaa kyselyhetken aikaleiman eikä viestin?
        
        // Saattaa olla, tää on suoraan sanottuna vähän tällasta trial & error meininkiä mulla
        // Ootko kartalla, miten tää pitäis käytännössä toteuttaa? -J
        
        String timestamp = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getViesti() {
        return viesti;
    }

    public void setViesti(String viesti) {
        this.viesti = viesti;
    }
    
    public String getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(String kayttaja) {
        this.kayttaja = kayttaja;
    }
    
    public String getViestiketju() {
        return viestiketju;
    }

    public void setViestiketju(String viestiketju) {
        this.viestiketju = viestiketju;
    }

}
