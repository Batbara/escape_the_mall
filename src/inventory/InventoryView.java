package inventory;

import frames.PanelWithImage;
import frames.Tools;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class InventoryView {
    private PanelWithImage inventoryPanel;
    public InventoryView(){
        initPanel();
    }
    private void initPanel(){
        try {
            inventoryPanel = Tools.getInstance().createPanel("/inventory/img/basket");
        } catch (IOException e) {
            e.printStackTrace();
        }

       // inventoryPanel.setSize(new Dimension(in,750));
        inventoryPanel.setPreferredSize(inventoryPanel.getSize());
    }
    public PanelWithImage getInventoryPanel() {
        /*JPanel container = new JPanel(new BorderLayout());
        container.setSize(new Dimension(320,300));
        container.setPreferredSize(container.getSize());
        container.add(inventoryPanel, BorderLayout.CENTER);
        container.setBackground(Color.magenta);
        return container;*/
        return inventoryPanel;

    }
}
