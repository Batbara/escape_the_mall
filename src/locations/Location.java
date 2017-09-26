package locations;

import frames.PanelWithImage;

import javax.swing.*;
import java.util.Map;

public interface Location {
    void sceneChanged(String name);
    Map<String, String> getScenesOrder();
    PanelWithImage getScenePanel(String sceneID);
    String getLocationLabel();
    JPanel getLocationContainer();
}
