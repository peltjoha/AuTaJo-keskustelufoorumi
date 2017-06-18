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

    private Integer id;
    private String viesti;
    private String timestamp;
    private Kayttaja kayttaja;
    private Viestiketju viestiketju;

    public Viesti(Integer id, String viesti, String timestamp, Kayttaja kayttaja, Viestiketju viestiketju) {
        this.id = id;
        this.viesti = viesti;
        this.timestamp = timestamp;
        this.kayttaja = kayttaja;
        this.viestiketju = viestiketju;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp; // palautetaan tässä vain olemassaoleva aikaleima
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

    public Kayttaja getKayttaja() {

        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public Viestiketju getViestiketju() {

        return viestiketju;
    }

    public void setViestiketju(Viestiketju viestiketju) {
        this.viestiketju = viestiketju;
    }

}
