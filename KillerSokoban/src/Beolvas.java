import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Beolvas {
	String fileName = "prebuilt1.xml";
	
	
	public Beolvas(String fn) {
		this.fileName = fn;
	}
	
	
	public ArrayList<String> Init() { 
		final String dir = System.getProperty("user.dir");
		Scanner sc2 = null;
		ArrayList<String> List = new ArrayList<String>();
		 try {
		        sc2 = new Scanner(new File(dir+"\\Maps\\Sample\\"+fileName));
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();  
		    }
		    while (sc2.hasNextLine()) {
		            Scanner s2 = new Scanner(sc2.nextLine());
		        while (s2.hasNext()) {
		            String s = s2.next();
		            List.add(s);
		        }
		    }
		 return List;
	}
	
	
	public ArrayList<Mezo> Beolvas() {
		boolean teszt = true;
		System.out.println("Beolvas");
		ArrayList<String> List = new ArrayList<String>(Init());
		ArrayList<Mezo> mezok = new ArrayList<Mezo>();
		
		for(int i = 0; i < List.size(); i++) {
			char[] betuk =List.get(i).toCharArray();
			
			for(int j = 0; j < betuk.length; j++) {
			switch(betuk[j]){			
			case 'F': {
				mezok.add(new Fal());
			}
			break;			
			
			case 'M': {
				mezok.add(new Mezo());
			}
			break;
			
			case 'L': {
				Mezo m = new Mezo();
				Lada l = new Lada();
				
				if (teszt)
					l.setTeszt(teszt);
				l.setIndulo(m);
				m.Add(new Lada());
				mezok.add(m);

			}
			break;
			
			case 'Y': {
				mezok.add(new Lyuk());
			}
			break;
			
			case 'K': {
				mezok.add(new Kapcsolo());
			}
			break;
			
			case 'C': {
				mezok.add(new Cel());
			}
			break;
			
			case 'E': {
				Mezo m = new Mezo();
				m.setOlaj();
				mezok.add(new Mezo());
				
			}
			
			case 'Z': {
				Mezo m = new Mezo();
				m.setMez();
				mezok.add(new Mezo());
				
			}
			break;
				
			
			default:				
			break;
			
			}
			
			if(i== 0) { //Elsõ sor	
				if(j != 0 ) { //Elsõ sor de NEM elsõ elem
					mezok.get(j).setSzomszed(Irany.BALRA, mezok.get(j-1));
					mezok.get(j-1).setSzomszed(Irany.JOBBRA, mezok.get(j));
				}					
			}
			if(i > 0) { //Nem elsõ sor
				int r = i*betuk.length;
				int rm = (i-1)*betuk.length;
				//System.out.println(r+" "+i+" "+ rm + " " + j + " "+mezok.size());
				if(j == 0) { // Elsõ eleme
					mezok.get(rm+j).setSzomszed(Irany.LE, mezok.get(r+j));
					mezok.get(r+j).setSzomszed(Irany.FEL, mezok.get(rm+j));
				}		
				if(j != 0 ) { //NEM elsõ elem
					mezok.get(rm+j).setSzomszed(Irany.LE, mezok.get(r+j));
					mezok.get(r+j).setSzomszed(Irany.FEL, mezok.get(rm+j));
					mezok.get(r+j).setSzomszed(Irany.BALRA, mezok.get(r+j-1));
					mezok.get(r+j-1).setSzomszed(Irany.JOBBRA, mezok.get(r+j));
				}		
			}
		}
			
	}
		System.out.println("Beolvas Vege");
	return mezok;	
	}
	
}
