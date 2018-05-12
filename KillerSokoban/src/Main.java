import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Beolvas b = new Beolvas("prebuilt1.xml");

		ArrayList<String> jatekos = new ArrayList<String>();
		jatekos.add("Peti");
		jatekos.add("Bali");
		Jatek j = new Jatek(b.Beolvasas(), jatekos);
		j.Kor();
	}
}
