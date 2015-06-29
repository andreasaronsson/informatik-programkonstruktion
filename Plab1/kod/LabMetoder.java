/**
 *  Andreas Aronsson
 *  pk01-14
 *  2001 11 06 och framåt
 *  Klassen Mina metoder innehåller metoder för att läsa in ett filnamn, 
 *  skapa en ny fil, ta reda på eankoden för en inleverans, 
 *  läsa in en fil till en array, ta reda på längden av en fil, 
 *  två metoder för att sortera en array, avgöra om en eankod uppfyller
 *  de kriterier som är satta (13 tecken, endast siffror), och en metod
 *  för att ta reda på om en fil innehåller en given eankod 
 *  Alla metoder är static-metoder dvs de anropas via klassnamnet.
 *  @author Andreas Aronsson
 *  @version 1.1
 */
import java.io.*;
import java.util.*;
public class LabMetoder  {

    /**
     *  Metod för inläsning av fil med givet filnamn
     *  @param    inFilNamn    filnamn
     *  @return   filNamn    namn på filen
     */
    public static File inFilNamn(String ledtext) throws IOException   {
        File filNamn;
        BufferedReader stdin = new BufferedReader
	    (new InputStreamReader(System.in));
        System.out.print(ledtext);
        filNamn = new File(stdin.readLine());
        while ( ! filNamn.exists() )  {
            System.out.print("Den gubben går inte, en gång till...  ");
            filNamn = new File(stdin.readLine());
        }
        return filNamn;
    } // slut inFilNamn
    /**
     *  Metod för att skapa en fil med givet filnamn
     *  @param    utFilNamn    filnamn
     *  @return    filNamn    namn på ny fil
     */
    public static File utFilNamn(String ledtext) throws IOException {
	File filNamn;
	BufferedReader stdin = new BufferedReader
	    (new InputStreamReader(System.in));
	System.out.print(ledtext);
	filNamn = new File(stdin.readLine());
	while (filNamn.exists()) {
	    System.out.print("Sabba mina filer??? En gång till...  ");
            filNamn = new File(stdin.readLine());
	}
	return filNamn;
    }  // slut utFilNamn
    /**
     *  Metod för att ta reda på eankod på inleverans
     *  @param    bRad     rad i beställningsfil
     *  @return   eanKod    eanKod för en given rad
     */
    public static String inLeverans(String bRad) {
	String eanKod;
	double inMgd;
	StringTokenizer sT = new StringTokenizer(bRad);
	eanKod=sT.nextToken();
	inMgd=Double.parseDouble(sT.nextToken());
	return eanKod;
    }

    /**
     *  Metod för läsning från fil till array av klassen Artikel 
     *  @param   filNamn    filnamn
     *  @param   arr        given(godtycklig)array
     *  @return   integer ant    hur lång e filen?
     */
    public static int readFromFileToArray(File filNamn, Artikel[] arr) 
	throws IOException  {
        int ant;        // antal poster i filen
        String enRad;   //en av posterna
        BufferedReader fin = new BufferedReader (new FileReader(filNamn));  
        enRad=fin.readLine();
        ant = 0;        
        while (enRad != null) {
            arr[ant]=new Artikel(enRad);
            ant = ant + 1;
            enRad=fin.readLine();
        }
        fin.close();
        return ant;
    }// slut  readFromFileToArray
    /**
     *  Metod som returnerar längden på en fil
     *  @param    filNamn   filnamn
     *  @return   integer post   längd på en give fil
     */
    public static int parseFileLength(File filNamn) throws IOException {
	int post;
	String enRad;
	BufferedReader fin = new BufferedReader(new FileReader(filNamn));
	enRad=fin.readLine();
	post=0;
	while (enRad!=null) {
	    post++;
	    enRad=fin.readLine();
	}
	fin.close();
	return post;
    }//slut parseFileLength

    /**
     *  Metod för sortering av array
     *  @param    a    artikelarray
     *  @param    n    längd på arrayen
     *  
     */
    public static void selectionSort(Artikel[] a,int n)  {
        Artikel temp;
        int left, j, minst; 
        for (left =0; left < n-1; left++) {
            minst=left;
            for (j = left+1; j<n; j++) {                          
                if (a[j].getVaruNamn().compareTo(a[minst].getVaruNamn())<0) 
                    minst =j;
	    }
            temp=a[minst];
            a[minst]=a[left];
            a[left]=temp;
        }// slut for      
    }// slut selectionSort

    /**
     *  Metod för sortering av array
     *  @param    a    artikelarray
     *  @param    n    längd på arrayen
     *
     */
    public static void kSelectionSort(Artikel[] a,int n)  {
        Artikel temp;
        int left, j, minst; 
        for (left =0; left < n-1; left++) {
            minst=left;
            for (j = left+1; j<n; j++) {                          
                if (a[j].getEanKod().compareTo(a[minst].getEanKod())<0) 
                    minst =j;
	    }
            temp=a[minst];
            a[minst]=a[left];
            a[left]=temp;
        }// slut for      
    }// slut kSelectionSort


