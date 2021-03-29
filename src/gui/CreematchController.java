/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.equipe;
import entities.matche;
import entities.utilisateur;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import static jdk.nashorn.internal.objects.Global.undefined;
import services.ServiceMatche;

/**
 * FXML Controller class
 *
 * @author fachr
 */
public class CreematchController implements Initializable {
public equipe equipe,equipe2;
public utilisateur utilisateur; 

    public equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(equipe equipe2) {
        this.equipe2 = equipe2;
    }
    @FXML
    private Button btAcceuil;

    public equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(equipe equipe) {
        this.equipe = equipe;
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    @FXML
    private Button btReservation;
    @FXML
    private Button btEquipe;
    @FXML
    private Button btBoutique;
    @FXML
    private Button btCompte;
    @FXML
    private DatePicker datee;
    @FXML
    private ListView<?> listterain;
    @FXML
    private Button b1;
    @FXML
    private Button b4;
    @FXML
    private Button b6;
    @FXML
    private Button b5;
    @FXML
    private Button b3;
    @FXML
    private Button b2;
    @FXML
    private Button b9;
    @FXML
    private Button b8;
    @FXML
    private Button b7;
    @FXML
    private Button valider;
    @FXML
    private Button retour;
public int test=0;
Date datet;
    @FXML
    private Label testdate;
    @FXML
    private Label testdate1;
    @FXML
    private Label testdate2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       testdate.setVisible(false);testdate1.setVisible(false);testdate2.setVisible(false);
          }    

    @FXML
    private void Acceuil(ActionEvent event) {
       
    }

    @FXML
    private void Reservation(ActionEvent event) {
    }

    @FXML
    private void Equipe(ActionEvent event) {
    }

    @FXML
    private void Compte(ActionEvent event) {
    }

    @FXML
    private void fvalider(ActionEvent event) throws SQLException {testdate2.setVisible(false);
       if(datee.getValue() == null) {
    testdate.setVisible(true);
}else{testdate.setVisible(false);
        LocalDate ld = datee.getValue();
Calendar c =  Calendar.getInstance();
if(test==0){

testdate1.setVisible(true);
}else{



if(test==1){testdate1.setVisible(false);
    c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 8, 00, 00);
}else if(test==2){testdate1.setVisible(false);
     c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 10, 00, 00);
}else if(test==3){testdate1.setVisible(false);
     c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 12, 00, 00);
}else if(test==4){testdate1.setVisible(false);
     c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 14, 00, 00);
}else if(test==5){testdate1.setVisible(false);
     c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 16, 00, 00);
}else if(test==6){testdate1.setVisible(false);
     c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 18, 00, 00);
}else if(test==7){testdate1.setVisible(false);
     c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 20, 00, 00);
}else if(test==8){testdate1.setVisible(false);
     c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 22, 00, 00);
}else if(test==9){testdate1.setVisible(false);
     c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth(), 00, 00, 00);
}

 datet = c.getTime();
        String pattern = "yyyy-M-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("fr", "FR"));
         String dateee = simpleDateFormat.format(datet);
         if(datet.compareTo(new Date())<0){
             testdate2.setVisible(true);
         }else{
             System.out.println(dateee);
             Alert alert = new Alert(AlertType.INFORMATION);
             ServiceMatche sm=new ServiceMatche();
             String pattern1 = "yyyy-M-dd hh:mm:ss";
     SimpleDateFormat simpleDateFormat1 =new SimpleDateFormat(pattern1, new Locale("fr", "FR"));
       String today = simpleDateFormat1.format(new Date());
             matche m=new matche(0,today,dateee,equipe.getId(),equipe2.getId(),0,4);
             sm.ajouter(m);
alert.setTitle("Defi Equipe");
alert.setHeaderText("vous avez créé une Defi Avec "+this.getEquipe2().getNom());
alert.setContentText("Date : "+dateee);

alert.showAndWait();
         }
        
    }}}

    @FXML
    private void fretour(ActionEvent event) throws IOException, SQLException {
         FXMLLoader loader=new  FXMLLoader(getClass().getResource("creeposition.fxml"));
            Parent root=loader.load();
            CreepositionController pdc = loader.getController();
            pdc.setEquipe(equipe);
            pdc.setUtilisateur(utilisateur);
            
            retour.getScene().setRoot(root);
        
    }

    @FXML
    private void fb1(ActionEvent event) {test=1;
         b1.setOpacity(0.7); b2.setOpacity(1);b3.setOpacity(1);b4.setOpacity(1);b5.setOpacity(1);b6.setOpacity(1);b7.setOpacity(1);b8.setOpacity(1);b8.setOpacity(1);b9.setOpacity(1);
    }

    @FXML
    private void fb4(ActionEvent event) {test=4;
         b1.setOpacity(1); b2.setOpacity(1);b3.setOpacity(1);b4.setOpacity(0.7);b5.setOpacity(1);b6.setOpacity(1);b7.setOpacity(1);b8.setOpacity(1);b8.setOpacity(1);b9.setOpacity(1);
    }

    @FXML
    private void fb6(ActionEvent event) {test=6;
         b1.setOpacity(1); b2.setOpacity(1);b3.setOpacity(1);b4.setOpacity(1);b5.setOpacity(1);b6.setOpacity(0.7);b7.setOpacity(1);b8.setOpacity(1);b8.setOpacity(1);b9.setOpacity(1);
    }

    @FXML
    private void fb5(ActionEvent event) {test=5; b1.setOpacity(1); b2.setOpacity(1);b3.setOpacity(1);b4.setOpacity(1);b5.setOpacity(0.7);b6.setOpacity(1);b7.setOpacity(1);b8.setOpacity(1);b8.setOpacity(1);b9.setOpacity(1);
    }

    @FXML
    private void fb3(ActionEvent event) {test=3;
         b1.setOpacity(1); b2.setOpacity(1);b3.setOpacity(0.7);b4.setOpacity(1);b5.setOpacity(1);b6.setOpacity(1);b7.setOpacity(1);b8.setOpacity(1);b8.setOpacity(1);b9.setOpacity(1);
    }

    @FXML
    private void fb2(ActionEvent event) {test=2;
         b1.setOpacity(1); b2.setOpacity(0.7);b3.setOpacity(1);b4.setOpacity(1);b5.setOpacity(1);b6.setOpacity(1);b7.setOpacity(1);b8.setOpacity(1);b8.setOpacity(1);b9.setOpacity(1);
    }

    @FXML
    private void fb9(ActionEvent event) {test=9;
         b1.setOpacity(1); b2.setOpacity(1);b3.setOpacity(1);b4.setOpacity(1);b5.setOpacity(1);b6.setOpacity(1);b7.setOpacity(1);b8.setOpacity(1);b8.setOpacity(1);b9.setOpacity(0.7);
    }

    @FXML
    private void fb8(ActionEvent event) {test=8;
         b1.setOpacity(1); b2.setOpacity(1);b3.setOpacity(1);b4.setOpacity(1);b5.setOpacity(1);b6.setOpacity(1);b7.setOpacity(1);b8.setOpacity(0.7);b9.setOpacity(1);
    }

    @FXML
    private void fb7(ActionEvent event) {test=7;
         b1.setOpacity(1); b2.setOpacity(1);b3.setOpacity(1);b4.setOpacity(1);b5.setOpacity(1);b6.setOpacity(1);b7.setOpacity(0.7);b8.setOpacity(1);b8.setOpacity(1);b9.setOpacity(1);
    }
    
}
