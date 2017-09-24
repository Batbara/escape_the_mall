package inventory;

import javax.swing.*;
import java.awt.*;

public class InventoryView {
    private JPanel inventoryPanel;
    public InventoryView(){
        inventoryPanel = new JPanel();
        inventoryPanel.setSize(new Dimension(325,750));
        inventoryPanel.setPreferredSize(inventoryPanel.getSize());
        inventoryPanel.setBackground(Color.magenta);
    }

    public JPanel getInventoryPanel() {
        return inventoryPanel;
    }
}
