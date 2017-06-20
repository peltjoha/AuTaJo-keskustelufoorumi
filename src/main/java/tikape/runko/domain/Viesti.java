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


    private String viesti;
    private String timestamp;
    private Integer kayttaja;
    private Integer viestiketju;

    public Viesti(String viesti, String timestamp, Integer kayttaja, Integer viestiketju) {

        this.viesti = viesti;
        this.timestamp = timestamp;
        this.kayttaja = kayttaja;
        this.viestiketju = viestiketju;
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

    public int getKayttaja() {

        return kayttaja;
    }

    public void setKayttaja(int kayttaja) {
        this.kayttaja = kayttaja;
    }

    public int getViestiketju() {

        return viestiketju;
    }

    public void setViestiketju(int viestiketju) {
        this.viestiketju = viestiketju;
    }

    @Override
    public String toString() {
        return "Viesti{" + "viesti=" + viesti + ", timestamp=" + timestamp + ", kayttaja=" + kayttaja + ", viestiketju=" + viestiketju + '}';
    }

}
