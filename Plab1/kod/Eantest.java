/*
 * testkuk
 *
 */

import java.io.*;

public class Eantest {
    public static void main (String [] args) throws IOException {

	boolean svar;
	String eanKod;

	BufferedReader stdin = new BufferedReader(new InputStreamReader
	    (System.in));

	System.out.print("Ge hit ");
	eanKod=stdin.readLine();
	svar=LabMetoder.trueEan(eanKod);

	if (svar) 
	    System.out.println("Tjohoo");
	else 
	    System.out.println("gaaaay");
    }
}
