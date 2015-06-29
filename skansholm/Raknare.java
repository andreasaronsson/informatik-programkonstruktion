import java.io.*;
public class Raknare {
	private int h�gsta=Integer.MAX_VALUE, l�gsta=Integer.MIN_VALUE, startv�rde;

	public Raknare() {}
	public Raknare(int n) {
		startv�rde=n;
	}
	public Raknare(int h, int l, int n) {
		h�gsta=n;
		l�gsta=l;
		startv�rde=n;
	}
	public void setH�gsta(int h) {
		h�gsta=h;
	} 
	public void setL�gsta(int l) {
		l�gsta=l;
	}
	public void setStart(int s) {
		startv�rde=s;
	}
	public void upp() {
		if (startv�rde<Integer.MAX_VALUE)
			startv�rde+=1;
		else {
			System.out.println("sug");
			System.exit(0);
		}
	}
	public void ner() {
		if (startv�rde>Integer.MIN_VALUE)
			startv�rde-=1;
		else {
			System.out.println("sug");
			System.exit(0);
		}
	}
	public int getV�rde() {
		return startv�rde;
	}
	public static void main(String [] args){
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		Raknare raknare=new Raknare();
		try {
			System.out.print("Ange startv�rde: ");
			raknare.setStart(Integer.parseInt(stdin.readLine()));
			System.out.print("Vill du ange gr�nsv�rden? ");
			String val=stdin.readLine();
			if (val.equals("j")) {
				System.out.print("Ange h�gsta: ");
				if(stdin.readLine()!="")
					raknare.setH�gsta(Integer.parseInt(stdin.readLine()));
				System.out.print("Ange l�gsta: ");
				if (stdin.readLine()!="")
					raknare.setL�gsta(Integer.parseInt(stdin.readLine()));
			}
			while (true) {
				System.out.println("Upp eller ner? ");
				val=stdin.readLine();
				if (val.equalsIgnoreCase("upp"))
					while (true) {
						System.out.println(raknare.getV�rde());
						raknare.upp();
					}
				if (val.equalsIgnoreCase("ner"))
					while (true) {
						System.out.println(raknare.getV�rde());
						raknare.ner();
					}
			}
		}
		catch (IOException e) {
			System.out.println("Anus");
		}
	}
}
