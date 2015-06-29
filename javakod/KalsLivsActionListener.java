import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
/**
  * En lyssnar klass som lyssnar på komponenterna i 
  * KalsLivsPanel
  * Implementerar ActionListener interfacet för att kunna
  * agera som en lyssnare.
  * pk01-14, pk01-26, 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class KalsLivsActionListener implements ActionListener {

    private KalsLivsPanel sourcePanel;
    /**
     * Setmetod som ger lyssnaren en referens till en panel. 
     * @param aSourcePanel den panel lyssnaren skall ta.
     *
     */
    public void setSourcePanel(KalsLivsPanel aSourcePanel) {
        sourcePanel = aSourcePanel;
    }
    /**
     * En parameterlös konstruktor.
     *
     */
    public KalsLivsActionListener() {
    }
    /**
     * Metod som tolkar actionlistenern
     * @param event en ActionEvent
     *
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("välj fil")) {
	    JFileChooser chooser = new JFileChooser();
	    int returnVal = chooser.showOpenDialog(sourcePanel);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
		sourcePanel.getHashTabell().clear();
		sourcePanel.setArtFil(chooser.getSelectedFile());
		LabMetoder.readFileToHash
                      (sourcePanel.getArtFil(), sourcePanel.getHashTabell());
	    }
	}
        if (event.getActionCommand().equals("handla")) {
	    File artFil=sourcePanel.getArtFil();

		if (artFil==null||sourcePanel.getHashTabell()==null) 
		    JOptionPane.showMessageDialog
			(null, "Ingen fil vald.", "Ingen fil vald.",
			 JOptionPane.ERROR_MESSAGE);
		else 
		    VaruVal.main(sourcePanel.getHashTabell(), artFil);
	    
        }

        if (event.getActionCommand().equals("avbryt")) {
	    System.exit(0);
        }
    }
}
        
