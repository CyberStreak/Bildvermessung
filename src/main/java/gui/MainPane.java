package gui;

import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import logic.ImageGenerator;

public class MainPane extends StackPane {
    public static MainPane Instance;
    private final ControlPane controlPane;
    private final GraphicPane graphicPane;
    private ImageGenerator currentImageGenerator;

    public MainPane() {
        StateModel stateModel = new StateModel();

        Instance = this;
        controlPane = new ControlPane(stateModel);
        graphicPane = new GraphicPane(stateModel);

        controlPane.setMinWidth(200);
        controlPane.setMaxWidth(200);

        final SplitPane verticalSplitter = new SplitPane();
        verticalSplitter.setOrientation(Orientation.HORIZONTAL);
        verticalSplitter.setDividerPosition(0, 0.2);
        verticalSplitter.getItems().addAll(controlPane);
        verticalSplitter.getItems().addAll(graphicPane);

        this.getChildren().add(verticalSplitter);
    }

    public ControlPane getControlPane() {
        return controlPane;
    }

    public GraphicPane getGraphicPane() {
        return graphicPane;
    }

    public void setCurrentImageGenerator(ImageGenerator imageGenerator) {
        this.currentImageGenerator = imageGenerator;
    }

    public ImageGenerator getCurrentImageGenerator() {
        return currentImageGenerator;
    }
}
