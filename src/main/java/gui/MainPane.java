package gui;

import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

public class MainPane extends StackPane {
    public static MainPane Instance;

    private ControlPane controlPane;
    private GraphicPane graphicPane;
    public MainPane() {
        Instance = this;
        // stateModel muss noch geschrieben und hinzugefügt werden.

        controlPane = new ControlPane();
        graphicPane = new GraphicPane();

        final SplitPane verticalSplitter = new SplitPane();
        verticalSplitter.setOrientation(Orientation.HORIZONTAL);
        verticalSplitter.setDividerPosition(0, 0.2);
        verticalSplitter.getItems().addAll(controlPane);
        verticalSplitter.getItems().addAll(graphicPane);

        getChildren().add(verticalSplitter);
    }

    public ControlPane getControlPane() {
        return controlPane;
    }

    public GraphicPane getGraphicPane() {
        return graphicPane;
    }
}
