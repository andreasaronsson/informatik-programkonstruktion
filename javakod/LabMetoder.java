import java.io.*;
import java.util.*;
import java.text.ParseException;
import javax.swing.*;
/**
 *  Andreas Aronsson, pk01-14, s01aron
 *  Franz H�nel, pk01-26, s01aron
 *  2001 11 06 och fram�t
 *  Klassen Mina metoder inneh�ller metoder f�r att l�sa in ett filnamn, 
 *  skapa en ny fil, ta reda p� eankoden f�r en inleverans, 
 *  l�sa in en fil till en array, ta reda p� l�ngden av en fil, 
 *  tv� metoder f�r att sortera en array, avg�ra om en eankod uppfyller
 *  de kriterier som �r satta (13 tecken, endast siffror), och en metod
 *  f�r att ta reda p� om en fil inneh�ller en given eankod 
 *  Alla metoder �r static-metoder dvs de anropas via klassnamnet.
 *  @author Andreas Aronsson
 *  @version 1.1
 */
public class LabMetoder  {
    /**
     *  Metod f�r l�sning fr�n fil till hashtabell av klassen MinHashTabell
     *  @param   filNamn    filnamn
     *  @param   hashTabell    given(godtycklig)hashtabell
     *  
     */
    public static void readFileToHash(File filNamn,MinHashTabell hashTabell){
        String enRad;   //en av posterna
	Artikel artikel;
	try {
	    BufferedReader fin=new BufferedReader(new FileReader(filNamn));   
	    enRad=fin.readLine();
	    while (enRad != null) {
		artikel=new Artikel(enRad);
		artikel=hashTabell.put(artikel.getEanKod(), artikel);
		enRad=fin.readLine();
	    }
	    fin.close();
	}
	catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog
	      (null, filNamn, "Filen finns inte.", JOptionPane.ERROR_MESSAGE);
	}
	catch (IOException e) {
	    JOptionPane.showMessageDialog
	      (null, filNamn, "Fel vid l�sning av data fr�n fil.",
	       JOptionPane.ERROR_MESSAGE);
	}
    }// slut  readFileToHash
    /**
     *  Metod f�r l�sning fr�n fil till lista av klassen MinLista 
     *  @param   filNamnArt    filnamn
     *  @return   nyLista    ger en ny lista
     */
    public static MinLista readFromFileToList(File filNamnArt) {
	    String artRad;
	    int listL�ngd=0;
	    Artikel artikel;
	    MinLista nyLista=new MinLista();
	try {
	    BufferedReader artFilIn=new BufferedReader
		(new FileReader(filNamnArt));
	    artRad=artFilIn.readLine();

	    while (artRad!=null) {
		artikel=new Artikel(artRad);
		listL�ngd++;
		nyLista.add(artikel);
		artRad=artFilIn.readLine();
	    }
	    artFilIn.close();
	}
	catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog
		(null, filNamnArt, "Fel vid l�sning av data fr�n fil.",
		 JOptionPane.ERROR_MESSAGE);
	    System.exit(0);
	}
	catch (IOException e) {
	    JOptionPane.showMessageDialog
	      (null, filNamnArt, "IO-fel.",
	       JOptionPane.ERROR_MESSAGE);
	    System.exit(0);
	}
	return nyLista;
    }
    /**
     *  Metod f�r l�sning fr�n lista till fil  
     *  @param   filNamnArt    filnamn
     *  @param   lista    listan som skall skrivas
     */
    public static void writeFromListToFile(MinLista lista, File filNamnArt){
	try {
	PrintWriter artFilUt=new PrintWriter(new BufferedWriter
	    (new FileWriter(filNamnArt)));
	int l�ngd=lista.size();
	for (int i=0;i<l�ngd;i++)
	    artFilUt.println(lista.get(i).getRow());
	artFilUt.close();
	}
	catch (FileNotFoundException e) {
	    JOptionPane.showMessageDialog
	      (null, filNamnArt, "Filen finns inte",
	       JOptionPane.ERROR_MESSAGE);
	    System.exit(0);
	}
	catch (IOException e) {
	    JOptionPane.showMessageDialog
		(null, filNamnArt, "IO-fel.",
		 JOptionPane.ERROR_MESSAGE);
	    System.exit(0);
	}
    }//slut writeFromListToFile

    public static void writeHashToFile(MinHashTabell hashTabell, File utFil){

	try {
	    PrintWriter fut = new PrintWriter(new BufferedWriter
		(new FileWriter(utFil))); 
	    //hashtabell till fil
	    int l=hashTabell.size();
	    Artikel [] a=new Artikel[l];
	    Artikel artikel;
	    int index=0;
	    for (int j = 0;j<100; j++) {
		if (hashTabell.get(j)!=null) {
		    for (int k=0;k<hashTabell.get(j).size();k++) {
			artikel=hashTabell.get(j).get(k);
			a[index]=artikel;
			index++;
		    }
		}
	    }//slut for hashToArray
	    LabMetoder.kSelectionSort(a, l);
	    for (int i=0;i<l;i++) 
		fut.println(a[i].getRow());
	    fut.close();
	}
	catch (IOException e) {
	    JOptionPane.showMessageDialog
	      (null, utFil, "Fel vid uppdatering av varuregister.",
	       JOptionPane.ERROR_MESSAGE);
	}
    }
    /**
     *  Metod f�r sortering av array
     *  @param    a    artikelarray
     *  @param    n    l�ngd p� arrayen
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
     *  Metod f�r sortering av array
     *  @param    a    artikelarray
     *  @param    n    l�ngd p� arrayen
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
     *  Metod f�r att avg�ra om en eankod �r riktig
     *  @param    eanKod    eankod
     *  @return   boolen isEan    �r detta en giltig eanKod?     
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
     *   Bin�rs�kning f�r array av typen artikel
     *   @param    sokt    objekt
     *   @param    a       array av typen artikel
     *   @param    n       l�ngden p� artikeln
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
            if (((a[position]).getEanKod()).compareTo(sokt.getEanKod())<0) {
		forsta = position + 1;  
		position = (forsta + sista)/2;
	    }
            if (((a[position]).getEanKod()).compareTo(sokt.getEanKod())>0) {
		sista = position - 1;    
		position = (forsta + sista) / 2;
	    }
        }
        if (n>0&&((a[position]).getEanKod()).compareTo(sokt.getEanKod())==0) {
	    returV=position;
	    return returV;
	}
	else 
	    return -1;
    }//slut binarySearch
    public static K�p[] kWriter (K�pVector k, MinHashTabell hashTabell) {

	K�p[] kund=new K�p[k.size()];
	K�p k�p;
	Artikel tempobjekt, artikel;
	int ant = 0, index = 0;
	for(int i=0; i<k.size(); i++) {
	    tempobjekt=hashTabell.get(k.elementAt(i).getEanKod());
	    artikel=new Artikel(tempobjekt.getRow());
	    index=LabMetoder.binarySearch(artikel, kund, ant);
	    if (index<0) {
		k�p=new K�p();
		kund[ant]=k�p;
		k�p.setResten(artikel);
		kund[ant].setUtMgd(k.elementAt(i).getUtMgd());
		ant = ant + 1;
	    }
	    else {
		kund[index].setUtMgd(kund[index].getUtMgd()
				     +k.elementAt(i).getUtMgd());
	    }
	    LabMetoder.kSelectionSort(kund, ant);
	}
	LabMetoder.selectionSort(kund, ant);
	return kund;
    }
} // slut LabMetoder
