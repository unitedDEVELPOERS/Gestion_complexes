/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Arbitre;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author ghara
 */
public interface Service <P>  {
    
    void ajouter(P p)throws SQLException;
    void supprimer(P p)throws SQLException;
    void update(P p)throws SQLException;
    ObservableList<P> readAll() throws SQLException;

}
