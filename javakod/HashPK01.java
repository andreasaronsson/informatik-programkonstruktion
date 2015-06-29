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
    public Artikel get(String key);
    public Artikel put(String key, Artikel value);
    public Artikel remove(String key);
    public int size();
}

