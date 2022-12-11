package logic;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public interface iTool {
    // is called when the mouse is released
    void onMouseRelease(MouseEvent event, Pane drawingPane);
    // unused so far (check for removal)
    void onMouseClicked(MouseEvent event, Pane drawingPane);
    // called the first time the mouse pressing starts
    void onMousePressed(MouseEvent event, Pane drawingPane);
    // called when the mouse is moved during dragging
    void onMouseDragged(MouseEvent event, Pane drawingPane);
    // called before the user changes the tool
    void onCleanUp(Pane drawingPane);
}
