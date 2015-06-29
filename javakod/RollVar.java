import java.util.*;
public class RollVar {
	public static void main(String []args) {
		long i = 0;
		long f = 0;
		long start = Calendar.getInstance().getTimeInMillis();
		while(i<100000000){
			//	f=metod(f);
			f++;
			i++;
		}
		//System.out.println(f);
		System.out.println(Calendar.getInstance().getTimeInMillis() - start);
	}
	static long metod(long k){
		k++;
		return k;
	}
}
