import java.util.*;
public class RollObj {
	public static void main(String []args) {
		long start = Calendar.getInstance().getTimeInMillis();
		Iobjekt detta = new Iobjekt();
		long i=0;
		while(i<100000000){
			detta.get();
			i++;
		}
		//System.out.println(detta.skr());
		System.out.println(Calendar.getInstance().getTimeInMillis() - start);
	}
}
class Iobjekt {
	private long f;
	public Iobjekt(){
		f=0;
	}
	public void get(){
		f++;
	}
	public long skr(){
		return f;
	}
}
