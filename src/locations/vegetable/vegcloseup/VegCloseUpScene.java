package locations.vegetable.vegcloseup;

import frames.PanelWithImage;
import frames.Tools;
import locations.Scene;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

public class VegCloseUpScene extends Observable implements Scene{
    private PanelWithImage closeUpSceneScene;
    private LemonzView lemonzView;
    public VegCloseUpScene(){
        initScene();
        lemonzView = new LemonzView();
        placeObjectsOnScene();
    }
    private void initScene(){
        try {
            closeUpSceneScene= Tools.getInstance().createScene("/locations/vegetable/img/vegcloseup");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void placeObjectsOnScene() {
        PanelWithImage lemonzPanel = lemonzView.getLemonzPanel();
        closeUpSceneScene.add(lemonzPanel);
        lemonzPanel.setBounds(150,100,lemonzPanel.getWidth(),lemonzPanel.getHeight());
    }

    public PanelWithImage getCloseUpSceneScene() {
        return closeUpSceneScene;
    }
    public String getSceneID(){
        return "vegcloseup";
    }
}
