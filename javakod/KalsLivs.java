import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
  * K�p - beskriver ett K�p.
  * K�pVector - samlar flera k�pobjekt, allts� k�p.
  * VaruValPanel - V�rt grafiska interface.
  * pk01-14, pk01-26 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class KalsLivs {
    /**
     * Mainmetod som exekveras n�r programmet k�rs
     * @param args String[]
     *
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("KalsLivs");
        KalsLivsActionListener lyssnare = new KalsLivsActionListener();
        KalsLivsPanel panel = new KalsLivsPanel(lyssnare);
        frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
