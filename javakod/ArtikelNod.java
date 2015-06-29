/**
 *  2001 12 10 ArtikelNod
 *  ArtikelNod har en konstruktor som skapar nya noder med ett objket 
 *  som parameter
 *  Den har dessutom get- och setmetoder
 *  Andreas Aronsson, pk01-14, s01aron
 *  Franz Hänel, pk01-26, s01franz
 *  @author Aron&Franz
 *  @version 1.1
 *
 */
public class ArtikelNod {

    private ArtikelNod  next;
    private Artikel element;
    /**
     * Konstruktor för klassen
     * @param   nyElement   ett nytt artikelobjekt att referera till
     *
     */
    public ArtikelNod(Artikel nyElement) {
	element=nyElement;
	next=null;
    }
    /**
     * Returnerar en referens till nästa artikel i listan.   
     * @return  next  nästa nod i listan
     *
     */
    public ArtikelNod getNext () {
        return next;
    }   
    /**
     * Sätter referensen till nästa artikel i listan.   
     * @param nextArtikelNod ArtikelNod
     *
     */
    public void setNext (ArtikelNod nextArtikelNod) {
        next = nextArtikelNod;
    }  
    /**
     * Sätter ny elementreferens
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
