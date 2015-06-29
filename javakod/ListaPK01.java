/**
 *  Ett interface f�r en l�nkad lista
 *  G�teborg 2001 12 07 Andreas Aronsson och Franz H�nel pk01-14
 *  @author Franz och Andreas
 *  @version 1.1
 *
 */

public interface ListaPK01 {

    public void add(int index, Artikel element)
	    throws IndexOutOfBoundsException;
	

    public void add(Artikel element);
	
    public void clear();

    public Artikel get(int index)throws IndexOutOfBoundsException;

    public boolean isEmpty();

    public Artikel remove(int index)
		throws IndexOutOfBoundsException;

    public int size();

	    
}
