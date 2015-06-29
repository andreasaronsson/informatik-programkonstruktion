import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
  * En klass som är en panel och vilken vi därmed kan placera
  * ut komponenter i. Vi använder oss av GridLayout. 
  * Klassen ärver från JPanel och är därmed en panel (container)
  * pk01-14, pk01-26 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class NyaProdukterPanel extends JPanel { 
    private JLabel ean, varuNamn, lagerMgd, aPris, bestPkt, enhet;
    private JButton väljFilKnapp, läggTillKnapp, avbrytKnapp, rensaKnapp; 
    private JTextField filTF, eanTF, varuNamnTF, lagerMgdTF, enhetTF;
    private JTextField aPrisTF, bestPktTF;
    private MinLista minLista;
    private File artFil;
    /**
     * Konstruktor
     * @param lyssnare NyaProdukterActionListener
     *
     */
    public NyaProdukterPanel (NyaProdukterActionListener lyssnare) {
        ean = new JLabel("Ean-kod:");
	varuNamn = new JLabel("Varunamn:");
	lagerMgd = new JLabel("Lagermängd:");
	aPris = new JLabel("á-pris:");
	bestPkt = new JLabel("Beställningspunkt:");
	enhet=new JLabel("Enhet:");


        väljFilKnapp = new JButton("Välj Fil");
	avbrytKnapp = new JButton("Avbryt");
	rensaKnapp = new JButton("Rensa");
	läggTillKnapp = new JButton("Lägg till");

	filTF = new JTextField(20);
	filTF.setEditable(false); 
	eanTF = new JTextField(13);
	varuNamnTF = new JTextField(20);
	lagerMgdTF = new JTextField(6);
	aPrisTF = new JTextField(10);
	bestPktTF = new JTextField(6);
	enhetTF=new JTextField(10);

        setLayout(new GridLayout(9,2));

	add(väljFilKnapp);
 	add(filTF);
 	add(ean);
 	add(eanTF);
 	add(varuNamn);
 	add(varuNamnTF);
	add(aPris);
 	add(aPrisTF);
 	add(enhet);
 	add(enhetTF);
 	add(lagerMgd);
 	add(lagerMgdTF);
 	add(bestPkt);
 	add(bestPktTF);
	add(läggTillKnapp);
	add(rensaKnapp);
	add(avbrytKnapp);

        väljFilKnapp.setActionCommand("välj fil");
        läggTillKnapp.setActionCommand("lägg till");
	avbrytKnapp.setActionCommand("avbryt");
	rensaKnapp.setActionCommand("rensa");
        väljFilKnapp.addActionListener(lyssnare);
        läggTillKnapp.addActionListener(lyssnare);
        avbrytKnapp.addActionListener(lyssnare);
        rensaKnapp.addActionListener(lyssnare);
        lyssnare.setSourcePanel(this);
    }
    /**
     * Metod för att returnera filobjekt
     * @return artFil File
     *
     */
    public File getArtFil() {
	return artFil;
    }
    /**
     * Metod för att returnera eankod från textfält
     * @return eankod String
     *
     */
    public String getEan() {
	return eanTF.getText();
    }
    /**
     * Metod för att returnera varunamn från textfält
     * @return varunamn String
     *
     */
    public String getVaruNamn() {
	return varuNamnTF.getText();
    }
    /**
     * Metod för att returnera apris från textfält
     * @return apris String
     *
     */
    public String getAPris() {
	return aPrisTF.getText();
    }
    /**
     * Metod för att returnerna lagermängd från textfält
     * @return lagermängd String
     *
     */
    public String getLagerMgd() {
	return lagerMgdTF.getText();
    }
    /**
     * Metod för att returnera beställningspunkt från textfält
     * @return bestpkt String
     *
     */
    public String getBestPkt() {
	return bestPktTF.getText();
    }
    /**
     * Metod för att returnera enhet från textfält
     * @return enhet String
     *
     */
    public String getEnhet() {
	return enhetTF.getText();
    }
    /**
     * Metod för att hämta lista
     * @return minLista MinLista
     *
     */
    public MinLista getLista() {
	return minLista;
    }
    /**
     * Metod för att sätta filobjekt
     * @param nyArtFil File
     *
     */
    public void setArtFil(File nyArtFil) {
	artFil=nyArtFil;
	filTF.setText("" + artFil);
    }
    /**
     * Metod för att sätta listobjekt
     * @param nyMinLista MinLista
     *
     */
    public void setLista(MinLista nyMinLista) {
	minLista=nyMinLista;
    }
    /**
     * Metod för att tömma textfält
     *
     */
    public void rensa() {
	eanTF.setText("");
	varuNamnTF.setText("");
	enhetTF.setText("");
	lagerMgdTF.setText("");
	aPrisTF.setText("");
	bestPktTF.setText("");
    }
}
