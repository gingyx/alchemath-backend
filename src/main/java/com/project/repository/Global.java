package com.project.repository;

import jakarta.persistence.*;

@Entity
public class Global {
    @Id
    private long id;
    @Column(length=1000000)
    @Lob
    private String globalElos;

    public Global() {

    }

    public Global(long id, String globalElos) {
        this.id = id;
        this.globalElos = globalElos;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getGlobalElos() {
        return globalElos;
    }
    public void setGlobalElos(String globalElos) {
        this.globalElos = globalElos;
    }

    /*
[{"ADD_SUB":1050,"BRACK_SIGN":1100,"MUL_DIV":1200,"BRACK_MULT":1300,"FRAC":1350},{"ADD_SUB":1050,"BRACK_SIGN":1100,"MUL_DIV":1200,"BRACK_MULT":1300,"FRAC":1350,"DISCRIMI":1400},{"ADD_SUB":1050,"BRACK_SIGN":1100,"MUL_DIV":1200,"BRACK_MULT":1300,"FRAC":1350,"HORNER":1400}]
     */

}
