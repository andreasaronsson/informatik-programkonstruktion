import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
  * En klass som är en panel och vilken vi därmed kan placera
  * ut komponenter i. Vi använder oss av GridBagLayout. 
  * Klassen ärver från JPanel och är därmed en panel (container). 
  * pk01-14, pk01-26, 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class VaruValPanel extends JPanel {

    private JLabel vara, ean, mängd, välkommen, lagerMgd, rubrik;
    private JTextField eanTF, mängdTF, varaTF;
    private JButton köpKnapp, rensaKnapp, läggTillKnapp, avbrytKnapp;
    private JTextArea köpTA;
    private JScrollPane köpSP;
    private MinHashTabell hashTabell;
    private File artFil;
 
    /**    
     * Tar en referens till vår special vektor klass för att kunna
     * Lägga till och komma åt person objekten i denna när knapparna
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
        mängd = new JLabel("Mängd:");
        välkommen = new JLabel("Var god välj vara!");
	lagerMgd=new JLabel("");
	rubrik=new JLabel("Eankod           Vara                       mängd");
        eanTF = new JTextField(13);
        mängdTF = new JTextField(5);
        varaTF = new JTextField(15);
	varaTF.setEditable(false);
	köpTA=new JTextArea(3, 30);
	köpSP=new JScrollPane(köpTA);
        köpKnapp = new JButton("Köp");
        läggTillKnapp = new JButton("Lägg till");
        rensaKnapp = new JButton("Rensa");
        avbrytKnapp = new JButton("Avbryt");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
	köpSP.setVerticalScrollBarPolicy(köpSP.VERTICAL_SCROLLBAR_ALWAYS);
	gbc.gridwidth=5;
        gbc.ipadx=2;
        gbc.gridx=0;
        gbc.insets=new Insets(0,2,0,2);
        add(välkommen, gbc);

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
        add(mängd, gbc);

	gbc.gridwidth=1;
        gbc.gridx=1;
        gbc.gridy=3;
        add(mängdTF, gbc);

	gbc.gridwidth=2;
	gbc.gridx=2;
	gbc.gridy=3;
	add(lagerMgd, gbc);

	gbc.gridwidth=1;
 	gbc.gridx=0;
        gbc.gridy=4;
        add(läggTillKnapp, gbc);
	
        gbc.gridx=1;
        gbc.gridy=4;
        add(rensaKnapp, gbc);

	gbc.gridwidth=5;
	gbc.gridx=0;
	gbc.gridy=5;
	add(rubrik, gbc);

	gbc.gridx=0;
	gbc.gridy=6;
	add(köpSP, gbc);

	gbc.gridwidth=1;
        gbc.gridx=3;
        gbc.gridy=7;
        add(avbrytKnapp, gbc);

        gbc.gridx=2;
        gbc.gridy=7;
        add(köpKnapp, gbc);


        läggTillKnapp.setActionCommand("lägg till");
        köpKnapp.setActionCommand("köp");
        rensaKnapp.setActionCommand("rensa");
        avbrytKnapp.setActionCommand("avbryt");
	eanTF.setActionCommand("ean");
	mängdTF.setActionCommand("mängd");
	eanTF.addActionListener(lyssnare);
	mängdTF.addActionListener(lyssnare);
        läggTillKnapp.addActionListener(lyssnare);
        köpKnapp.addActionListener(lyssnare);
        rensaKnapp.addActionListener(lyssnare);
        avbrytKnapp.addActionListener(lyssnare);
        lyssnare.setSourcePanel(this);
    }
    /**
     * Metod för att hämta uppgifter om köp
     * @return Köp
     */
    public Köp getKöp() {
        return new Köp
            (eanTF.getText(), Double.parseDouble(mängdTF.getText())); 
    }
    /**
     * Metod för att uppdatera lager
     * @return ok boolean
     *
     */
    public boolean uppdateraLager() {
	boolean ok=false;
	if (Double.parseDouble(mängdTF.getText())<=Double.parseDouble
	  (lagerMgd.getText().substring(8,(lagerMgd.getText().length()-3)))) {
	    Artikel artikel = hashTabell.get(eanTF.getText());
	    artikel.setLagerMgd(artikel.getLagerMgd()-(Double.parseDouble
						       (mängdTF.getText())));
	    köpTA.append(artikel.getEanKod()+"  "+artikel.getVaruNamn()
                                   +"\t"+mängdTF.getText()+"\n");
	    ok=true;
	}
	return ok;
    }
    /**
     * Metod för att undersöka lagermängd
     * @return value en double
     *
     */
    public double getLagerMgd() {
	return Double.parseDouble(lagerMgd.getText().substring
                               (8,(lagerMgd.getText().length()-3)));
    }
    /**
     * Metod för att ändra lagermängd
     * @param nyMgd double
     *
     */
    public void setLagerMgd(double nyMgd) {
	lagerMgd.setText("I lager:"+nyMgd+" st");
	mängdTF.requestFocus();
    }
    /**
     * Metod för att tömma alla fält
     *
     */
    public void rensa() {
	eanTF.setText("");
	varaTF.setText("");
	mängdTF.setText("");
	lagerMgd.setText("");
    }
    /**
     * Metod för att sätta textvärde i varufält
     * @param nyVara String
     *
     */
    public void setVaraTF(String nyVara) {
	varaTF.setText(nyVara);
    }
    /**
     * Metod för att hämta eankod i textfält
     * @return value String
     *
     */
    public String getEan() {
	return eanTF.getText();
    }
    /**
     * Metod för att hämta mängd i textfält
     * @return value String
     *
     */
    public String getMängd() {
	return mängdTF.getText();
    } 
    /**
     * Metod för att hämta aktuell hashtabell
     * @return hashTabell MinHashTabell
     *
     */
    public MinHashTabell getHashTabell() {
	return hashTabell;
    }
    /**
     * Metod för att byta fokus
     *
     */
    public void läggTillKnappFocus() {
	läggTillKnapp.requestFocus();
    }
    /**
     * Metod för att hämta filobjekt
     * @return artFil File
     *
     */
    public File getArtFil() {
	return artFil;
    }
}
