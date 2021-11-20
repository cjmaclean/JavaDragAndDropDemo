/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadraganddropdemo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
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
    private void handleQuit(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    private void handleAbout(ActionEvent event) {
        String aboutFileString = "about.pdf";
        if (Desktop.isDesktopSupported()) {
            try {
                File aboutFile = new File(aboutFileString);
                Desktop.getDesktop().open(aboutFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }
    
    @FXML
    private void handleHelp(ActionEvent event) {
        String helpFileString = "help.pdf";
        if (Desktop.isDesktopSupported()) {
            try {
                File helpFile = new File(helpFileString);
                Desktop.getDesktop().open(helpFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }
    
    @FXML
    private void handleTaskDrag(MouseEvent event) {

        Label sourceLabel = null;
        if (event.getSource() instanceof Label) {
            sourceLabel = (Label) (event.getSource());
            
            Dragboard db = sourceLabel.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent cbContent = new ClipboardContent();
            cbContent.putString(sourceLabel.getText());
            db.setContent(cbContent);
        }

        event.consume();
    }

    @FXML
    void handleDragOverToDoItem(DragEvent event) {
        if (event.getGestureSource() == milkLabel) {
            event.acceptTransferModes(TransferMode.MOVE);
        } else {
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    }

    @FXML
    void handleDroppedOnToDoItem(DragEvent event) {
        Label targetLabel = null;

        if (event.getGestureTarget() instanceof Label) {
            targetLabel = (Label) (event.getGestureTarget());

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
