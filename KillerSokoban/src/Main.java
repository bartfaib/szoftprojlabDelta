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
    	  		
    		
    		System.out.println("Udvozol a Killer sokoban tesztprogramja");
    		System.out.println("A szukseges parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next>\n");
    		System.out.println("A megfelelő szám megadásával tesztelheted az eseteket (1-9), 0=exit\n");
    		System.out.println("1-Maga a jatek a tobbi a teszteset\n");
    		System.out.println("A tesztesetek a 8-as dokumentum szerint vannak sorolva, továbbá az Exit parancs mindegyiknel ervenyes\n");
    		//Input beolvasasa konzolrol
    		int number=-1;
    		while (number!=0) { 
        		System.out.println("Adj meg egy szamot!:D");
    	    Scanner input = new Scanner(System.in);
    		number = input.nextInt();
    		System.out.println(number);
    		switch(number) {
    		case(1):{

        		System.out.println("2 JÁTÉKOS: Adj meg egy nevet\n");
    			Scanner inputname = new Scanner(System.in);
    				
    	    	
    	    	ArrayList<String> jatekos= new ArrayList<String>();
    	    	jatekos.add(inputname.next());
    	    	System.out.println("Most egy masikat :\n");
    	    	
    	    	inputname = new Scanner(System.in);
    	    	jatekos.add(inputname.next());
    	    	System.out.println("A jatek indul a parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next>\n");
    	    	Beolvas b = new Beolvas("prebuilt1.xml");
    	    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	    	j.Kor();
    	    	
    		}break;
    		case(2):{
        		System.out.println("Ladak tolasanak tiltasa TULSULY eseten");
    	    	ArrayList<String> jatekos= new ArrayList<String>();
    	    	jatekos.add("teszt2");
    	    	
    	    	System.out.println("A jatek indul a parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next>\n");
    	    	Beolvas b = new Beolvas("test1.xml");
    	    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	    	j.Kor();    
    			
    		}break;
    		case(3):{
        		System.out.println("Mez Lerakasa");
    	    	ArrayList<String> jatekos= new ArrayList<String>();
    	    	jatekos.add("teszt2");
    	    	
    	    	System.out.println("A jatek indul a parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next> <Exit> '<>'Jelek nélkül\n");
    	    	Beolvas b = new Beolvas("test2.xml");
    	    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	    	j.Kor();   
    		}break;
    		case(4):{
    			
        		System.out.println("Olajon tolás");
    	    	ArrayList<String> jatekos= new ArrayList<String>();
    	    	jatekos.add("teszt3");
    	    	
    	    	System.out.println("A jatek indul a parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next> <Exit> '<>'Jelek nélkül\n");
    	    	Beolvas b = new Beolvas("test3.xml");
    	    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	    	j.Kor(); 
    			
    		}break;
    		case(5):{
    			
        		System.out.println("Célba tolás");
    	    	ArrayList<String> jatekos= new ArrayList<String>();
    	    	jatekos.add("teszt4");
    	    	
    	    	System.out.println("A jatek indul a parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next> <Exit> '<>'Jelek nélkül\n");
    	    	Beolvas b = new Beolvas("test4.xml");
    	    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	    	j.Kor(); 
    			
    		}break;
    		case(6):{
    			
        		System.out.println("Lyukba tolás (Megjegyzés: A lyuk aktív állapotban van alapértelmezetten a tesztelés végett)");
    	    	ArrayList<String> jatekos= new ArrayList<String>();
    	    	jatekos.add("teszt5");
    	    	
    	    	System.out.println("A jatek indul a parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next> <Exit> '<>'Jelek nélkül\n");
    	    	Beolvas b = new Beolvas("test5.xml");
    	    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	    	j.Kor(); 
    			
    		}break;
    		case(7):{
        		System.out.println("Eredmény meghatározás");
    	    	ArrayList<String> jatekos= new ArrayList<String>();
    	    	jatekos.add("teszt6");
    	    	
    	    	System.out.println("A jatek indul a parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next> <Exit> '<>'Jelek nélkül\n");
    	    	Beolvas b = new Beolvas("test4.xml");
    	    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	    	j.Kor(); 
    			
    		}break;
    		case(8):{
        		System.out.println("Munkás Munkást tol");
    	    	ArrayList<String> jatekos= new ArrayList<String>();
    	    	jatekos.add("teszt7");
    	    	jatekos.add("teszt8");
    	    	System.out.println("A jatek indul a parancsok a kovetkezok: <tol w> <tol a> <tol s> <tol d> <addOlaj> <addMez> <next> <Exit> '<>'Jelek nélkül\n");
    	    	Beolvas b = new Beolvas("test7.xml");
    	    	Jatek j = new Jatek(b.Beolvas(), jatekos);
    	    	j.Kor(); 
    			
    		}break;
    		case(9):{
    	    	System.out.println("Egyéb TESZTESETEK\n");
    			Teszt t = new Teszt();
    	        try {
    	     	t.tesztFG();
    	     	}
    	     	catch (Exception e) {}
    			
    		}break;	
    		
    		
    		}

    	
    		}

    }
}
