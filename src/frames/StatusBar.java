package frames;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StatusBar {
    private JPanel statusBarPanel;

    public StatusBar() {
        statusBarPanel = new JPanel();
        statusBarPanel.setBackground(Color.CYAN);
        statusBarPanel.setSize(new Dimension(500, 50));
        statusBarPanel.setPreferredSize(statusBarPanel.getSize());
        Border barBorder = BorderFactory.createLineBorder(Color.BLACK);
        statusBarPanel.setBorder(barBorder);

    }

    public JPanel getStatusBarPanel() {
        return statusBarPanel;
    }
}
