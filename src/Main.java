import frames.MainFrame;

import java.io.IOException;

public class Main {
    Main(){
        try {
            MainFrame frame = new MainFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(Main::new);
    }
}
