import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
  * En klass som �r en panel och vilken vi d�rmed kan placera
  * ut komponenter i. Vi anv�nder oss av GridBagLayout. 
  * Klassen �rver fr�n JPanel och �r d�rmed en panel (container). 
  * pk01-14, pk01-26, 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class VaruValPanel extends JPanel {

    private JLabel vara, ean, m�ngd, v�lkommen, lagerMgd, rubrik;
    private JTextField eanTF, m�ngdTF, varaTF;
    private JButton k�pKnapp, rensaKnapp, l�ggTillKnapp, avbrytKnapp;
    private JTextArea k�pTA;
    private JScrollPane k�pSP;
    private MinHashTabell hashTabell;
    private File artFil;
 
    /**    
     * Tar en referens till v�r special vektor klass f�r att kunna
     * L�gga till och komma �t person objekten i denna n�r knapparna
     * trycks ner.
     * @param lyssnare, nyHashTabell
     *
     */
    public VaruValPanel
	(VaruValActionListener lyssnare, MinHashTabell nyHashTabell, 
	   File nyArtFil) {
	hashTabell=nyHashTabell;
	artFil=nyArtFil;
        vara = new JLabel("Vara:");
        ean = new JLabel("Eankod:");
        m�ngd = new JLabel("M�ngd:");
        v�lkommen = new JLabel("Var god v�lj vara!");
	lagerMgd=new JLabel("");
	rubrik=new JLabel("Eankod           Vara                       m�ngd");
        eanTF = new JTextField(13);
        m�ngdTF = new JTextField(5);
        varaTF = new JTextField(15);
	varaTF.setEditable(false);
	k�pTA=new JTextArea(3, 30);
	k�pSP=new JScrollPane(k�pTA);
        k�pKnapp = new JButton("K�p");
        l�ggTillKnapp = new JButton("L�gg till");
        rensaKnapp = new JButton("Rensa");
        avbrytKnapp = new JButton("Avbryt");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
	k�pSP.setVerticalScrollBarPolicy(k�pSP.VERTICAL_SCROLLBAR_ALWAYS);
	gbc.gridwidth=5;
        gbc.ipadx=2;
        gbc.gridx=0;
        gbc.insets=new Insets(0,2,0,2);
        add(v�lkommen, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets=new Insets(0,3,0,0);
        gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=1;
        add(ean, gbc);

	gbc.gridwidth=2;
        gbc.gridx=1;
        gbc.gridy=1;
        add(eanTF, gbc);

        gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=2;
        add(vara, gbc);

	gbc.gridwidth=2;
        gbc.gridx=1;
        gbc.gridy=2;
        add(varaTF, gbc);

        gbc.gridwidth=1;
        gbc.gridx=0;
        gbc.gridy=3;
        add(m�ngd, gbc);

	gbc.gridwidth=1;
        gbc.gridx=1;
        gbc.gridy=3;
        add(m�ngdTF, gbc);

	gbc.gridwidth=2;
	gbc.gridx=2;
	gbc.gridy=3;
	add(lagerMgd, gbc);

	gbc.gridwidth=1;
 	gbc.gridx=0;
        gbc.gridy=4;
        add(l�ggTillKnapp, gbc);
	
        gbc.gridx=1;
        gbc.gridy=4;
        add(rensaKnapp, gbc);

	gbc.gridwidth=5;
	gbc.gridx=0;
	gbc.gridy=5;
	add(rubrik, gbc);

	gbc.gridx=0;
	gbc.gridy=6;
	add(k�pSP, gbc);

	gbc.gridwidth=1;
        gbc.gridx=3;
        gbc.gridy=7;
        add(avbrytKnapp, gbc);

        gbc.gridx=2;
        gbc.gridy=7;
        add(k�pKnapp, gbc);


        l�ggTillKnapp.setActionCommand("l�gg till");
        k�pKnapp.setActionCommand("k�p");
        rensaKnapp.setActionCommand("rensa");
        avbrytKnapp.setActionCommand("avbryt");
	eanTF.setActionCommand("ean");
	m�ngdTF.setActionCommand("m�ngd");
	eanTF.addActionListener(lyssnare);
	m�ngdTF.addActionListener(lyssnare);
        l�ggTillKnapp.addActionListener(lyssnare);
        k�pKnapp.addActionListener(lyssnare);
        rensaKnapp.addActionListener(lyssnare);
        avbrytKnapp.addActionListener(lyssnare);
        lyssnare.setSourcePanel(this);
    }
    /**
     * Metod f�r att h�mta uppgifter om k�p
     * @return K�p
     */
    public K�p getK�p() {
        return new K�p
            (eanTF.getText(), Double.parseDouble(m�ngdTF.getText())); 
    }
    /**
     * Metod f�r att uppdatera lager
     * @return ok boolean
     *
     */
    public boolean uppdateraLager() {
	boolean ok=false;
	if (Double.parseDouble(m�ngdTF.getText())<=Double.parseDouble
	  (lagerMgd.getText().substring(8,(lagerMgd.getText().length()-3)))) {
	    Artikel artikel = hashTabell.get(eanTF.getText());
	    artikel.setLagerMgd(artikel.getLagerMgd()-(Double.parseDouble
						       (m�ngdTF.getText())));
	    k�pTA.append(artikel.getEanKod()+"  "+artikel.getVaruNamn()
                                   +"\t"+m�ngdTF.getText()+"\n");
	    ok=true;
	}
	return ok;
    }
    /**
     * Metod f�r att unders�ka lagerm�ngd
     * @return value en double
     *
     */
    public double getLagerMgd() {
	return Double.parseDouble(lagerMgd.getText().substring
                               (8,(lagerMgd.getText().length()-3)));
    }
    /**
     * Metod f�r att �ndra lagerm�ngd
     * @param nyMgd double
     *
     */
    public void setLagerMgd(double nyMgd) {
	lagerMgd.setText("I lager:"+nyMgd+" st");
	m�ngdTF.requestFocus();
    }
    /**
     * Metod f�r att t�mma alla f�lt
     *
     */
    public void rensa() {
	eanTF.setText("");
	varaTF.setText("");
	m�ngdTF.setText("");
	lagerMgd.setText("");
    }
    /**
     * Metod f�r att s�tta textv�rde i varuf�lt
     * @param nyVara String
     *
     */
    public void setVaraTF(String nyVara) {
	varaTF.setText(nyVara);
    }
    /**
     * Metod f�r att h�mta eankod i textf�lt
     * @return value String
     *
     */
    public String getEan() {
	return eanTF.getText();
    }
    /**
     * Metod f�r att h�mta m�ngd i textf�lt
     * @return value String
     *
     */
    public String getM�ngd() {
	return m�ngdTF.getText();
    } 
    /**
     * Metod f�r att h�mta aktuell hashtabell
     * @return hashTabell MinHashTabell
     *
     */
    public MinHashTabell getHashTabell() {
	return hashTabell;
    }
    /**
     * Metod f�r att byta fokus
     *
     */
    public void l�ggTillKnappFocus() {
	l�ggTillKnapp.requestFocus();
    }
    /**
     * Metod f�r att h�mta filobjekt
     * @return artFil File
     *
     */
    public File getArtFil() {
	return artFil;
    }
}
