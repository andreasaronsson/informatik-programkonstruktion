import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
/**
  * En klass som är en panel och vilken vi därmed kan placera
  * ut komponenter i. Vi använder oss av GridBagLayout, vilken
  * ger oss en stor frihet.
  * Klassen ärver från JPanel och är därmed en panel (container)
  * 
  * @author Aron&Franz
  * @version 1.1
  */
public class KvittoPanel extends JPanel {

    private JLabel välkommen, summa, pk, datum;
    private JButton avbrytKnapp;
    private JTextArea köpTA;
    private JScrollPane köpSP; 

    public KvittoPanel
	(VaruValActionListener lyssnare, Köp[] köpArray) {

	Locale.setDefault(new Locale("sv","SE"));
	Date today = new Date(); // hämtar nuvarande tidpunkt
	DateFormat df = DateFormat.getDateTimeInstance
	    (DateFormat.MEDIUM, DateFormat.SHORT);
	NumberFormat r=NumberFormat.getCurrencyInstance();

	pk=new JLabel("pk01-14, pk01-26  AA, FH");
	datum=new JLabel(df.format(today));
        välkommen= new JLabel("Kal's Livs");
	köpTA=new JTextArea(5, 30);
	köpSP=new JScrollPane(köpTA);
        avbrytKnapp = new JButton("Stäng");
	double attBetala=0;
	int antalVaror=0;
	r.format(attBetala);
	for (int i=0;i<köpArray.length;i++)
	    if (köpArray[i]!=null) {
		attBetala=attBetala
                            +köpArray[i].getUtMgd()*köpArray[i].getAPris();
		antalVaror=(int)(antalVaror+köpArray[i].getUtMgd());
		köpTA.append(köpArray[i].getVaruNamn()+"\n"
                          +köpArray[i].getUtMgd()
			  +" á "+r.format(köpArray[i].getAPris())+"\t   "
		    +r.format(köpArray[i].getUtMgd()*köpArray[i].getAPris())
                     +"\n");
	    }
	summa=new JLabel ("Att betala:  "+r.format(attBetala)+"  Varav moms:  "
			  +r.format((attBetala/28)*3));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
	köpSP.setVerticalScrollBarPolicy(köpSP.VERTICAL_SCROLLBAR_ALWAYS);

	gbc.gridwidth=3;
        gbc.ipadx=2;
        gbc.gridx=0;
        gbc.insets=new Insets(0,2,0,2);
        add(välkommen, gbc);

	gbc.gridy=1;
	add(pk, gbc);

	gbc.gridy=2;
	add(datum, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets=new Insets(0,3,0,0);

	gbc.gridwidth=3;
	gbc.gridx=0;
	gbc.gridy=3;
	add(köpSP, gbc);

	gbc.gridwidth=1;
	gbc.gridx=0;
	gbc.gridy=4;
	add(summa, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx=0;
        gbc.gridy=5;
        add(avbrytKnapp, gbc);

        avbrytKnapp.setActionCommand("avbryt kvitto");
        avbrytKnapp.addActionListener(lyssnare);
        lyssnare.setKvittoPanel(this);
    }

}
