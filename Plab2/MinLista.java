/**
 *  En l�nkad lista
 *  G�teborg 2001 12 07  Andreas Aronsson, Franz H�nel; pk01-14
 *
 *  @author    Franz&Aron
 *  @version   1.1
 *
 */

public class MinLista implements ListaPK01 {


    private static Artikel lista, next;

    public void ArtikelLista() {
	lista = null;
    }
    //  Returnerar en referens till n�sta artikel i listan.   
    public Artikel getNext () {
        return next;
    }   
    //  S�tter referensen till n�sta artikel i listan.   
    public void setNext (Artikel nextArtikel) {
        next = nextArtikel;
    } 
    public void add(int index, Artikel element)
	              throws ArrayIndexOutOfBoundsException {


    }
    public void add(Artikel element) {

	Artikel nyArtikel=new Artikel(element);
	Artikel current;

	if (lista == null)
	    lista=nyArtikel;
	else {
	    current=lista;
	    while (current.getNext() != null)
		current = current.getNext();
	    current.setNext(nyArtikel);
	}
    }	
    public void clear() {
    }
    public Artikel get(int index)throws ArrayIndexOutOfBoundsException {
	return;
    }
    public boolean isEmpty() {
	return;
    }
    public Artikel remove(int index)
	                          throws ArrayIndexOutOfBoundsException {
    }

    public int size() {
	return;
    }

}//slut MinLista

