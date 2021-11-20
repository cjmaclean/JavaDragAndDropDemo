/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadraganddropdemo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 * FXML Controller class
 *
 * @author 30039802
 *
 * Unmodified from example JavaFX program so far.
 *
 */
public class LayoutFXMLController implements Initializable {

    @FXML
    private Label milkLabel;

    @FXML
    private Label dishesLabel;

    @FXML
    private Label takeLabel;

    @FXML
    private Label bringLabel;

    @FXML
    private Label todoLabel1;
    @FXML
    private Label todoLabel2;
    @FXML
    private Label todoLabel3;
    @FXML
    private Label todoLabel4;
    @FXML
    private Label todoLabel5;




    @FXML
    private void handleTaskDrag(MouseEvent event) {

        Label sourceLabel = null;
        if (event.getSource() instanceof Label) {
            sourceLabel = (Label) (event.getSource());
            System.out.println("You dragged me!");

            Dragboard db = sourceLabel.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putString(sourceLabel.getText());
            db.setContent(cbContent);
        }

        event.consume();
    }

    @FXML
    void handleDragOver1(DragEvent event) {
        System.out.println("drag over!");
        if (event.getGestureSource() == milkLabel) {
            System.out.println("milk over!");
            event.acceptTransferModes(TransferMode.MOVE);
        } else {
            System.out.println("non-milk over!");
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    }

    @FXML
    void handleDroppedOn1(DragEvent event) {
        Label targetLabel = null;
        System.out.println("1 drag dropped!" + event.getGestureTarget() + event.getGestureTarget().getClass());

        //if (true) {
        if (event.getGestureTarget() instanceof Label) {
            targetLabel = (Label) (event.getGestureTarget());

            System.out.println("drag dropped!");
            targetLabel.setText("full");
            Dragboard db = event.getDragboard();
            if (db.hasString()) {
                targetLabel.setText(db.getString());
                event.setDropCompleted(true);
            } else {
                event.setDropCompleted(false);
            }

        } else {
            todoLabel1.setText("full");
            Dragboard db = event.getDragboard();
            if (db.hasString()) {
                todoLabel1.setText(db.getString());
                event.setDropCompleted(true);
            } else {
                event.setDropCompleted(false);
            }
            event.consume();
        }
    }


    @FXML
    void handleTaskDragDone(DragEvent event) {
        System.out.println("drag done!");

        if (event.getTransferMode() == TransferMode.MOVE) {
            Label sourceLabel = null;
            if (event.getSource() instanceof Label) {
                sourceLabel = (Label) (event.getSource());
                sourceLabel.setText("________");
            }
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
