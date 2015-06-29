import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
  * En klass som �r en panel och vilken vi d�rmed kan placera
  * ut komponenter i. Vi anv�nder oss av GridBagLayout, vilken
  * ger oss en stor frihet.
  * Klassen �rver fr�n JPanel och �r d�rmed en panel (container)
  * pk01-14, pk01-26, 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class KalsLivsPanel extends JPanel {

    private JLabel  v�lkommen, v�ljFil, handla, avbryt;
    private JButton v�ljFilKnapp, handlaKnapp, avbrytKnapp;
    private File artFil;
    private MinHashTabell hashTabell;
    /** 
     * Tar en referens till v�r special vektor klass f�r att kunna
     * L�gga till och komma �t person objekten i denna n�r knapparna
     * trycks ner.
     * @param lyssnare KalsLivsActionListener
     *
     */
    public KalsLivsPanel (KalsLivsActionListener lyssnare) {
	hashTabell=new MinHashTabell();
        v�ljFil = new JLabel("V�lj Fil:");
        handla = new JLabel("Handla:");
	v�lkommen = new JLabel("V�lkommen till Kal's Livs!");
	avbryt = new JLabel("Avbryt:");

        v�ljFilKnapp = new JButton("V�lj Fil");
        handlaKnapp = new JButton("Handla");
	avbrytKnapp = new JButton("Avbryt");
 
	setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
	
	gbc.gridwidth=3;
        gbc.ipadx=2;
        gbc.gridx=0;
        gbc.insets=new Insets(0,2,0,2);
        add(v�lkommen, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets=new Insets(0,3,0,0);
        gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=1;
        add(v�ljFilKnapp, gbc);

	gbc.gridwidth=1;
        gbc.gridx=2;
        gbc.gridy=1;
        add(v�ljFil, gbc);

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

        v�ljFilKnapp.setActionCommand("v�lj fil");
        handlaKnapp.setActionCommand("handla");
	avbrytKnapp.setActionCommand("avbryt");
        v�ljFilKnapp.addActionListener(lyssnare);
        handlaKnapp.addActionListener(lyssnare);
        avbrytKnapp.addActionListener(lyssnare);
        lyssnare.setSourcePanel(this);
    }
    /**
     * Metod f�r att h�mta filnamn
     * @return artFil File
     *
     */
    public File getArtFil() {
        return artFil;
    }
    /**
     * Metod f�r att s�tta filobjekt
     * @param nyArtFil File
     *
     */
    public void setArtFil(File nyArtFil) {
        artFil=nyArtFil;
    }
    /**
     * Metod f�r att h�mta hashtabell
     * @return hashTabell MinHashTabell
     *
     */
    public MinHashTabell getHashTabell() {
	return hashTabell;
    }

}