    /**
     *  Metod för att avgöra om en eankod är riktig
     *  @param    eanKod    eankod
     *  @return   boolen isEan    är detta en giltig eanKod?     
     */
    public static boolean trueEan (String eanKod) {
	boolean isEan=true;
	Artikel testobjekt;
	char a;
	if (eanKod.length()==13) {
	    for (int i=0;i<13;i++) {
		a=eanKod.charAt(i);
		if ((Character.isDigit(a))==false) {
		    isEan=false;
		}
	    }
	}
	else 
	    isEan=false;
	return isEan;
    }//slut trueEan 

    /**
     *  Metod för att avgöra om ett objekt finns i fil
     *  @param    filNamnA    filnamn
     *  @param    nyArtikel   objekt av typ artikel
     *  @return    boolen exists    finns denna artikel i filen?
     */
    public static boolean existsInFile (File filNamnA, Artikel nyArtikel) 
	throws IOException  {
	Artikel artikel;
	String enRad;
	boolean exists=false;
        BufferedReader fin = new BufferedReader (new FileReader(filNamnA));
	enRad=fin.readLine();
	while (enRad!=null) {
	    artikel=new Artikel(enRad);
	    if ((artikel.getEanKod().compareTo(nyArtikel.getEanKod()))==0)  {
		exists=true;
	    }
	    enRad=fin.readLine();
        }
        return exists;
    } // slut existsInFile

    /**
     *   Binärsökning för array av typen artikel
     *   @param    sokt    objekt
     *   @param    a       array av typen artikel
     *   @param    n       längden på artikeln
     *   @return    returnV eller -1  ger en pos. eller -1 om art inte finns
     */
    public static int binarySearch(Artikel sokt, Artikel[] a, int n) {
        int forsta, sista, position; // indexvariabler
	int returV;//returnerar indexposition
        forsta = 0;
        sista = n - 1;
        position = (forsta + sista)/2;

        while ((forsta < sista) && (((a[position]).getEanKod()).compareTo
				    (sokt.getEanKod()))!=0) {   
	    System.out.println("Scanning for product");
            if (((a[position]).getEanKod()).compareTo(sokt.getEanKod())<0) {
		forsta = position + 1;  
		position = (forsta + sista)/2;
	    }
            if (((a[position]).getEanKod()).compareTo(sokt.getEanKod())>0) {
		sista = position - 1;    
		position = (forsta + sista) / 2;
	    }
        }
        if (((a[position]).getEanKod()).compareTo(sokt.getEanKod())==0) {
	    returV=position;
	    return returV;
	}
	else 
	    return -1;
    }//slut binarySearch
    /**
     *  Metod för att "fläta ihop" två filer
     *  @param    inFil    originalfil
     *  @param    filUt    nyskapad fil som skall uppdatera org.
     *  
     */
    public static void fileMerge(File inFil, File filUt) throws IOException {

	String inRad, nyRad;
	Artikel artikel, nyArtikel;

	//ström öppnas till artikelfil
	BufferedReader fin = new BufferedReader
	    (new FileReader(inFil));
	//ström öppnas till kund.txt
	BufferedReader fut = new BufferedReader
	    (new FileReader(filUt));
	//tempfil skapas och ström till den öppnas
	File tempfil=new File("temp.txt");
	PrintWriter tmp = new PrintWriter(new BufferedWriter
	    (new FileWriter(tempfil)));
	//en rad läses från fil och obj. skapas
	inRad=fin.readLine();
	artikel=new Artikel(inRad);
	nyRad=fut.readLine();
	nyArtikel=new Artikel(nyRad);
	//nu vill vi fortsätta så länge rader finns i Art.fil
	//vi kör så länge nyean<de ean som finns  
	while ((nyArtikel.getEanKod().compareTo
		(artikel.getEanKod()))>0 && inRad!=null) {
	    tmp.println(artikel.getRow());
	    inRad=fin.readLine();
	    if (inRad!=null)
		artikel=new Artikel(inRad);
	    //slut while existerande ean kommer före i ordn.
	    //nya artiklar skrivs in
	    while ((nyArtikel.getEanKod().compareTo
		    (artikel.getEanKod()))<0 && nyRad!=null) {
		tmp.println(nyArtikel.getRow());
		nyRad=fut.readLine();
		if (nyRad!=null)
		    nyArtikel=new Artikel(nyRad);
	    }
	}
	//åsså sprytsar vi över resten
	while (inRad!=null) {
	    artikel=new Artikel(inRad);
	    tmp.println(artikel.getRow());
	    inRad=fin.readLine();
	}//slut while more rows
	fut.close();
	fin.close();
	tmp.close();
    }//slut fileMerge

} // slut LabMetoder
