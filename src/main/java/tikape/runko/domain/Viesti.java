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

    public String getTimestamp() {
<<<<<<< HEAD

        return timestamp; // palautetaan tässä vain olemassaoleva aikaleima
=======
        
        // palauttaa kyselyhetken aikaleiman eikä viestin?
        
        // Saattaa olla, tää on suoraan sanottuna vähän tällasta trial & error meininkiä mulla
        // Ootko kartalla, miten tää pitäis käytännössä toteuttaa? -J
        
        String timestamp = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
        return timestamp;
>>>>>>> 216861ba8f56d5e021ff5281afc2a31118e2018c
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
