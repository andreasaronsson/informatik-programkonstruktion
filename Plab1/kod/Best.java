/**
  *   Andreas Aronsson
  *   pk01-14
  *   2001 11 06
  *   Best.java
  *   Filen Artikel.txt läses och de poster där mängd understiger 
  *   beställningspunkt skrivs till en fil "Best.txt"
  *   filnamnen läses in. Metod finns i LabMetoder.java 
  *   @author Andreas Aronsson
  *   @version 1.1
  */
import java.io.*;
public class Best {
    /**
     *  Mainmetod som börjar att exekveras när programmet körs
     *
     */
    public static void main(String[] args)  throws IOException  {
        String artRad, eanKod;
        double bestPkt, lagerMgd;
        Artikel artikel;
        File filNamnF, filUt;
        filNamnF = LabMetoder.inFilNamn("Skriv så här om du vill ha något" +
					"  vettigt gjort; \"Artikel.txt\": ");
        BufferedReader fin = new BufferedReader 
	    (new FileReader(filNamnF));
	filUt = LabMetoder.utFilNamn("Kläm ur dig vad filen skall heta: ");
	PrintWriter fut = new PrintWriter(new BufferedWriter
	    (new FileWriter(filUt))); 
        bestPkt=0;
        lagerMgd = 0;
	eanKod=null;
        artRad=fin.readLine();  
  
	//läser från Artikel.txt och skapar nya beställningar vid behov.

        while (artRad != null) {
            artikel = new Artikel(artRad);  
            if (artikel.getLagerMgd() < artikel.getBestPkt()) { 
		fut.println(artikel.getOrder());
            }
            artRad=fin.readLine();
        }
        if (eanKod == null || eanKod ==  " ")
            System.out.println("Order template \""+filUt+"\" completed.");
        fin.close();
	fut.close();
    } // slut main
}//slut Best
