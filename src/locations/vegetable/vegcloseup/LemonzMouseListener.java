package locations.vegetable.vegcloseup;

import subquests.raccoonquest.RaccoonQuestDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LemonzMouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        Container lemonzPanelContainer = (Container) e.getSource();
        while (lemonzPanelContainer.getParent() != null) {
            lemonzPanelContainer = lemonzPanelContainer.getParent();
        }

        if (lemonzPanelContainer instanceof JFrame) {
            RaccoonQuestDialog raccoonQuestDialog = new RaccoonQuestDialog((JFrame) lemonzPanelContainer);
            raccoonQuestDialog.getDialogFrame().setVisible(true);

        }
    }
}
