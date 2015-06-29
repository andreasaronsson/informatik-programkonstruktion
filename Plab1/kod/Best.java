/**
  *   Andreas Aronsson
  *   pk01-14
  *   2001 11 06
  *   Best.java
  *   Filen Artikel.txt l�ses och de poster d�r m�ngd understiger 
  *   best�llningspunkt skrivs till en fil "Best.txt"
  *   filnamnen l�ses in. Metod finns i LabMetoder.java 
  *   @author Andreas Aronsson
  *   @version 1.1
  */
import java.io.*;
public class Best {
    /**
     *  Mainmetod som b�rjar att exekveras n�r programmet k�rs
     *
     */
    public static void main(String[] args)  throws IOException  {
        String artRad, eanKod;
        double bestPkt, lagerMgd;
        Artikel artikel;
        File filNamnF, filUt;
        filNamnF = LabMetoder.inFilNamn("Skriv s� h�r om du vill ha n�got" +
					"  vettigt gjort; \"Artikel.txt\": ");
        BufferedReader fin = new BufferedReader 
	    (new FileReader(filNamnF));
	filUt = LabMetoder.utFilNamn("Kl�m ur dig vad filen skall heta: ");
	PrintWriter fut = new PrintWriter(new BufferedWriter
	    (new FileWriter(filUt))); 
        bestPkt=0;
        lagerMgd = 0;
	eanKod=null;
        artRad=fin.readLine();  
  
	//l�ser fr�n Artikel.txt och skapar nya best�llningar vid behov.

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
