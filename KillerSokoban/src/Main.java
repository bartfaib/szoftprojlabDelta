import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
		Mezo m0 = new Mezo();	
		Fal m1 = new Fal();
		Mezo m2 = new Mezo();
		Lyuk m3 = new Lyuk();
    	ArrayList<Mezo> mezok = new ArrayList<Mezo>();
    	mezok.add(m0);
    	mezok.add(m1);
    	mezok.add(m2);
    	mezok.add(m3);
    	ArrayList<String> jatekos= new ArrayList<String>();
    	jatekos.add("peti");
    	jatekos.add("Bali");
    	Jatek j = new Jatek(mezok, jatekos);
    	j.Kor();
    }
}
