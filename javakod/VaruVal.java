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
public class VaruVal {

    /**
     * Mainmetod
     * @param hashTabell MinHashTabell
     * @param artFil File
     *
     */
    public static void main(MinHashTabell hashTabell, File artFil) {
	VaruValActionListener lyssnare=new VaruValActionListener();
	JFrame frame = new JFrame("K�pregistrering");

	VaruValPanel panel = new VaruValPanel(lyssnare, hashTabell, artFil);
	lyssnare.setSourceFrame(frame);
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
