import java.awt.event.*;
import javax.swing.*;
/**
  * En lyssnar klass som lyssnar på komponenterna i 
  * KvittoPanel och VaruValPanel
  * Implementerar ActionListener interfacet för att kunna
  * agera som en lyssnare.
  * pk01-14, pk01-26, 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  * 
  */
public class VaruValActionListener implements ActionListener {

    private KöpVector köpVector = null;
    private VaruValPanel sourcePanel;
    private KvittoPanel kvittoPanel;
    private JFrame sourceFrame;

    public void setSourcePanel(VaruValPanel aSourcePanel) {
        sourcePanel = aSourcePanel;
    } 
    public void setKvittoPanel(KvittoPanel aSourcePanel) {
        kvittoPanel = aSourcePanel;
    }
    public void setSourceFrame(JFrame aSourceFrame) {
        sourceFrame = aSourceFrame;
    } 

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("lägg till")) {
	    if (eanEnter(sourcePanel)) {
		if (sourcePanel.getMängd().length()!=0) {
		    if (sourcePanel.getLagerMgd()<Double.parseDouble
			(sourcePanel.getMängd()))
			JOptionPane.showMessageDialog
			    (null, "För mycket....", "För stor mängd.",
			     JOptionPane.ERROR_MESSAGE);
		    else {
			Köp köp = sourcePanel.getKöp();
			if (köpVector == null)
			    köpVector = new KöpVector();
			köpVector.addElement(köp);
			sourcePanel.uppdateraLager();
			sourcePanel.rensa();
		    }
		}
		else
		JOptionPane.showMessageDialog 
		    (null,"Mängd ej angiven.",
		     "Mängd ej angiven.",
		     JOptionPane.ERROR_MESSAGE);
	    }

	}
	if (event.getActionCommand().equals("köp")) {
	    
	    if (köpVector != null) {
		Köp[] köpArray;
		köpArray=LabMetoder.kWriter(köpVector,
					    sourcePanel.getHashTabell());
		Kvitto.main(köpArray);
		LabMetoder.writeHashToFile(sourcePanel.getHashTabell(),
					   sourcePanel.getArtFil());
		sourceFrame.setVisible(false);
	    }
	    else 
		JOptionPane.showMessageDialog (null, "Inga varor valda!",
				  "Du måste välja en vara innan du försöker"
			      +"utföra köpet", JOptionPane.ERROR_MESSAGE);
        }
        if (event.getActionCommand().equals("rensa")) {
	    sourcePanel.rensa();
        }
        if (event.getActionCommand().equals("avbryt")) {
	    sourceFrame.setVisible(false);
	    sourcePanel.getHashTabell().clear();
	    LabMetoder.readFileToHash(sourcePanel.getArtFil(),
				       sourcePanel.getHashTabell());
        }
	if (event.getActionCommand().equals("avbryt kvitto")) {
	    sourceFrame.setVisible(false);
	}

	if (event.getActionCommand().equals("mängd"))
	    sourcePanel.läggTillKnappFocus();

	if (event.getActionCommand().equals("ean")) {
	    if (eanEnter(sourcePanel)) {}
	}
    }
    /**
     * Metod för att kontrollera att uppgifter är korrekta
     * och lagras i rätt ordning. 
     * @param sourcePanel en VaruValPanel
     *
     */
    private boolean eanEnter(VaruValPanel sourcePanel) {
	boolean retur=false;
	if (LabMetoder.trueEan(sourcePanel.getEan())) {
	    Artikel artikel=sourcePanel.getHashTabell().get
		(sourcePanel.getEan());
	    if (artikel.getEanKod() != "") {
		sourcePanel.setVaraTF(artikel.getVaruNamn());
		sourcePanel.setLagerMgd(artikel.getLagerMgd());
		retur=true;
	    }
	    else 
		JOptionPane.showMessageDialog (null, "Artikel saknas.",
			"Artikel saknas.", JOptionPane.ERROR_MESSAGE);
	}
	else
	    JOptionPane.showMessageDialog(null, "Felaktig EAN-kod",
		    "Felaktig EAN-kod", JOptionPane.ERROR_MESSAGE);
	return retur;
    }
}
        
