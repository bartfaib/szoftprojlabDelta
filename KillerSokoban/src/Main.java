import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
	/*	Mezo m0 = new Mezo();	
		Fal m1 = new Fal();
		Mezo m2 = new Mezo();
		Lyuk m3 = new Lyuk();
		m0.setSzomszed(Irany.JOBBRA, m1);
		
		
    	ArrayList<Mezo> mezok = new ArrayList<Mezo>();
    	mezok.add(m0);
    	mezok.add(m1);
    	mezok.add(m2);
    	mezok.add(m3);
    	ArrayList<String> jatekos= new ArrayList<String>();
    	jatekos.add("peti");
    	jatekos.add("Bali");
    	Jatek j = new Jatek(mezok, jatekos);
    	j.Kor();*/
    	
        /*Teszt t = new Teszt();
        try {
     	t.tesztFG();
     	}
     	catch (Exception e) {}*/
    	Beolvas b = new Beolvas("prebuilt1.xml");
    	ArrayList<String> jatekos= new ArrayList<String>();
    	jatekos.add("peti");
    	jatekos.add("Bali");
    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	j.Kor();
    }
}
