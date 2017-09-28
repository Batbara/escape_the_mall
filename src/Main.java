import frames.MainFrame;

import java.io.IOException;

public class Main {
    Main(){
        MainFrame mainFrame = MainFrame.getInstance();
    }
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(Main::new);
    }
}
