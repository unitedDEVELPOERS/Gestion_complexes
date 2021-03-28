/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class JourController {

    @FXML
    private Label lbJour;

    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(i);
    }

    private int i;
    private MyListener myListener;

    public void setData(int i, MyListener myListener) {
        this.i = i;
        this.myListener = myListener;
        lbJour.setText("1");
        
    }
    
}
