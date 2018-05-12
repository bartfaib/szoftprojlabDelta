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
		Scanner tempAlpha = null;
		ArrayList<String> tempLista = new ArrayList<String>();

		try {
			tempAlpha = new Scanner(new File(System.getProperty("user.dir") + "\\Maps\\Sample\\" + fileName));

			while (tempAlpha.hasNextLine()) {
				Scanner tempBeta = new Scanner(tempAlpha.nextLine());
				while (tempBeta.hasNext()) {
					String s = tempBeta.next();
					tempLista.add(s);
				}
				tempBeta.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			tempAlpha.close();
		}

		return tempLista;
	}

	public ArrayList<Mezo> Beolvas() {
		// System.out.println("Beolvas");

		ArrayList<String> tempLista = new ArrayList<String>(Init());
		ArrayList<Mezo> mezok = new ArrayList<Mezo>();
		ArrayList<Kapcsolo> kapcsolok = new ArrayList<Kapcsolo>();
		ArrayList<Lyuk> lyukak = new ArrayList<Lyuk>();
		
		for(int i = 0; i < tempLista.size(); i++) {
			char[] betuk = tempLista.get(i).toCharArray();
			
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
					
					l.setIndulo(m);
					m.Add(l);
					mezok.add(m);
	
				}
				break;
				
				case 'Y': {
					mezok.add(new Lyuk());
					lyukak.add(new Lyuk());
				}
				break;
				
				case 'K': {
					mezok.add(new Kapcsolo());
					kapcsolok.add(new Kapcsolo());
				}
				break;
				
				case 'C': {
					mezok.add(new Cel());
				}
				break;
				
				case 'O': {
					Mezo m = new Mezo();
					m.setOlaj();
					mezok.add(m);
					
				}
				break;
				case 'E': {
					Mezo m = new Mezo();
					m.setMez();
					mezok.add(m);
					
				}
				break;
					
				
				default:{
					mezok.add(new Mezo());
				}	
				break;
				
				}
				
				if(i == 0) { //Els� sor	
					if(j != 0 ) {
						//System.out.print("Set Balra + Jobbra");
						mezok.get(j).setSzomszed(Irany.BALRA, mezok.get(j-1));
						mezok.get(j-1).setSzomszed(Irany.JOBBRA, mezok.get(j));
						if(betuk[j] == 'L') {
							mezok.get(j).getLada().setIndulo(mezok.get(j));
						}
					}					
				}
				if(i > 0) { //Nem els� sor
					int tmp = betuk.length;
					int r = i*tmp;
					int rm = (i-1)*tmp;
					//System.out.println(r+" "+i+" "+ rm + " " + j + " "+mezok.size());
					if(j == 0) { // Els� eleme
						//System.out.print("Set Le + Fel");
						mezok.get(rm+j).setSzomszed(Irany.LE, mezok.get(r+j));
						mezok.get(r+j).setSzomszed(Irany.FEL, mezok.get(rm+j));
						if(betuk[j] == 'L') {
							mezok.get(r+j).getLada().setIndulo(mezok.get(r+j));
						}
						if (j != 0) { // NEM első elem
							// System.out.print("Set Balra + Jobbra + le + fel");
							mezok.get(rm + j).setSzomszed(Irany.LE, mezok.get(r + j));
							mezok.get(r + j).setSzomszed(Irany.FEL, mezok.get(rm + j));
							mezok.get(r + j).setSzomszed(Irany.BALRA, mezok.get(r + j - 1));
							mezok.get(r + j - 1).setSzomszed(Irany.JOBBRA, mezok.get(r + j));
							if (betuk[j] == 'L') {
								mezok.get(r + j).getLada().setIndulo(mezok.get(r + j));
							}
	
						}
					}
				}
			}
		}
		Connect(kapcsolok, lyukak);
		return mezok;
		
	}

	private void Connect(ArrayList<Kapcsolo> k, ArrayList<Lyuk> l) {
		for (int i = 0, j = 0; i < k.size(); i++, j++) {
			Kapcsolo setk = k.get(i);
			Lyuk setl = l.get(j);
			setk.setLyuk(setl);

		}
	}
}
