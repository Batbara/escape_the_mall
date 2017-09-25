package locations.vegetable.vegcloseup;

import frames.PanelWithImage;
import frames.Tools;
import locations.Scene;
import locations.vegetable.VegetableDepartmentLocation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;

public class VegCloseUpScene extends Observable implements Scene{
    private PanelWithImage closeUpScenePanel;
    private LemonzView lemonzView;
    private JPanel returningArea;
    private VegetableDepartmentLocation parentLocation;
    public VegCloseUpScene(VegetableDepartmentLocation parentLocation){
        initScene();
        lemonzView = new LemonzView();
        this.parentLocation = parentLocation;
        initReturningArea();
        placeObjectsOnScene();
        addObserver(new VegCloseUpPresenter(this));
    }
    private void initScene(){
        try {
            closeUpScenePanel = Tools.getInstance().createScene("/locations/vegetable/img/vegcloseup");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void initReturningArea(){

        returningArea = new JPanel();
        returningArea.setSize(new Dimension(closeUpScenePanel.getWidth()-150,240));
        returningArea.setOpaque(false);
        returningArea.addMouseListener(new ReturningAreaListener(this));
    }
    @Override
    public void placeObjectsOnScene() {
        PanelWithImage lemonzPanel = lemonzView.getLemonzPanel();
        closeUpScenePanel.add(lemonzPanel);
        lemonzPanel.setBounds(191,140,lemonzPanel.getWidth(),lemonzPanel.getHeight());

        closeUpScenePanel.add(returningArea);
        returningArea.setBounds(25,closeUpScenePanel.getHeight()-240,returningArea.getWidth(),returningArea.getHeight());
    }

    public PanelWithImage getCloseUpScenePanel() {
        return closeUpScenePanel;
    }
    public String getSceneID(){
        return "vegcloseup";
    }
    public void switchScene(){
        setChanged();
        notifyObservers("return");
    }

    public VegetableDepartmentLocation getParentLocation() {
        return parentLocation;
    }
}
