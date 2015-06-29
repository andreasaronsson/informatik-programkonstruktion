/**
 *  Ett interface för en länkad lista
 *  Göteborg 2001 12 07 Andreas Aronsson och Franz Hänel  pk01-14
 *  @author Franz och Andreas
 *  @version 1.1
 *
 */

public interface ListaPK01 {

    public void add(int index, Artikel element)
	    throws ArrayIndexOutOfBoundsException;
	

    public void add(Artikel element);
	
    public void clear();

    public Artikel get(int index)throws ArrayIndexOutOfBoundsException;

    public boolean isEmpty();

    public Artikel remove(int index)
		throws ArrayIndexOutOfBoundsException;

    public int size();

	    
}
