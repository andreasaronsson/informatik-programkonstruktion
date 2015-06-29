/**
 *  Interface för vår hashtabell
 *
 *  Andreas Aronsson och Franz Hänel 2001 12 07 pk01-14
 *
 * @author  Franz&Aron
 * @version 1.1
 *
 */

public interface HashPK01{
    public void clear();
    public Artikel get(Artikel key);
    public Artikel put(Artikel key, Artikel value);
    public Artikel remove(Artikel key);
    public int size();
}

