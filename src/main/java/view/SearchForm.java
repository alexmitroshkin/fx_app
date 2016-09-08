package view;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by alex on 15.08.2016.
 */
public class SearchForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane mainPanel = new AnchorPane();
        Parent root = mainPanel;
        primaryStage.setTitle("Search");
        primaryStage.setScene(new Scene(root, 400,400));
        primaryStage.show();
    }

    private VBox addVBox(){
        VBox vBox = new VBox();
        return vBox;
    }
}
