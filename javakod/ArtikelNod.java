/**
 *  2001 12 10 ArtikelNod
 *  ArtikelNod har en konstruktor som skapar nya noder med ett objket 
 *  som parameter
 *  Den har dessutom get- och setmetoder
 *  Andreas Aronsson, pk01-14, s01aron
 *  Franz H�nel, pk01-26, s01franz
 *  @author Aron&Franz
 *  @version 1.1
 *
 */
public class ArtikelNod {

    private ArtikelNod  next;
    private Artikel element;
    /**
     * Konstruktor f�r klassen
     * @param   nyElement   ett nytt artikelobjekt att referera till
     *
     */
    public ArtikelNod(Artikel nyElement) {
	element=nyElement;
	next=null;
    }
    /**
     * Returnerar en referens till n�sta artikel i listan.   
     * @return  next  n�sta nod i listan
     *
     */
    public ArtikelNod getNext () {
        return next;
    }   
    /**
     * S�tter referensen till n�sta artikel i listan.   
     * @param nextArtikelNod ArtikelNod
     *
     */
    public void setNext (ArtikelNod nextArtikelNod) {
        next = nextArtikelNod;
    }  
    /**
     * S�tter ny elementreferens
     * @param nyElement Artikel
     *
     */
    public void setElement(Artikel nyElement) {
	element=nyElement;
    }
    /**
     *  Returnerar elementet som noden refererar till
     *  @return  element Artikel
     *
     */
    public Artikel getElement() {
	return element;
    }
}
