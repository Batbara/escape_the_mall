package scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SwitchItemListener implements ItemListener{
    private LocationManager locationManager;
    public SwitchItemListener(LocationManager locationManager){
        this.locationManager = locationManager;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        JPanel scenesHolder = locationManager.getScenesHolder();

        CardLayout cl = (CardLayout)(scenesHolder.getLayout());
        cl.show(scenesHolder, (String)e.getItem());
    }
}
