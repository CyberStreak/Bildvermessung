package gui;

import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

public class MainPane extends StackPane {

    public MainPane() {

        // StateModel hinzufügen

        ControlPane controlPane = new ControlPane();
        GraphicPane graphicPane = new GraphicPane();

        final SplitPane verticalSplitter = new SplitPane();
        verticalSplitter.setOrientation(Orientation.HORIZONTAL);
        verticalSplitter.setDividerPosition(0, 0.2);
        verticalSplitter.getItems().addAll(controlPane, graphicPane);

        getChildren().add(verticalSplitter);
    }
}
