import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
  * K�p - beskriver ett K�p.
  * K�pVector - samlar flera k�pobjekt, allts� k�p.
  * K�pRegistreringPanel - V�rt grafiska interface.
  * 
  */
public class Kvitto {

public static void main(K�p[] k�pArray) {

	JFrame kvitto=new JFrame("Kvitto");
        VaruValActionListener lyssnare = 
	    new VaruValActionListener();
	KvittoPanel kvittoPanel =new KvittoPanel (lyssnare, k�pArray);
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
