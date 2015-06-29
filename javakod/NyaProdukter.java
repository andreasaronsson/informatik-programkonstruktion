import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
  * NyaProdukter
  * Lägger till nya produkter i vald artikelfil
  * pk01-14, pk01-26, 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class NyaProdukter {

/**
 * Mainmetod
 * @param args String[]
 *
 */
public static void main(String[] args) {

	JFrame frame=new JFrame("Nya Produkter");
        NyaProdukterActionListener lyssnare = 
	    new NyaProdukterActionListener();
	NyaProdukterPanel panel =new NyaProdukterPanel (lyssnare);
	lyssnare.setSourcePanel(panel);
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
