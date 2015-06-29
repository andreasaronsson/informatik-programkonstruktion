/**
 *  Kvitto.java courtesy of Andreas Aronsson, pk01-14 2001 11 22
 *  Klassen kvitto låter en kund "köpa" varor ur sortimentet m h a eankod
 *  som identifierare. Felmeddelande ges vid felaktig eankod. 
 *  Försöker man köpa mer än vad som finns i lager: felmedd.
 *  Kvitto skrivs ut på skärmen när man handlat klart
 *  @author Andreas Aronsson
 *  @version 1.1
 *
 */

import java.io.*;
import java.util.*;
import java.text.*;


public class Kvitto {
    /**
     *  Mainmetod som börjar att exekveras när programmet körs
     *
     */
    public static void main(String [] args) throws IOException {
	
	File filUt, filNamnF;
	String namn, mer, eanKod;
	double ant, nymgd;
	int n=0, svar;
	filNamnF = LabMetoder.inFilNamn("Skriv \"Artikel.txt\" om du " +
					"vill ha något vettigt gjort: ");
	BufferedReader fin = new BufferedReader 
	    (new FileReader(filNamnF));
	//artiklar i array; storlek?
	n=LabMetoder.parseFileLength(filNamnF);
	//ok, då skapar vi en så stor då...
	Artikel[]a=new Artikel[n];
	//sedan skall filen in i denna array:
	LabMetoder.readFromFileToArray(filNamnF, a);
	fin.close();
	BufferedReader stdin = new BufferedReader
	    (new InputStreamReader(System.in));
	System.out.println("\n\n\nHej och välkommen till Karl's Livs\n\n\n");
	System.out.println("\n\n\nButiken stängs genom att skriva \"slut\""+
			   " när du ombeds ange ditt namn");
	System.out.print("Vad heter du? ");
	namn=stdin.readLine();
	while ( ! namn.equals("slut")) {
	    filUt = LabMetoder.utFilNamn("Ange namn på filen som " +
					 "håller reda på ditt specifika"
					 +" inköp (kund.txt) ");
	    PrintWriter fut = new PrintWriter(new BufferedWriter
		(new FileWriter(filUt))); 
	    System.out.print("Skall vi försöka oss på ett inköp? ");
	    mer=stdin.readLine();
	    while (mer.equals("j")) {
		System.out.print("Då så! Eankod på varan du vill ha: ");
		Artikel sokt = new Artikel();
		eanKod=stdin.readLine();
		sokt.setEanKod(eanKod);
		//undersöker om varan finns
		svar=LabMetoder.binarySearch(sokt, a, n);
		while (svar==-1) {
		    System.out.println("En vara som finns, alltså ");
		    System.out.print("Komigen, eankod...  : ");
		    eanKod=stdin.readLine();
		    sokt.setEanKod(eanKod);
		    svar=LabMetoder.binarySearch(sokt, a, n);
		}
		//objekt skapas av raden som metoden hittade
		Artikel vara=new Artikel (a[svar].getRow());
		Artikel funnen=new Artikel (a[svar].getRow());
		System.out.print("Du vill köpa hur mycket? ");
		ant=Double.parseDouble(stdin.readLine());
		while (ant>vara.getLagerMgd()) {
		    System.out.print("Åpen skall man vara ja!" + 
				     " Hur mycket? ");
		    ant=Double.parseDouble(stdin.readLine());
		}
		nymgd=vara.getLagerMgd()-ant;
		a[svar].setLagerMgd(nymgd);
		funnen.setLagerMgd(ant);
		fut.println(funnen.getRow());
		System.out.print("Skall vi försöka oss på ett inköp till? ");
		mer=stdin.readLine();
	    }//slut while fler inköp
	    fut.close();
	    System.out.println("\n\nJaha, här är ditt kvitto...\n\n\n\n\n\n");

	    System.out.println("\t\t\tKals Livs");

	    System.out.println("\t\t\tpk01-14\tAA");

	    Locale.setDefault(new Locale("sv","SE"));
	    Date today = new Date(); // hämtar nuvarande tidpunkt
	    DateFormat df = DateFormat.getDateTimeInstance
		(DateFormat.MEDIUM, DateFormat.SHORT);
	    System.out.println("\t\t\t" + df.format(today));

	    System.out.println("\t\t_________________________\n");

	    //hur stor array skall vi ha till kund.txt?
	    int kn=LabMetoder.parseFileLength(filUt);
	    //ny array till filen
	    Artikel[]k=new Artikel[kn];
	    //sedan skall kund.txt in i denna array:
	    LabMetoder.readFromFileToArray(filUt, k);
	    NumberFormat r=NumberFormat.getInstance();
	    r.setMaximumFractionDigits(2);
	    r.setMinimumFractionDigits(2);
	    double attBetala =0;
	    if (kn==0) 
		System.out.println("Inga inköp gjorda!");
	    else
		for (int i=0;i<kn;i++) {
		    System.out.println(k[i].getVaruNamn());
		    System.out.println(k[i].getLagerMgd()+"\ta "+
				       k[i].getAPris()+"\t\t\t\t\t"+
			  r.format(k[i].getLagerMgd()*k[i].getAPris()));
		    attBetala=attBetala+k[i].getLagerMgd()*k[i].getAPris();
		}//for slut
	    System.out.println("Att betala\t\t\t\t\t"+r.format(attBetala));
	    System.out.println("Varav moms\t\t\t\t\t"+
			       r.format((attBetala/28)*3));
	    System.out.println("Moms%\t\t\tNetto");
	    System.out.println("12.0\t\t\t"+r.format(attBetala/1.12));
	    System.out.println("Antal artiklar: "+kn);
	    System.out.println("\n\t\tVÄLKOMMEN ÅTER!");
	    filUt.delete();
	    System.out.print("Vad heter du? ");
	    namn=stdin.readLine();
	}//while namn slut
	PrintWriter fut = new PrintWriter(new BufferedWriter
	    (new FileWriter(filNamnF))); 

	//array till fil
	for (int j = 0; j < n; j++) {
	    fut.println(a[j].getRow());
	}//slut for skriv ny artikelfil
	fut.close();
    }//slut main
}//slut class Kvitto
