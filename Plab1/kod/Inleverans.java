/**
 *   Andreas Aronsson
 *   pk01-14
 *   2001 11 08
 *   Inleverans.java
 *   Filerna Artikel.txt och Best.txt läses och de poster där 
 *   eankod överensstämmer adderas den varumängd som "är på vag in" till 
 *   bef. fil 
 *   filnamnen läses in. Metoder finns i LabMetoder.java 
 *   @author Andreas Aronsson
 *   @version 1.1
 */
import java.io.*;
public class Inleverans {
    /**
     *  Mainmetod Som Börjar Att Exekveras när programmet körs
     *
     */
    public static void main(String[] args)  throws IOException  {

        String artRad, bestRad, eanKod, varuNamn, fyllis;
        double bestPkt, lagerMgd, inMgd;
        Artikel artikel;
        File filNamnArt, filNamnBest, tempfil;
        filNamnArt = LabMetoder.inFilNamn("Skriv så här om du vill ha något" +
					"  vettigt gjort; \"Artikel.txt\": ");
        BufferedReader artfin = new BufferedReader 
	    (new FileReader(filNamnArt));
	filNamnBest = LabMetoder.inFilNamn("Ge hit det"  +
                          " som skall in i lager!!! ");
	BufferedReader bestfin = new BufferedReader(
					  (new FileReader(filNamnBest))); 
	tempfil = new File ("temp.txt");
	PrintWriter tmp = new PrintWriter(new BufferedWriter
	    (new FileWriter(tempfil)));
        bestPkt=0;
        lagerMgd = 0;
	eanKod=null;
        artRad=artfin.readLine(); 
	bestRad=bestfin.readLine();
        while (artRad != null) {
            artikel = new Artikel(artRad);  
	    if (bestRad!=null) {
		//hämtar referens för aktuell artikel
		fyllis = LabMetoder.inLeverans(bestRad);
		//"sätter" den nya mängden
		if (((artikel.getEanKod()).compareTo(fyllis))==0)  { 
		    artikel.setLagerMgd(artikel.getLagerMgd()+
					(artikel.getBestPkt()*3));
		    bestRad=bestfin.readLine();
		}
	    }
	    tmp.println(artikel.getRow());
	    artRad=artfin.readLine();
	}
	System.out.println("Stock inventory \""+filNamnArt+"\" updated.");
        artfin.close();
	bestfin.close();
	tmp.close();
	filNamnArt.delete();
	tempfil.renameTo(filNamnArt);
	filNamnBest.delete();
    } // slut main
}//slut Inleverans

