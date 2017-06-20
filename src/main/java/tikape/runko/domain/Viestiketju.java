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
public class Viestiketju {
    
    private Integer id;
    private String otsikko;
    private String alue;
    private List<Viesti> viestit;

    public Viestiketju(Integer id, String otsikko, String alue, List<Viesti> viestit) {
        this.id = id;
        this.otsikko = otsikko;
        this.alue = alue;
        this.viestit = viestit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }
    
    public String getAlue() {
        return alue;
    }

    public void setAlue(String alue) {
        this.alue = alue;
    }
}
