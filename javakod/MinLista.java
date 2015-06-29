/**
 *  En l�nkad lista
 *  G�teborg 2001 12 07  Andreas Aronsson, Franz H�nel; pk01-14
 *  @author    Franz&Aron
 *  @version   1.1
 *
 */

public class MinLista implements ListaPK01 {


    private ArtikelNod next, lista, current, artikelNod;
    /**
     * Metod f�r att skapa lista
     *
     */
    public void MinLista() {
	lista = null;
    }
    /**
     * Metod f�r att l�gga till artikelobjekt
     * p� vald position
     * @param index int
     * @param artikel Artikel
     * @throws exception IndexOutOfBoundsException
     *
     */
    public void add(int index, Artikel element)
	              throws IndexOutOfBoundsException {
	current=lista;
	for (int i=0;i<index-1;i++) 
	    current=current.getNext();
	artikelNod=new ArtikelNod(element);
	if (index>0){
	    artikelNod.setNext(current.getNext());
	    current.setNext(artikelNod);
	}
	else {
	    artikelNod.setNext(current);
	    lista=artikelNod;
	}
    }
    /**
     * Metod f�r att l�gga till artikelobjekt i slutet
     * @param artikel Artikel
     *
     */
    public void add(Artikel element) {
	artikelNod=new ArtikelNod(element);
	if (lista == null)
	    lista=artikelNod;
	else {
	    current=lista;
	    while (current.getNext()!=null)
		current = current.getNext();
	    current.setNext(artikelNod);
	}
    }
    /**
     * Metod f�r att t�mma lista
     *
     */
    public void clear() {
	lista=null;
    }
    /**
     * Metod f�r att h�mta artikel fr�n position
     * @param index int
     * @return artikel Artikel
     * @throws exception IndexOutOfBoundsException
     *
     */
    public Artikel get(int index)throws IndexOutOfBoundsException {
	current=lista;
	if (lista==null)
	    return current.getElement();
	for (int i=0;i<index;i++) 
	    current=current.getNext();
	return current.getElement();
    }
    /**
     * Metod f�r att h�mta position f�r vald artikel
     * @param artikel Artikel
     * @return index int
     *
     */
    public int getPosition(Artikel element) {
	current=lista;
	int position=0;
	if (lista==null)
	    return 0;
	while (current.getNext()!=null &&
              ! current.getElement().getEanKod().equals(element.getEanKod())) {
	    current=current.getNext();
	    position++;
	}
	if (current.getElement().getEanKod().equals(element.getEanKod()))
	    return position;
	else 
	    return -1;
    }
    /**
     * Metod f�r att h�mta position f�r vald eankod
     * @param eankod String
     * @return index int
     *
     */
    public int getIndexFromEanKod(String eanKod) {
	current=lista;
	int index=0;
	while (current!=null && 
	       eanKod.compareTo(current.getElement().getEanKod())>0) {
	    current=current.getNext();
	    index++;
	}
	if (current==null)
	    index=-1;
	return index;
    }
    /**
     * Metod f�r att avg�ra om listan �r tom
     * @return value boolean
     *
     */
    public boolean isEmpty() {
	if (lista==null)
	    return true;
	else 
	    return false;
    }
    /**
     * Metod f�r att plock bort artiekl fr�n vald position
     * @param index int
     * @return artikel Artikel
     * @throws exception IndexOutOfBoundsException
     *
     */
    public Artikel remove(int index) throws IndexOutOfBoundsException{   
	Artikel retur;

	current=lista;
	if (current==null) {
	    String illa="Listan var tom";
	    Artikel felmedd=new Artikel(illa, 0);
	    return felmedd;
	}
	for (int i=0;i<index-1;i++)
	    current=current.getNext();
	retur=current.getNext().getElement();
	current.setNext(current.getNext().getNext());
	return retur;
    }
    /**
     * Metod f�r att avg�ra storlek p� listan
     * @return storlek int
     *
     */
    public int size() {
	int storlek=0;
	current=lista;
	while(current!=null){
	    current=current.getNext();
	    storlek++;
	}
	return storlek;
    }
}//slut MinLista

