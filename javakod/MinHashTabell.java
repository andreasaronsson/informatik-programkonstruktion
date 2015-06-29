import java.util.*;
import java.io.*;
import javax.swing.*;
/**
 *  MinHashTabell.java 2001 12 11
 *  Andreas Aronsson, pk01-14, s01aron
 *  Franz Hänel, pk01-26, s01franz
 *  @author Aron&Franz
 *  @version 1.1
 *
 */
public class MinHashTabell implements HashPK01 {

    private MinLista hashTabell[];
    private int kollision;
    /**
     *  En parameterlös konstruktor;
     *  skapar en array av typen MinLista
     *
     */
    public MinHashTabell() {
	hashTabell=new MinLista[100];
	kollision=0;
    }
    /**
     * En hashalgoritmmetod
     * @param key String
     * @return cen int
     *
     */
    public static int hashAlgoritm (String key) {
	int cen=0;

	cen=(int)(Double.parseDouble(key.substring(5, 12))/1.95463)%100;
	return cen;
    }
    /**
     *  Metod för att "tömma" listan
     *
     */
    public void clear() {
	hashTabell=new MinLista[100];
	kollision=0;
    }
    /**
     *  getmetod för att hämta den sökta artikeln
     *  @param key String
     *  @return önskadArtikel Artikel
     *
     */
    public Artikel get(String key) {
	int position=hashAlgoritm(key), index=0;
	Artikel önskadArtikel=new Artikel();
	önskadArtikel.setEanKod(key);
	
	if (hashTabell[position]==null 
	    ||hashTabell[position].getPosition(önskadArtikel)==-1) {
	    önskadArtikel.setEanKod("");
	}
	else {
	    index=hashTabell[position].getPosition(önskadArtikel);
	    önskadArtikel=hashTabell[position].get(index);
	}
	return önskadArtikel;
    }
    /**
     * getmetod för att hämta objekt på givet index
     * @param index int
     * @return hashTabell[index] MinLista
     *
     */
    public MinLista get(int index) {
	return hashTabell[index];
    }
    /**
     *  putmetod för att lägga till ett objekt
     *  @param key String
     *  @param value Artikel
     *  @return gammalArtikel Artikel
     *
     */
    public Artikel put(String key, Artikel value) {
	int position=hashAlgoritm(key), index=0;
	Artikel gammalArtikel=new Artikel();
	if(hashTabell[position]==null) {
	    MinLista nyLista=new MinLista();
	    hashTabell[position]=nyLista;
	    nyLista.add(value);
	}
	else {
	    System.out.println("En kollision har skett!");
	    kollision++;
	    hashTabell[position].add(value);
	    index=hashTabell[position].getIndexFromEanKod(key);
	    System.out.println(kollision);
	    gammalArtikel=hashTabell[position].get(index-1);
	    System.out.println(value.getVaruNamn()+" Skriver förbi "
			       +gammalArtikel.getVaruNamn());
	}
	return gammalArtikel;
    }
    /**
     * Metod för att ta bort ett objekt
     * @param key String
     * @return önskadArtikel Artikel
     *
     */
    public Artikel remove(String key) {
	int position=hashAlgoritm(key);
	Artikel önskadArtikel=new Artikel();
	önskadArtikel.setEanKod(key);
	if (hashTabell[position]==null
	    ||hashTabell[position].getPosition(önskadArtikel)==-1) {
	}
	else 
	    önskadArtikel=hashTabell[position].get
                       (hashTabell[position].getPosition(önskadArtikel));

	return önskadArtikel;
    }
    /**
     * Metod som returnerar storleken på tabellen
     * @return storlek int
     *
     */
    public int size() {
	int storlek=0;
	for (int i=0;i<100;i++) 
	    if (hashTabell[i]!=null) 
		storlek=storlek+hashTabell[i].size();
	return storlek;
    }
}
	                    
