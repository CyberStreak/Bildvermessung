import gui.MainPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Pane mainPane = new MainPane();

        Scene scene = new Scene(mainPane, 1000,700);

        stage.setScene(scene);
        stage.setTitle("Bildvermessung");
        stage.show();
    }

    public static void main(String[] args) {launch(args);}

}
