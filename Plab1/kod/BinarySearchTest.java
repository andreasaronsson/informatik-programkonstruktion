/*
 * testballe
 *
 */

import java.io.*;

public class BinarySearchTest {
    public static void main (String [] args) throws IOException {

	boolean svar;
	String eanKod;
	File filNamnA;
	Artikel sokt=new Artikel();
	int n;
	//metodanrop för att få rätt filnamn
	filNamnA = LabMetoder.inFilNamn("Till vilken fil?? ");
	//öppna ström
	BufferedReader afin = new BufferedReader
	    (new FileReader(filNamnA));
	
	n=LabMetoder.parseFileLength(filNamnA);
	
	Artikel[]a=new Artikel[n];

	LabMetoder.readFromFileToArray(filNamnA, a);

	BufferedReader stdin = new BufferedReader(new InputStreamReader
	    (System.in));

	System.out.print("Ge hit ");
	eanKod=stdin.readLine();
	sokt.setEanKod(eanKod);

	svar=LabMetoder.binarySearch(sokt, a, n);

	if (svar) 
	    System.out.println("Tjohoo");
	else 
	    System.out.println("gaaaay");
    }
}
