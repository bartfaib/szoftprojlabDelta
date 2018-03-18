import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teszt {
	
	private static final Mezo NULL = null;
	//A fo menuvel kapcsolatos kiirasok
	public void tesztMainMenu(){
		System.out.println("Udvozol a Killer sokoban tesztprogramja");
		System.out.println();
		System.out.println("Kerlek add meg azt a szamot ami az altalad valasztott tesztesetet jelzi");
		System.out.println();
		System.out.println("1. Munkas ures mezore leptetes");
		System.out.println();
		System.out.println("2. Lada eltolasa");
		System.out.println();
		System.out.println("3. Lyukba lepes");
		System.out.println();
		System.out.println("4. Munkas falnak lep");
		System.out.println();
		System.out.println("5. Cel mezore lepes");
		System.out.println();
		System.out.println("6. Masik munkas eltolasa");
		System.out.println();
		System.out.println("7. Kapcsolora lepes");
		System.out.println();
		System.out.println("8. Osszetetteb esetek");
		System.out.println();
		System.out.println("9. Kilepes");
	}
	
	//LAda eltolassal kapcsolatos Kiirasok
	private void tesztketto(){
		System.out.println("Lada tolasakor letrejovo esetek almenuje");
		System.out.println("Kerlek add meg a kivalasztani kivant opciot a megfelelo szammal");
		System.out.println();
		System.out.println("1. Lada eltolasa ures mezore");
		System.out.println();
		System.out.println("2. Lada eltolasa lyukra");
		System.out.println();
		System.out.println("3. Lada falnak tolasa");
		System.out.println();
		System.out.println("4. Lada celteruletre tolasa");
		System.out.println();
		System.out.println("5. Lada munkasra tolasa");
		System.out.println();
		System.out.println("6. Lada eltolasa kapcsolora");
		System.out.println();
		System.out.println("7. visza");
	}
	
	//Munkas eltolassal kapcsolatos kiirasok
	private void teszthat(){
		System.out.println("Masik munkas eltolasa eset almenuje");
		System.out.println("Kerlek add meg a kivalasztani kivant opciot a megfelelo szammal");
		System.out.println();
		System.out.println("1. Masik munkas ures mezore tolasa");
		System.out.println();
		System.out.println("2. Masik munkas falnak tolasa");
		System.out.println();
		System.out.println("3. Masik munkas nyitott lyukba tolasa");
		System.out.println();
		System.out.println("4. visza");
	}
	
	//Oszetetteb esetekkel kapcsolatos kiirasok
	private void tesztnyolc(){
		System.out.println("Oszetettebb esetek almenuje");
		System.out.println("Kerlek add meg a kivalasztani kivant opciot a megfelelo szammal");
		System.out.println();
		System.out.println("1. Munkás mozgatás a következő láncban: Munkás->láda->munkás->láda->fal");
		System.out.println();
		System.out.println("2. Munkás mozgatás a következő láncban:Munkás->láda->munkás->láda->cél");
		System.out.println();
		System.out.println("3. visza");
	}
	
	//Input beolvasasa konzolrol
	private int input(){
		Scanner input = new Scanner(System.in);
		
		int number;
		
		number = input.nextInt();
		input.close();
		return number;
	}
	
	//Munkas ures mezore lep teszt eset
	private void MunkasUresMezoreLep(){
		List<Mezo> szomsz = new ArrayList<>();
		szomsz.add(NULL);
		Mezo m1 = new Mezo(szomsz);
		szomsz.add(m1);
		
		Mezo m0 = new Mezo(szomsz);
		Munkas m = new Munkas("munkas",m0);
		
		Irany i = Irany.JOBBRA;
		
		m.Mozog(i);
	}
	/*
	//Lada ures mezore tolasa
	private void ladaEltolasaUresMezore(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Mezo m2 = new Mezo();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);
	}
	
	//Lada lyukra tolasa
	private void LadaEltolasaLyukra(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Lyuk ly = new Lyuk();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);
	}
	
	//Lada falnak tolasa
	private void ldaFalnakTolasa(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Fal f = new Fal();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Lada celteruletre tolasa
	private void ladaCelteruletreTolasa(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Cel c = new Cel();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Lada tolasa munkasra
	private void ladaTolasaMunkasra(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Mezo m2 = new Mezo();
		Munkas mu = new Munkas();
		Mezo m3 = new Mezo();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Lada tolasa kapcsolora
	private void ladaTolasaKapcsolora(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Kapcsolo k = new Kapcsolo();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Lada eltolasa teszteset menu
	private void ladaEltolasa(){
		while(true){
			tesztketto();
			
			switch(input()){
			
			case 1: 
				ladaEltolasaUresMezore();
			break;			
			
			case 2: 
				LadaEltolasaLyukra();
			break;	
			
			case 3: 
				ldaFalnakTolasa();
			break;
			
			case 4: 
				ladaCelteruletreTolasa();
			break;
			
			case 5: 
				ladaTolasaMunkasra();
			break;
			
			case 6: 
				ladaTolasaKapcsolora();
			break;	
			
			case 7: 
				return;
			
			default:
				
			break;
			}
		}
	}
	
	//MUnkas lyukba lep
	private void lyukbaLepes(){
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Lyuk ly = new Lyuk();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Munkas falnak lep
	private void munkasFalnakLep(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Fal f = new Fal();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Munkas celteruletre lep
	private void munkasCelteruletreLEp(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Fal f = new Fal();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Masik munkas ures mezore tolasa
	private void masikMunkasUresMezoreTolasa(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Munkas mb = new Munkas();
		Mezo m2 = new Mezo();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Masik munkas falnak tolasa	
	private void masikMunkasFalnakTolasa(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Munkas mb = new Munkas();
		Fal f = new Fal();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Masik munkas ures mezore tolasa
	private void masikMunkasLyukbaTolasa(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Munkas mb = new Munkas();
		Lyuk ly = new Lyuk();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	
	//Masik munkas eltolasa
	private void masikMunkasEltolasa(){
		while(true){
			teszthat();
			
			switch(input()){
			
			case 1: 
				masikMunkasUresMezoreTolasa();
			break;			
			
			case 2: 
				masikMunkasFalnakTolasa();
			break;	
			
			case 3: 
				masikMunkasLyukbaTolasa();
			break;
			
			case 4: 
				return;
				
			default:
				
			break;
			}
		}
	}
	
	//Munkas Kapcsolora lep
	private void munkasKapcsoloraLep(){
		//Palya mezok munkasok lada inicializalasa
		Munkas m = new Munkas();
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Kapcsolo k = new Kapcsolo();
		
		Irany i = Irany.Jobbra;
		
		m.Mozog(i);	
	}
	*/
	//Fo teszt fuggveny ezt hivja meg a main fuggveny
	public void tesztFG(){
		
		while(true){
			tesztMainMenu();
			
			switch(input()){
			
			case 1: 
				MunkasUresMezoreLep();
			break;			
			
			case 2: 
				//ladaEltolasa();
			break;	
			
			case 3: 
				//lyukbaLepes();
			break;
			
			case 4: 
				////munkasFalnakLep();
			break;
			
			case 5: 
				//munkasCelteruletreLEp();
			break;
			
			case 6: 
				//masikMunkasEltolasa();
			break;
			
			case 7: 
				//munkasKapcsoloraLep();
			break;
			
			case 9: 
				System.exit(0);
			break;
			
			default:
				
			break;
			}
		}
	}
}
