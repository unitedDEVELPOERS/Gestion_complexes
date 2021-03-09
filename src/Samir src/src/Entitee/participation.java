/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitee;

/**
 *
 * @author user
 */
public class participation {

   
    private int id;
    private String date;
    private Competition comp;
    private Equipe eq;
 public participation(int id, Competition comp, Equipe eq) {
        this.id = id;
        this.comp = comp;
        this.eq = eq;
    }
    public participation() {
    }

    public participation(int id, String date, Competition comp, Equipe eq) {
        this.id = id;
        this.date = date;
        this.comp = comp;
        this.eq = eq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Competition getComp() {
        return comp;
    }

    public void setComp(Competition comp) {
        this.comp = comp;
    }

    public Equipe getEq() {
        return eq;
    }

    public void setEq(Equipe eq) {
        this.eq = eq;
    }

    @Override
    public String toString() {
        return "participation{" + "id=" + id + ", date=" + date + ", comp=" + comp + ", eq=" + eq + '}';
    }
    
}
