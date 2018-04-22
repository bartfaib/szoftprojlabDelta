import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teszt {
	//A fo menuvel kapcsolatos kiirasok
	public void tesztMainMenu(){
		
		
		System.out.println("Udvozol a Killer sokoban tesztprogramja");
		System.out.println();
		System.out.println("Kerlek add meg azt a szamot ami az altalad valasztott tesztesetet jelzi");
		System.out.println("Megjegyzes: A tesztesetek kiirasa munkassal kezdodik, de a diagrammok nagyrésze szomszedlekerdezessel indul.");
		System.out.println("1. Munkas ures mezore leptetes");
		System.out.println("2. Lada eltolasa");
		System.out.println("3. Lyukba lepes");
		System.out.println("4. Munkas falnak lep");
		System.out.println("5. Cel mezore lepes");
		System.out.println("6. Masik munkas eltolasa");
		System.out.println("7. Kapcsolora lepes");
		System.out.println("8. Osszetetteb esetek");
		System.out.println("9. Kilepes");
	}
	
	//LAda eltolassal kapcsolatos Kiirasok
	private void tesztketto(){
		System.out.println();
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
		System.out.println();
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
		System.out.println();
		System.out.println("Oszetettebb esetek almenuje");
		System.out.println("Kerlek add meg a kivalasztani kivant opciot a megfelelo szammal");
		System.out.println();
		System.out.println("1. Munkas mozgatas a kovetkezo lancban: Munkas->lada->munkas->lada->fal");
		System.out.println();
		System.out.println("2. Munkas mozgatas a kovetkezo lancban:Munkas->lada->munkas->lada->cel");
		System.out.println();
		System.out.println("3. visza");
	}
	
	//Input beolvasasa konzolrol
	private int input(){
	    Scanner input = new Scanner(System.in);
		
		int number;
		
		number = input.nextInt();
		//input.close();
		return number;
	}
	
	//Munkas ures mezore lep teszt eset
	private void MunkasUresMezoreLep() throws FileNotFoundException, UnsupportedEncodingException{
		Mezo m1 = new Mezo();	
		Mezo m0 = new Mezo();
		Munkas m = new Munkas("kezo munkas",m0, true);
		m0.setSzomszed(Irany.JOBBRA, m1);
		m0.Add(m);
		
		Irany i = Irany.JOBBRA;
		
		m.Mozog(i);
		DrawToFile(m0, "teszt1.xml");
	}
	
	//Lada ures mezore tolasa
	private void ladaEltolasaUresMezore() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Mezo m2 = new Mezo();
		Munkas m = new Munkas("Kezdo munkas",m0, true);
		m0.setSzomszed(Irany.JOBBRA, m1);
		m1.setSzomszed(Irany.JOBBRA, m2);
		m1.setLada(l);
		l.setIndulo(m1);
		m0.setMunkas(m);
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		Irany i = Irany.JOBBRA;
		
		m.Mozog(i);
		DrawToFile(m0, "teszt2.xml");
	}
	
	//Lada lyukra tolasa
	private void LadaEltolasaLyukra() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Lyuk ly = new Lyuk();
		Munkas m = new Munkas("Kezdo munkas",m0, true);
		m0.setSzomszed(Irany.JOBBRA, m1);
		m0.setMunkas(m);
		m1.setSzomszed(Irany.JOBBRA, ly);
		m1.setLada(l);
		l.setIndulo(m1);
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt3.xml");
	}
	
	//Lada falnak tolasa
	private void ldaFalnakTolasa() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Fal f = new Fal();
		m0.setSzomszed(Irany.JOBBRA, m1);
		m1.Add(l);
		l.setIndulo(m1);
		m1.setSzomszed(Irany.JOBBRA, f);
		Munkas m = new Munkas("Kezdo munkas",m0, true);
		m0.Add(m);
		
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt4.xml");
	}
	
	//Lada celteruletre tolasa
	private void ladaCelteruletreTolasa() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Cel c = new Cel();
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.setSzomszed(Irany.JOBBRA, m1);
		m0.setMunkas(m);
		m1.setSzomszed(Irany.JOBBRA, c);
		m1.setLada(l);
		l.setIndulo(m1);
		c.setSzomszed(Irany.BALRA, m1);
		c.getLada();
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt5.xml");
	}
	
	//Lada tolasa munkasra
	private void ladaTolasaMunkasra() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Mezo m2 = new Mezo();
		Mezo m3 = new Mezo();
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.setSzomszed(Irany.JOBBRA, m1);
		m0.Add(m);
		m1.setSzomszed(Irany.JOBBRA, m2);
		m1.setLada(l);
		l.setIndulo(m1);
		m2.setSzomszed(Irany.JOBBRA, m3);
		Munkas mu = new Munkas("Munkas B",m2);
		m2.setMunkas(mu);
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt6.xml");
	}
	
	//Lada tolasa kapcsolora
	private void ladaTolasaKapcsolora() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l = new Lada();
		Kapcsolo k = new Kapcsolo();
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.setSzomszed(Irany.JOBBRA, m1);
		m0.Add(m);
		m1.setSzomszed(Irany.JOBBRA, k);
		m1.Add(l);
		l.setIndulo(m1);
		
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt7.xml");
	}
	
	//Lada eltolasa teszteset menu
	private void ladaEltolasa() throws FileNotFoundException, UnsupportedEncodingException{
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
	private void lyukbaLepes() throws FileNotFoundException, UnsupportedEncodingException{
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Lyuk ly = new Lyuk(true);
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.setSzomszed(Irany.JOBBRA, ly);
		m0.Add(m);
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt8.xml");
	}
	
	//Munkas falnak lep
	private void munkasFalnakLep() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Fal f = new Fal();
		Munkas m = new Munkas("Kezdo munkas",m0, true);
		m0.Add(m);
		m0.setSzomszed(Irany.JOBBRA, f);
		
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt9.xml");
	}
	
	//Munkas celteruletre lep
	private void munkasCelteruletreLEp() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Munkas celteruletre lep");
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Cel c = new Cel();
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.Add(m);
		m0.setSzomszed(Irany.JOBBRA, c);
		c.setSzomszed(Irany.BALRA, m0);
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt10.xml");
	}
	
	//Masik munkas ures mezore tolasa
	private void masikMunkasUresMezoreTolasa() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Mezo m2 = new Mezo();
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.setMunkas(m);
		m0.setSzomszed(Irany.JOBBRA, m1);
		Munkas mb = new Munkas("Munkas B",m1);
		m1.setMunkas(mb);
		m1.setSzomszed(Irany.JOBBRA, m2);
		
		
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt11.xml");
	}
	
	//Masik munkas falnak tolasa	
	private void masikMunkasFalnakTolasa() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Fal f = new Fal();
		Munkas m = new Munkas("Kezdo munkas",m0, true);
		m0.Add(m);
		m0.setSzomszed(Irany.JOBBRA, m1);
		Munkas mb = new Munkas("Munkas B",m1);
		m1.Add(mb);
		m1.setSzomszed(Irany.JOBBRA, f);
		
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt12.xml");
	}
	
	//Masik munkas lyukba tolasa
	private void masikMunkasLyukbaTolasa() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lyuk ly = new Lyuk(true);
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.Add(m);
		m0.setSzomszed(Irany.JOBBRA, m1);
		Munkas mb = new Munkas("Mnkas B",m1);
		m1.Add(mb);
		m1.setSzomszed(Irany.JOBBRA, ly);
		
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt13.xml");
	}
	
	//Masik munkas eltolasa
	private void masikMunkasEltolasa() throws FileNotFoundException, UnsupportedEncodingException{
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
	private void munkasKapcsoloraLep() throws FileNotFoundException, UnsupportedEncodingException{
		//Palya mezok munkasok lada inicializalasa
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Kapcsolo k = new Kapcsolo();
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.setMunkas(m);
		m0.setSzomszed(Irany.JOBBRA, k);
		
		Irany i = Irany.JOBBRA;
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(i);
		DrawToFile(m0, "teszt14.xml");
	}
	//Munkas->lada->munkas->lada->fal
	private void mlmlf() throws FileNotFoundException, UnsupportedEncodingException{
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l1 = new Lada();
		Mezo m2 = new Mezo();
		Mezo m3 = new Mezo();
		Lada l2 = new Lada();
		Fal f = new Fal();
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m0.setSzomszed(Irany.JOBBRA, m1);
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.setMunkas(m);
		m1.setSzomszed(Irany.JOBBRA, m2);
		m1.setLada(l1);
		l1.setIndulo(m1);
		m2.setSzomszed(Irany.JOBBRA, m3);
		Munkas mb = new Munkas("Munkas B",m2);
		m2.Add(mb);
		m3.setSzomszed(Irany.JOBBRA, f);
		m3.Add(l2);
		l2.setIndulo(m3);
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(Irany.JOBBRA);
		DrawToFile(m0, "teszt15.xml");
	}
	
	//Munkas->lada->munkas->lada->cel
	private void mlmlc() throws FileNotFoundException, UnsupportedEncodingException{
		System.out.println("Teszthez szukseges objektumok inicializalasa");
		Mezo m0 = new Mezo();
		Mezo m1 = new Mezo();
		Lada l1 = new Lada();
		Mezo m2 = new Mezo();
		Mezo m3 = new Mezo();
		Lada l2 = new Lada();
		Cel c = new Cel();
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m0.setSzomszed(Irany.JOBBRA, m1);
		Munkas m = new Munkas("Kezdo munkas",m0);
		m0.setMunkas(m);
		m1.setSzomszed(Irany.JOBBRA, m2);
		m1.setSzomszed(Irany.BALRA, m0);
		m1.setLada(l1);
		l1.setIndulo(m1);
		m2.setSzomszed(Irany.JOBBRA, m3);
		Munkas mb = new Munkas("Munkas B",m2);
		m2.Add(mb);
		m3.setSzomszed(Irany.JOBBRA, c);
		m3.Add(l2);
		l2.setIndulo(m3);
		c.setSzomszed(Irany.BALRA, m3);
		System.out.println();
		System.out.println("Most jonnek a futas soran meghivott fuggvenyek");
		System.out.println();
		m.Mozog(Irany.JOBBRA);
		DrawToFile(m0, "teszt16.xml");
	}
	
	//Oszetetteb esetek menuje
	private void oszetetteb() throws FileNotFoundException, UnsupportedEncodingException{
		while(true){
			tesztnyolc();
			
			switch(input()){
			
			case 1: 
				mlmlf();
			break;			
			
			case 2: 
				mlmlc();
			break;	
			
			case 3: 
				return;
				
			default:
				
			break;
			}
		}
	}

	//Fo teszt fuggveny ezt hivja meg a main fuggveny
	public void tesztFG() throws FileNotFoundException, UnsupportedEncodingException{

		
		while(true){
			tesztMainMenu();
			
			switch(input()){
			
			case 1: 
				MunkasUresMezoreLep();
			break;			
			
			case 2: 
				ladaEltolasa();
			break;	
			
			case 3: 
				lyukbaLepes();
			break;
			
			case 4: 
				munkasFalnakLep();
			break;
			
			case 5: 
				munkasCelteruletreLEp();
			break;
			
			case 6: 
				masikMunkasEltolasa();
			break;
			
			case 7: 
				munkasKapcsoloraLep();
			break;
			
			case 8: 
				oszetetteb();
			break;
			
			case 9: 
				System.exit(0);
			break;
			
			default:
				
			break;
			}
		}
	}
	
	private void DrawToFile(Mezo start, String fileName) throws FileNotFoundException, UnsupportedEncodingException { //start: mezo amirol indul a palyaepites, fileName: kimeneti fajlnev
		
		final String dir = System.getProperty("user.dir");
		PrintWriter writer = new PrintWriter(dir+"\\Maps\\Test\\Outputs\\"+fileName, "UTF-8"); // A fajlbairashoz
		List<Mezo> mezok; // Betoltjuk a mezoket egy listaba, ez alapjan keszul majd egy 2D tomb
		mezok = new ArrayList<>();
		mezok.add(start); //Elso listaelemnek megadjuk az "m0" mezoket, ebbol kiundulva epeti fel majd a teljes listat
		List<Munkas> munkasok; // A tesztesetben szereplo munkasok listaja
		munkasok = new ArrayList<>();
		Mezo[][] palya;
		int magassag = 1, szelesseg = 1;
		int x,y = 0;
	
		// A tesztesethez tartozo osszes mezo felderitese (tipikusan nem lenne szukseg mindegyik iranyra itt, de a teljes palya kirajzolasahoz jol johet)
		Mezo m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.FEL) != null){
			m = m.SzomszedokLekerdez(Irany.FEL);
			magassag += 1;
			 mezok.add(m);
		}
		m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.LE) != null){
			m = m.SzomszedokLekerdez(Irany.LE);
			magassag += 1;
			mezok.add(m);
		}
		m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.JOBBRA) != null){
			m = m.SzomszedokLekerdez(Irany.JOBBRA);
			szelesseg += 1;
			 mezok.add(m);
		}
		m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.BALRA) != null){
			m = m.SzomszedokLekerdez(Irany.BALRA);
			szelesseg += 1;
			 mezok.add(m);
		}
		
		// Begyujtjuk a teszt palyan talalhato osszes munkast
		for(int i = 0;i<mezok.size();i++){
			Mezo field = mezok.get(i);
			if(field.getMunkas() != null){
				munkasok.add(field.getMunkas());
				}
			}
		
		// A korabban felderitett osszes mezo konvertalasa egy 2D tombbe
		palya = new Mezo[magassag][szelesseg];
		
		Mezo balfelso = new Mezo();
		m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.FEL) != null){
			m = m.SzomszedokLekerdez(Irany.FEL);
		}
		while(m.SzomszedokLekerdez(Irany.BALRA) != null){
			m = m.SzomszedokLekerdez(Irany.BALRA);
		}
		balfelso = m;
		x = 0;
		y = 0;
		boolean done = false;
		while(done != true){
			palya[x][y] = m;
			Mezo koztes = m.SzomszedokLekerdez(Irany.JOBBRA);
			while(koztes != null){
				y = y+1;
				palya[x][y] = koztes;
				koztes = koztes.SzomszedokLekerdez(Irany.JOBBRA);
			}
			x += 1;
			if(m.SzomszedokLekerdez(Irany.LE) == null)
				done = true;
			m = m.SzomszedokLekerdez(Irany.LE);
		}
		
		// Az elozo lepesben letrehozott tomb segitsegevel kirajzoljuk a dolgokat.
		for(x = 0; x <magassag;x++){
			for(y = 0; y <szelesseg;y++){
				if(palya[x][y] instanceof Fal){  // Fal kirajzolasa
					writer.print("F");
				}else if(palya[x][y] instanceof Mezo){ 
					if(palya[x][y].getLada() != null){
						writer.print("L"); 			// Lada kirajzolasa
					}else if(palya[x][y].getMunkas() != null){
						Munkas mu = palya[x][y].getMunkas();
						for(int in = 0;in <munkasok.size();in++){
							if(munkasok.get(in) == mu)
								writer.print(in);
						}
					}else{
						writer.print("M");			//Munkas kirajzolasa
					}
				}else if(palya[x][y] instanceof Kapcsolo){
					if(palya[x][y].getLada() != null){
						writer.print("L");
					}else if(palya[x][y].getMunkas()!= null){
						Munkas mu = palya[x][y].getMunkas();
						for(int in = 0;in <munkasok.size();in++){
							if(munkasok.get(in) == mu)
								writer.print(in);
						}
					}else{
						writer.print("K");		// Kapcsolo kirajzolasa
					}
				}else if(palya[x][y] instanceof Lyuk){
					writer.print("Y");
				
				}else if(palya[x][y] instanceof Cel){
					if(palya[x][y].getLada() != null){
						writer.print("L");
					}else if(palya[x][y].getMunkas()!= null){
						Munkas mu = palya[x][y].getMunkas();
						for(int in = 0;in <munkasok.size();in++){
							if(munkasok.get(in) == mu)
								writer.print(in);
						}
					}else{
						writer.print("C");		// Cel kirajzolasa
					}
				}
			}
			writer.println();
		}
		writer.close();
	}
	
}
