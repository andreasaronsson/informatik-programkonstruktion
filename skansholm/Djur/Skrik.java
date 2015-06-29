public class Skrik {
	public static void main(String [] args){
		Djur[] skock=new Djur[2];
		Hund fido=new Hund();
		Fink piip=new Fink();
		skock[0]=fido;
		skock[1]=piip;

		for (int i=0;i<skock.length;i++) 
			System.out.println(skock[i].tuta());

	}
}
