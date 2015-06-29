import java.awt.event.*;
import javax.swing.*;
/**
  * En lyssnar klass som lyssnar p� komponenterna i 
  * KvittoPanel och VaruValPanel
  * Implementerar ActionListener interfacet f�r att kunna
  * agera som en lyssnare.
  * pk01-14, pk01-26, 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  * 
  */
public class VaruValActionListener implements ActionListener {

    private K�pVector k�pVector = null;
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
        if (event.getActionCommand().equals("l�gg till")) {
	    if (eanEnter(sourcePanel)) {
		if (sourcePanel.getM�ngd().length()!=0) {
		    if (sourcePanel.getLagerMgd()<Double.parseDouble
			(sourcePanel.getM�ngd()))
			JOptionPane.showMessageDialog
			    (null, "F�r mycket....", "F�r stor m�ngd.",
			     JOptionPane.ERROR_MESSAGE);
		    else {
			K�p k�p = sourcePanel.getK�p();
			if (k�pVector == null)
			    k�pVector = new K�pVector();
			k�pVector.addElement(k�p);
			sourcePanel.uppdateraLager();
			sourcePanel.rensa();
		    }
		}
		else
		JOptionPane.showMessageDialog 
		    (null,"M�ngd ej angiven.",
		     "M�ngd ej angiven.",
		     JOptionPane.ERROR_MESSAGE);
	    }

	}
	if (event.getActionCommand().equals("k�p")) {
	    
	    if (k�pVector != null) {
		K�p[] k�pArray;
		k�pArray=LabMetoder.kWriter(k�pVector,
					    sourcePanel.getHashTabell());
		Kvitto.main(k�pArray);
		LabMetoder.writeHashToFile(sourcePanel.getHashTabell(),
					   sourcePanel.getArtFil());
		sourceFrame.setVisible(false);
	    }
	    else 
		JOptionPane.showMessageDialog (null, "Inga varor valda!",
				  "Du m�ste v�lja en vara innan du f�rs�ker"
			      +"utf�ra k�pet", JOptionPane.ERROR_MESSAGE);
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

	if (event.getActionCommand().equals("m�ngd"))
	    sourcePanel.l�ggTillKnappFocus();

	if (event.getActionCommand().equals("ean")) {
	    if (eanEnter(sourcePanel)) {}
	}
    }
    /**
     * Metod f�r att kontrollera att uppgifter �r korrekta
     * och lagras i r�tt ordning. 
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
        
