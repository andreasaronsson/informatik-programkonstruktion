/**
 *  NyaProdukter.java courtesy of Andreas Aronsson
 *  pk01-14
 *  2001 11 14
 *  c:a 5-10 nya produkter läggs in i sortimentet
 *  som vanligt läses filnamnen in...
 *  @author Andreas Aronsson
 *  @version 1.1
 */
import java.io.*;
import java.util.*;
public class NyaProdukter {
    /**
     *  Mainmetod som programmet börjar exekveras i
     *
     */
    public static void main (String [] args) throws IOException {
	
	File filNamnA, tempfil;
	Artikel nyArtikel, artikel;//ny=art. som adderas, art.=obj. i "Artfil"
	String svar, inRad, taRad, nyEanKod, nyUppg;
	double ny;

	BufferedReader stdin = new BufferedReader
	    (new InputStreamReader(System.in));
	System.out.print("Vill du lägga till nya produkter(j/n)? ");
	svar=stdin.readLine();
	while (svar.equals("j")) {
	    //metodanrop för att få rätt filnamn
	    filNamnA = LabMetoder.inFilNamn("Till vilken fil?? ");
	    BufferedReader afin = new BufferedReader
		(new FileReader(filNamnA));
	    System.out.print("Jaha, ge mig en produkt då! ");
	    nyEanKod=stdin.readLine();
	    nyArtikel=new Artikel();
	    nyArtikel.setEanKod(nyEanKod);
	    //metodanrop villkor för att ngt utförs annars felmedd. 
	    while (LabMetoder.trueEan(nyArtikel.getEanKod())==false) {
		System.out.println("Felaktig ean eller? ");
		System.out.print("Ge mig en riktig eankod! ");
		nyEanKod=stdin.readLine();
		nyArtikel.setEanKod(nyEanKod);
		//koll om produkten redan finns
		while (LabMetoder.existsInFile(filNamnA, nyArtikel)) {
		    System.out.println("Finns ju redan, pucko ");
		    System.out.print("Försök igen: ");
		    nyEanKod=stdin.readLine();
		    nyArtikel.setEanKod(nyEanKod);
		}
	    }
	    while (LabMetoder.existsInFile(filNamnA, nyArtikel)) {
		System.out.println("Finns ju redan, pucko ");
		System.out.print("Försök igen: ");
		nyEanKod=stdin.readLine();
		nyArtikel.setEanKod(nyEanKod);
	    }
	    System.out.print("ååÅÅÅ! Jaja, ge mig ett namn: ");
	    nyUppg=stdin.readLine();
	    nyArtikel.setVaruNamn(nyUppg);
	    System.out.print("Vad skall detta kosta då? ");
	    ny=Double.parseDouble(stdin.readLine());
	    nyArtikel.setAPris(ny);
	    System.out.print("Enhet skall vara(tio tecken max): ");
	    nyUppg=stdin.readLine();
	    while (nyUppg.length()>10) {
		System.out.print("Enhet SKALL vara(TIO tecken max): ");
		nyUppg=stdin.readLine();
	    }
	    nyArtikel.setEnhet(nyUppg);
	    System.out.print("Hur mycket i lager? ");
	    ny=Double.parseDouble(stdin.readLine());
	    nyArtikel.setLagerMgd(ny);
	    System.out.print("Beställningspunkt? ");
	    ny=Double.parseDouble(stdin.readLine());
	    nyArtikel.setBestPkt(ny);
	    tempfil=new File("temp.txt");
	    PrintWriter tmp = new PrintWriter(new BufferedWriter
		(new FileWriter(tempfil)));
	    inRad=afin.readLine();
	    if (inRad!=null)
		artikel=new Artikel(inRad);
	    else
		artikel=new Artikel();
	    //nu vill vi fortsätta så länge rader finns i Art.fil
	    //vi kör så länge nyean<de ean som finns  
	    if (inRad!=null) {
		while ((nyArtikel.getEanKod().compareTo
			(artikel.getEanKod()))>0&&inRad!=null) {
		    tmp.println(artikel.getRow());
		    inRad=afin.readLine();
		    if (inRad!=null)
			artikel=new Artikel(inRad);
		}//slut while existerande ean kommer före i ordn.
	    }
	    //nya artikeln skrivs in
	    tmp.println(nyArtikel.getRow());
	    //åsså sprytsar vi över resten
	    while (inRad!=null) {
		artikel=new Artikel(inRad);
		tmp.println(artikel.getRow());
		inRad=afin.readLine();
	    }//slut while more rows
	    afin.close();
	    tmp.close();
	    filNamnA.delete();
	    tempfil.renameTo(filNamnA);
	    System.out.print("Ickenöjd??? ");
	    svar=stdin.readLine();
	}//slut while mer produkter = j
	System.out.println("\n\nTack för ditt deltagande.\n\n");
    }//slut main
}//slut NyaProdukter
