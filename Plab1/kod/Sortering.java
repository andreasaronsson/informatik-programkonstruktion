/**
 *   Andreas Aronsson
 *   pk01-14
 *   2001 11 13
 *   Sortering.java
 *   Filen Artikel.txt läses och sorteras efter varunamn 
 *   Namn, pknr dagens datum står längst upp...
 *   filnamnen läses in. Metod finns i LabMetoder.java 
 *   @author Andreas Aronsson
 *   @version 1.1
 */
import java.io.*;
import java.util.*;
import java.text.*;
public class Sortering {
    /**
     *  Mainmetod som börjar att exekveras när programmet körs
     *
     */
    public static void main(String[] args)  throws IOException  {

        File filNamnF, filUt;//ett objekt för resp. fil
	int poster;//håller reda på hur stor arrayen skall vara
	//obj. i dessa två klasser
        filNamnF = LabMetoder.inFilNamn("Skriv \"Artikel.txt\" om du " +
					"vill ha något vettigt gjort: ");
	//metodanrop
        BufferedReader fin = new BufferedReader 
	    (new FileReader(filNamnF));
	//ström in öppen
	filUt = LabMetoder.utFilNamn("Filen som är sorterad skall heta: ");
	//ny fil skapas med klassen File
	PrintWriter fut = new PrintWriter(new BufferedWriter
	    (new FileWriter(filUt))); 
	//ström öppen
	Locale.setDefault(new Locale("sv","SE"));
	Date today = new Date(); // hämtar nuvarande tidpunkt
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
