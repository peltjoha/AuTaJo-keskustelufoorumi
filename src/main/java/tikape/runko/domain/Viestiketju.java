/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.domain;

/**
 *
 * @author jipel
 */
public class Viestiketju {
    
    private Integer id;
    private String otsikko;
    private String alue;

    public Viestiketju(Integer id, String otsikko, String alue) {
        this.id = id;
        this.otsikko = otsikko;
        this.alue = alue;
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
