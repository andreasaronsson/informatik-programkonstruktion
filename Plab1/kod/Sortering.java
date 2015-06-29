/**
 *   Andreas Aronsson
 *   pk01-14
 *   2001 11 13
 *   Sortering.java
 *   Filen Artikel.txt l�ses och sorteras efter varunamn 
 *   Namn, pknr dagens datum st�r l�ngst upp...
 *   filnamnen l�ses in. Metod finns i LabMetoder.java 
 *   @author Andreas Aronsson
 *   @version 1.1
 */
import java.io.*;
import java.util.*;
import java.text.*;
public class Sortering {
    /**
     *  Mainmetod som b�rjar att exekveras n�r programmet k�rs
     *
     */
    public static void main(String[] args)  throws IOException  {

        File filNamnF, filUt;//ett objekt f�r resp. fil
	int poster;//h�ller reda p� hur stor arrayen skall vara
	//obj. i dessa tv� klasser
        filNamnF = LabMetoder.inFilNamn("Skriv \"Artikel.txt\" om du " +
					"vill ha n�got vettigt gjort: ");
	//metodanrop
        BufferedReader fin = new BufferedReader 
	    (new FileReader(filNamnF));
	//str�m in �ppen
	filUt = LabMetoder.utFilNamn("Filen som �r sorterad skall heta: ");
	//ny fil skapas med klassen File
	PrintWriter fut = new PrintWriter(new BufferedWriter
	    (new FileWriter(filUt))); 
	//str�m �ppen
	Locale.setDefault(new Locale("sv","SE"));
	Date today = new Date(); // h�mtar nuvarande tidpunkt
	DateFormat df = DateFormat.getDateTimeInstance
	    (DateFormat.MEDIUM, DateFormat.SHORT);
	fut.println("Andreas Aronsson pk01-14 " + df.format(today));

	poster=LabMetoder.parseFileLength(filNamnF);
	Artikel[] arr=new Artikel [poster];

	LabMetoder.readFromFileToArray(filNamnF, arr);

        LabMetoder.selectionSort(arr,arr.length);
      
        for (int i = 0; i < arr.length; i++) {
	    fut.println(arr[i].getSortedRow());
	    System.out.println(arr[i].getSortRowDisp());
	}

	System.out.println("Sorted template \""+filUt+"\" completed.");
        fin.close();
	fut.close();
    } // slut main
}//slut Sortering
