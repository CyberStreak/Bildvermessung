package gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicPane extends StackPane {
    public GraphicPane() {
        String strTitle = "Titulo de la Ventana";
        int w_width = 500;
        int w_height = 500;

        //Die folgen drei Befehle funktionieren noch nicht.

        //GraphicPane.setTitle(strTitle);
        //GraphicPane.setWidth(w_width);
        //GraphicPane.setHeight(w_height);

        Group root = new Group();
        Scene scene = new Scene(root);

        String imagePath = "src/main/java/data/image01.jpg";

        BufferedImage imvFile;

        ImageView imv = new ImageView(imagePath);
        try {
            imvFile = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (imvFile.getWidth() > imvFile.getHeight()) {
            imv.fitWidthProperty().bind(scene.widthProperty());
        } else {
            imv.fitHeightProperty().bind(scene.heightProperty());
        }
        imv.setPreserveRatio(true);



        // root.getChildren().add(imv);
        // primaryStage.setScene(scene);
        // primaryStage.show();

        VBox graphicPane = new VBox();
        graphicPane.getChildren().add(imv);
        this.getChildren().add(graphicPane);

    }
}
