package frames;

import frames.MainFramePresenter;
import frames.StarterScreenPresenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener {
    private MainFramePresenter mainFramePresenter;
    public StartButtonListener(MainFramePresenter mainFramePresenter){
        this.mainFramePresenter = mainFramePresenter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mainFramePresenter.showGameScreen();
    }
}
