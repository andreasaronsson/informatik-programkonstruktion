/**
 *  Kvitto.java courtesy of Andreas Aronsson, pk01-14 2001 11 22
 *  Klassen kvitto l�ter en kund "k�pa" varor ur sortimentet m h a eankod
 *  som identifierare. Felmeddelande ges vid felaktig eankod. 
 *  F�rs�ker man k�pa mer �n vad som finns i lager: felmedd.
 *  Kvitto skrivs ut p� sk�rmen n�r man handlat klart
 *  @author Andreas Aronsson
 *  @version 1.1
 *
 */

import java.io.*;
import java.util.*;
import java.text.*;


public class Kvitto {
    /**
     *  Mainmetod som b�rjar att exekveras n�r programmet k�rs
     *
     */
    public static void main(String [] args) throws IOException {
	
	File filUt, filNamnF;
	String namn, mer, eanKod;
	double ant, nymgd;
	int n=0, svar;
	filNamnF = LabMetoder.inFilNamn("Skriv \"Artikel.txt\" om du " +
					"vill ha n�got vettigt gjort: ");
	BufferedReader fin = new BufferedReader 
	    (new FileReader(filNamnF));
	//artiklar i array; storlek?
	n=LabMetoder.parseFileLength(filNamnF);
	//ok, d� skapar vi en s� stor d�...
	Artikel[]a=new Artikel[n];
	//sedan skall filen in i denna array:
	LabMetoder.readFromFileToArray(filNamnF, a);
	fin.close();
	BufferedReader stdin = new BufferedReader
	    (new InputStreamReader(System.in));
	System.out.println("\n\n\nHej och v�lkommen till Karl's Livs\n\n\n");
	System.out.println("\n\n\nButiken st�ngs genom att skriva \"slut\""+
			   " n�r du ombeds ange ditt namn");
	System.out.print("Vad heter du? ");
	namn=stdin.readLine();
	while ( ! namn.equals("slut")) {
	    filUt = LabMetoder.utFilNamn("Ange namn p� filen som " +
					 "h�ller reda p� ditt specifika"
					 +" ink�p (kund.txt) ");
	    PrintWriter fut = new PrintWriter(new BufferedWriter
		(new FileWriter(filUt))); 
	    System.out.print("Skall vi f�rs�ka oss p� ett ink�p? ");
	    mer=stdin.readLine();
	    while (mer.equals("j")) {
		System.out.print("D� s�! Eankod p� varan du vill ha: ");
		Artikel sokt = new Artikel();
		eanKod=stdin.readLine();
		sokt.setEanKod(eanKod);
		//unders�ker om varan finns
		svar=LabMetoder.binarySearch(sokt, a, n);
		while (svar==-1) {
		    System.out.println("En vara som finns, allts� ");
		    System.out.print("Komigen, eankod...  : ");
		    eanKod=stdin.readLine();
		    sokt.setEanKod(eanKod);
		    svar=LabMetoder.binarySearch(sokt, a, n);
		}
		//objekt skapas av raden som metoden hittade
		Artikel vara=new Artikel (a[svar].getRow());
		Artikel funnen=new Artikel (a[svar].getRow());
		System.out.print("Du vill k�pa hur mycket? ");
		ant=Double.parseDouble(stdin.readLine());
		while (ant>vara.getLagerMgd()) {
		    System.out.print("�pen skall man vara ja!" + 
				     " Hur mycket? ");
		    ant=Double.parseDouble(stdin.readLine());
		}
		nymgd=vara.getLagerMgd()-ant;
		a[svar].setLagerMgd(nymgd);
		funnen.setLagerMgd(ant);
		fut.println(funnen.getRow());
		System.out.print("Skall vi f�rs�ka oss p� ett ink�p till? ");
		mer=stdin.readLine();
	    }//slut while fler ink�p
	    fut.close();
	    System.out.println("\n\nJaha, h�r �r ditt kvitto...\n\n\n\n\n\n");

	    System.out.println("\t\t\tKals Livs");

	    System.out.println("\t\t\tpk01-14\tAA");

	    Locale.setDefault(new Locale("sv","SE"));
	    Date today = new Date(); // h�mtar nuvarande tidpunkt
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
		System.out.println("Inga ink�p gjorda!");
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
	    System.out.println("\n\t\tV�LKOMMEN �TER!");
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
