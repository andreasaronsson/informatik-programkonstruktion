import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
  * Köp - beskriver ett Köp.
  * KöpVector - samlar flera köpobjekt, alltså köp.
  * KöpRegistreringPanel - Vårt grafiska interface.
  * 
  */
public class Kvitto {

public static void main(Köp[] köpArray) {

	JFrame kvitto=new JFrame("Kvitto");
        VaruValActionListener lyssnare = 
	    new VaruValActionListener();
	KvittoPanel kvittoPanel =new KvittoPanel (lyssnare, köpArray);
	lyssnare.setSourceFrame(kvitto);
        kvitto.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        kvitto.setContentPane(kvittoPanel);
        kvitto.pack();
        kvitto.setVisible(true);
    }

}
