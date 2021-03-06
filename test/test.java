
import entities.Complexe;
import entities.Client;
import entities.Penalite;
import entities.Reservation;
import entities.Terrain;
import java.sql.Date;
import java.util.List;
import services.PenaliteCRUD;
import services.ReservationCrud;
import services.TerrainCrud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmed
 */
public class test {
    
    public static void main(String[] args) {
        Complexe c1 = new Complexe(1);
        Penalite pn = new Penalite(25,"carte rouge", 5, c1);
        PenaliteCRUD pnc =new PenaliteCRUD();
        //pnc.supprimerPenalite(pn);
        System.out.println(pnc.AfficherPenalite(25));
        //pnc.addPenalite(pn);
        //pnc.updatePenalite(pn);
        Date d = new Date(11, 10, 2010);
        Reservation r = new Reservation();
        Terrain t= new Terrain(2,"terrain foot", "terrain premier crée");
        Client j = new Client(6);
        r.setDate_creation(d);
        r.setTerrain(t);
        r.setValidee(true);
        r.setDate_reservation(d);
        r.setHeure(12);
        r.setClient(j);
        r.setId(6);
        r.setMontant(150);
        ReservationCrud rc=new ReservationCrud();
        rc.addReservation(r);
        //List l = rc.afficherResheure(0);
        System.out.println(rc.afficherReservations().size());
//        //rc.supprimerReservation(r);
//        rc.modifierReservation(r);
        //TerrainCrud tc=new TerrainCrud();
        //System.out.println(tc.ajouterTerrain(terrain));
        
        
    }
}
