/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.domain;

import java.util.List;

/**
 *
 * @author jipel
 */
public class Kayttaja {

    private Integer id;
    private String nimimerkki;
    private List<Viesti> kayttajanViestit;

    public Kayttaja(Integer id, String nimimerkki, List<Viesti> kayttajanViestit) {
        this.id = id;
        this.nimimerkki = nimimerkki;
        this.kayttajanViestit = kayttajanViestit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNimimerkki() {
        return nimimerkki;
    }

    public void setNimimerkki(String nimimerkki) {
        this.nimimerkki = nimimerkki;
    }

    public List<Viesti> getKayttajanViestit() {
        return kayttajanViestit;
    }

    public void setKayttajanViestit(List<Viesti> kayttajanViestit) {
        this.kayttajanViestit = kayttajanViestit;
    }
}
