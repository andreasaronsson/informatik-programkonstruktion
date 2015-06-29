import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
  * En klass som �r en panel och vilken vi d�rmed kan placera
  * ut komponenter i. Vi anv�nder oss av GridLayout. 
  * Klassen �rver fr�n JPanel och �r d�rmed en panel (container)
  * pk01-14, pk01-26 2002 01 07
  * @author Aron&Franz
  * @version 1.1
  *
  */
public class NyaProdukterPanel extends JPanel { 
    private JLabel ean, varuNamn, lagerMgd, aPris, bestPkt, enhet;
    private JButton v�ljFilKnapp, l�ggTillKnapp, avbrytKnapp, rensaKnapp; 
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
	lagerMgd = new JLabel("Lagerm�ngd:");
	aPris = new JLabel("�-pris:");
	bestPkt = new JLabel("Best�llningspunkt:");
	enhet=new JLabel("Enhet:");


        v�ljFilKnapp = new JButton("V�lj Fil");
	avbrytKnapp = new JButton("Avbryt");
	rensaKnapp = new JButton("Rensa");
	l�ggTillKnapp = new JButton("L�gg till");

	filTF = new JTextField(20);
	filTF.setEditable(false); 
	eanTF = new JTextField(13);
	varuNamnTF = new JTextField(20);
	lagerMgdTF = new JTextField(6);
	aPrisTF = new JTextField(10);
	bestPktTF = new JTextField(6);
	enhetTF=new JTextField(10);

        setLayout(new GridLayout(9,2));

	add(v�ljFilKnapp);
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
	add(l�ggTillKnapp);
	add(rensaKnapp);
	add(avbrytKnapp);

        v�ljFilKnapp.setActionCommand("v�lj fil");
        l�ggTillKnapp.setActionCommand("l�gg till");
	avbrytKnapp.setActionCommand("avbryt");
	rensaKnapp.setActionCommand("rensa");
        v�ljFilKnapp.addActionListener(lyssnare);
        l�ggTillKnapp.addActionListener(lyssnare);
        avbrytKnapp.addActionListener(lyssnare);
        rensaKnapp.addActionListener(lyssnare);
        lyssnare.setSourcePanel(this);
    }
    /**
     * Metod f�r att returnera filobjekt
     * @return artFil File
     *
     */
    public File getArtFil() {
	return artFil;
    }
    /**
     * Metod f�r att returnera eankod fr�n textf�lt
     * @return eankod String
     *
     */
    public String getEan() {
	return eanTF.getText();
    }
    /**
     * Metod f�r att returnera varunamn fr�n textf�lt
     * @return varunamn String
     *
     */
    public String getVaruNamn() {
	return varuNamnTF.getText();
    }
    /**
     * Metod f�r att returnera apris fr�n textf�lt
     * @return apris String
     *
     */
    public String getAPris() {
	return aPrisTF.getText();
    }
    /**
     * Metod f�r att returnerna lagerm�ngd fr�n textf�lt
     * @return lagerm�ngd String
     *
     */
    public String getLagerMgd() {
	return lagerMgdTF.getText();
    }
    /**
     * Metod f�r att returnera best�llningspunkt fr�n textf�lt
     * @return bestpkt String
     *
     */
    public String getBestPkt() {
	return bestPktTF.getText();
    }
    /**
     * Metod f�r att returnera enhet fr�n textf�lt
     * @return enhet String
     *
     */
    public String getEnhet() {
	return enhetTF.getText();
    }
    /**
     * Metod f�r att h�mta lista
     * @return minLista MinLista
     *
     */
    public MinLista getLista() {
	return minLista;
    }
    /**
     * Metod f�r att s�tta filobjekt
     * @param nyArtFil File
     *
     */
    public void setArtFil(File nyArtFil) {
	artFil=nyArtFil;
	filTF.setText("" + artFil);
    }
    /**
     * Metod f�r att s�tta listobjekt
     * @param nyMinLista MinLista
     *
     */
    public void setLista(MinLista nyMinLista) {
	minLista=nyMinLista;
    }
    /**
     * Metod f�r att t�mma textf�lt
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
