import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
  * En klass som är en panel och vilken vi därmed kan placera
  * ut komponenter i. Vi använder oss av GridBagLayout, vilken
  * ger oss en stor frihet.
  * Klassen ärver från JPanel och är därmed en panel (container)
  * pk01-14, pk01-26, 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class KalsLivsPanel extends JPanel {

    private JLabel  välkommen, väljFil, handla, avbryt;
    private JButton väljFilKnapp, handlaKnapp, avbrytKnapp;
    private File artFil;
    private MinHashTabell hashTabell;
    /** 
     * Tar en referens till vår special vektor klass för att kunna
     * Lägga till och komma åt person objekten i denna när knapparna
     * trycks ner.
     * @param lyssnare KalsLivsActionListener
     *
     */
    public KalsLivsPanel (KalsLivsActionListener lyssnare) {
	hashTabell=new MinHashTabell();
        väljFil = new JLabel("Välj Fil:");
        handla = new JLabel("Handla:");
	välkommen = new JLabel("Välkommen till Kal's Livs!");
	avbryt = new JLabel("Avbryt:");

        väljFilKnapp = new JButton("Välj Fil");
        handlaKnapp = new JButton("Handla");
	avbrytKnapp = new JButton("Avbryt");
 
	setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
	
	gbc.gridwidth=3;
        gbc.ipadx=2;
        gbc.gridx=0;
        gbc.insets=new Insets(0,2,0,2);
        add(välkommen, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets=new Insets(0,3,0,0);
        gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=1;
        add(väljFilKnapp, gbc);

	gbc.gridwidth=1;
        gbc.gridx=2;
        gbc.gridy=1;
        add(väljFil, gbc);

	gbc.gridwidth=2;
        gbc.gridx=0;
        gbc.gridy=2;
        add(handlaKnapp, gbc);

        gbc.gridwidth=2;
	gbc.gridx=1;
        gbc.gridy=2;
        add(handla, gbc);

	gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=3;
        add(avbrytKnapp, gbc);

	gbc.gridwidth=2;
        gbc.gridx=1;
        gbc.gridy=3;
        add(avbryt, gbc);

        väljFilKnapp.setActionCommand("välj fil");
        handlaKnapp.setActionCommand("handla");
	avbrytKnapp.setActionCommand("avbryt");
        väljFilKnapp.addActionListener(lyssnare);
        handlaKnapp.addActionListener(lyssnare);
        avbrytKnapp.addActionListener(lyssnare);
        lyssnare.setSourcePanel(this);
    }
    /**
     * Metod för att hämta filnamn
     * @return artFil File
     *
     */
    public File getArtFil() {
        return artFil;
    }
    /**
     * Metod för att sätta filobjekt
     * @param nyArtFil File
     *
     */
    public void setArtFil(File nyArtFil) {
        artFil=nyArtFil;
    }
    /**
     * Metod för att hämta hashtabell
     * @return hashTabell MinHashTabell
     *
     */
    public MinHashTabell getHashTabell() {
	return hashTabell;
    }

}
