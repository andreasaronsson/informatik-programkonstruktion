import java.io.*;
public class Raknare {
	private int högsta=Integer.MAX_VALUE, lägsta=Integer.MIN_VALUE, startvärde;

	public Raknare() {}
	public Raknare(int n) {
		startvärde=n;
	}
	public Raknare(int h, int l, int n) {
		högsta=n;
		lägsta=l;
		startvärde=n;
	}
	public void setHögsta(int h) {
		högsta=h;
	} 
	public void setLägsta(int l) {
		lägsta=l;
	}
	public void setStart(int s) {
		startvärde=s;
	}
	public void upp() {
		if (startvärde<Integer.MAX_VALUE)
			startvärde+=1;
		else {
			System.out.println("sug");
			System.exit(0);
		}
	}
	public void ner() {
		if (startvärde>Integer.MIN_VALUE)
			startvärde-=1;
		else {
			System.out.println("sug");
			System.exit(0);
		}
	}
	public int getVärde() {
		return startvärde;
	}
	public static void main(String [] args){
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		Raknare raknare=new Raknare();
		try {
			System.out.print("Ange startvärde: ");
			raknare.setStart(Integer.parseInt(stdin.readLine()));
			System.out.print("Vill du ange gränsvärden? ");
			String val=stdin.readLine();
			if (val.equals("j")) {
				System.out.print("Ange högsta: ");
				if(stdin.readLine()!="")
					raknare.setHögsta(Integer.parseInt(stdin.readLine()));
				System.out.print("Ange lägsta: ");
				if (stdin.readLine()!="")
					raknare.setLägsta(Integer.parseInt(stdin.readLine()));
			}
			while (true) {
				System.out.println("Upp eller ner? ");
				val=stdin.readLine();
				if (val.equalsIgnoreCase("upp"))
					while (true) {
						System.out.println(raknare.getVärde());
						raknare.upp();
					}
				if (val.equalsIgnoreCase("ner"))
					while (true) {
						System.out.println(raknare.getVärde());
						raknare.ner();
					}
			}
		}
		catch (IOException e) {
			System.out.println("Anus");
		}
	}
}
