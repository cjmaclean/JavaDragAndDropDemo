package javadraganddropdemo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Caspian Maclean 30039802
 * 
 * Question 5 – JMC requires the implementation of a program - that can create
 * drag and drop TODO lists - on one side you should have a list of tasks - on
 * the other a list of things to do. - Your program must have help files, - 2D
 * graphics with the ability to drag and drop.
 *
 */
public class JavaDragAndDropDemo  extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root
                = FXMLLoader.load(getClass().getResource("LayoutFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
