import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
/**
  * En lyssnar klass som lyssnar på komponenterna i 
  * NyaProdukterPanel
  * Implementerar ActionListener interfacet för att kunna
  * agera som en lyssnare.
  * pk01-26, pk01-14 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class NyaProdukterActionListener implements ActionListener {

    private NyaProdukterPanel sourcePanel;
    /**
     * Metod för att sätta panelreferens
     * @param panel NyaProdukterPanel
     *
     */
    public void setSourcePanel(NyaProdukterPanel aSourcePanel) {
        sourcePanel = aSourcePanel;
    }
    /**
     * Konstruktor, parameterlös
     *
     */
    public NyaProdukterActionListener() {
    }
    /**
     * Metod för att tolka actionlistenern
     * @param event ActionEvent
     *
     */
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("välj fil")) {
	    JFileChooser chooser = new JFileChooser();
	    int returnVal = chooser.showOpenDialog(sourcePanel);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
		sourcePanel.setArtFil(chooser.getSelectedFile());
		
		sourcePanel.setLista(LabMetoder.readFromFileToList
		                   (sourcePanel.getArtFil()));

	    }
	}
        if (event.getActionCommand().equals("lägg till")) {
	    File artFil=sourcePanel.getArtFil();
	    Artikel artikel=new Artikel();
	    if (eanKoll(sourcePanel)) {
		if (sourcePanel.getVaruNamn().length()==0
                    ||sourcePanel.getEnhet().length()==0)
		    JOptionPane.showMessageDialog
			(null, "Alla fält ej ifyllda.", "Fyll i"
			 +" fler fält!",
			 JOptionPane.ERROR_MESSAGE);
		else 
		    if (artFil==null||sourcePanel.getLista()==null) 
			JOptionPane.showMessageDialog
			    (null, "Ingen fil vald.", "Ingen fil vald.",
			     JOptionPane.ERROR_MESSAGE);
		    
		    else 
			if (fältKoll(sourcePanel, artikel)) 
			    positionKoll(sourcePanel, artikel);
	    }
        }

        if (event.getActionCommand().equals("avbryt")) {
	    LabMetoder.writeFromListToFile
                       (sourcePanel.getLista(), sourcePanel.getArtFil());
	    JOptionPane.showMessageDialog
		(null, "Tack för ditt deltagande.", "Det var trevligt"
		 +" att du ville vara med och lägga till!",
		 JOptionPane.INFORMATION_MESSAGE);
	    System.exit(0);
        }
	if (event.getActionCommand().equals("rensa")) 
	    sourcePanel.rensa();
    }
    /**
     * Metod för att testa eankod
     * @param panel NyaProdukterPanel
     * @return value boolean
     *
     */
    public static boolean eanKoll(NyaProdukterPanel sourcePanel) {
	boolean temp;
	if (LabMetoder.trueEan(sourcePanel.getEan())) 
	    temp =true;
	else {
	    JOptionPane.showMessageDialog
		(null, "Felaktig eankod.", "Dennna"
		 +" eankod existerar ej!",
	        JOptionPane.ERROR_MESSAGE);
	    temp=false;
	}
	return temp;
    }
    /**
     * Metod för att undersöka fält
     * @param panel NyaProdukterPanel
     * @param artikel Artikel
     * @return value boolen
     *
     */
    public static boolean fältKoll(NyaProdukterPanel sourcePanel, 
                                                        Artikel artikel) {
	boolean temp;
	try {
	    artikel.setEanKod(sourcePanel.getEan());
	    artikel.setVaruNamn(sourcePanel.getVaruNamn());
	    artikel.setAPris(Double.parseDouble
			     (sourcePanel.getAPris()));
	    artikel.setEnhet(sourcePanel.getEnhet());
	    artikel.setLagerMgd(Double.parseDouble
				(sourcePanel.getLagerMgd()));
	    artikel.setBestPkt(Double.parseDouble
			       (sourcePanel.getBestPkt()));
	    temp=true;
	}
	catch (NumberFormatException e) {
	    temp=false;
	    JOptionPane.showMessageDialog
		(null, "Felaktig inmatning.", 
		 "Du har matat in ett"
		 +" felaktigt värde(text istället för siffror t ex).",
		 JOptionPane.ERROR_MESSAGE);
	}
	return temp;
    
    }
    /**
     * Metod för att hitta en artikels position
     * @param panel NyaProdukterPanel
     * @param artikel Artikel
     *
     */
    public static void positionKoll(NyaProdukterPanel sourcePanel, 
                                                       Artikel artikel) {
       
	if (sourcePanel.getLista().getPosition(artikel)==-1) {
	    int index=sourcePanel.getLista().getIndexFromEanKod
		(artikel.getEanKod());
	    
	    if (index==-1)
		sourcePanel.getLista().add(artikel);
	    else 
		sourcePanel.getLista().add(index, artikel);
	    JOptionPane.showMessageDialog
		(null, "Artikel tillagd", 
		 "Artikeln du matade in"
		 +" finns nu i lager.",
		 JOptionPane.INFORMATION_MESSAGE);
	    sourcePanel.rensa();
	}
	else 
	    JOptionPane.showMessageDialog
		(null, "Artikel finns redan.", 
		 "Artikel med dennna"
		 +" eankod existerar redan i sortimentet!",
		 JOptionPane.ERROR_MESSAGE);
    }
}  
