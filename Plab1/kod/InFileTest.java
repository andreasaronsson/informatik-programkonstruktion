/*
 * testkuk
 *
 */

import java.io.*;

public class InFileTest {
    public static void main (String [] args) throws IOException {

	boolean svar;
	String eanKod, filnamn = "Artikel.txt";
	Artikel artikel;

	File fin = new File(filnamn);
	BufferedReader stdin = new BufferedReader(new InputStreamReader
	    (System.in));

	System.out.print("Ge hit ");
	eanKod=stdin.readLine();
	artikel = new Artikel();
	artikel.setEanKod(eanKod);
	svar=LabMetoder.existsInFile(fin, artikel);

	if (svar) 
	    System.out.println("Tjohoo");
	else 
	    System.out.println("gaaaay");
    }
}
