import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jatek {
	private List<Munkas> munkasok;
	private List<Mezo>   mezok;
	int MaxLepes = 5;
	
	public Jatek(List<Mezo> palya, List<String> jatekosok){
		mezok = new ArrayList<Mezo>();
		mezok = palya;
		munkasok = new ArrayList<>();
		//Ha nem kap jatekosokat akkor a palyan levoket keri meg es oket adja hozza a munkas 
		//listahoz
		if(jatekosok == null || jatekosok.size() != 0){
			for(int i = 0;i<mezok.size();i++){
				Mezo m = mezok.get(i);
				if(m.getMunkas() != null){
					munkasok.add(m.getMunkas());
				}
			}
		}else{
			while(jatekosok.size() > 0){
				boolean talalt = false;
				while(talalt != true){
					Random generator = new Random(); 
					int i = generator.nextInt(mezok.size()) + 1;
					
					/*ha kapcsolo cel vagy mezo a veletlenul kivalasztott akkor
					 * megnezi hogy va e rajta valami ha nincs akkor arra a mezőre rakja
					 * a munkast
					 */
					if(mezok.get(i) instanceof Mezo || 
							mezok.get(i) instanceof Kapcsolo ||
							mezok.get(i) instanceof Cel){
						if(mezok.get(i).getLada() == null && mezok.get(i).getMunkas() == null){
							talalt = true;
							Munkas m = new Munkas(jatekosok.get(0),mezok.get(i));
							munkasok.add(m);
							mezok.get(i).Add(m);
							jatekosok.remove(0);
						}
					}
				}
			}
		}
	}
	
	public void Kor(){
		
		//Az aktuális munkást számontartó változó
		int aktivMunkas = 0;
		
		//Amilyen irányba mozgatjuk a munkást
		Irany i = null;
		
		//Mozgas kimenetelének eltárolását szolgáló változó.
		Kimenetel k = null;
		
		//Munkas álltal még megtehető lépések száma
		int megLephet = MaxLepes;
		
		//Jatek tare vagy véget ért-e változó
		boolean tart = true;
		
		//Volt-e érvényes parancs 
		boolean volt = false;
		
		//Felhasznalo alltal megasott utasitasok
		String komm = null;
		/*Szelesseg es magassag megnezese, hogy letrelehessen hozni egy 2d-s tombot a kirajzolashoz*/
		//egyrol indul mert a kezdo pozicit nem szamolja bele.
		int magassag  = 1;
		int szelesseg = 1;
		
		Mezo m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.FEL) != null){
			m = m.SzomszedokLekerdez(Irany.FEL);
			magassag += 1;
		}
		m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.LE) != null){
			m = m.SzomszedokLekerdez(Irany.LE);
			magassag += 1;
		}
		m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.JOBBRA) != null){
			m = m.SzomszedokLekerdez(Irany.JOBBRA);
			szelesseg += 1;
		}
		m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.BALRA) != null){
			m = m.SzomszedokLekerdez(Irany.BALRA);
			szelesseg += 1;
		}
		//kirajzolashoz a 2d-s tomb
		Mezo[][] palya = new Mezo[magassag][szelesseg];
		
		Mezo balfelso = new Mezo();
		m = mezok.get(0);
		while(m.SzomszedokLekerdez(Irany.FEL) != null){
			m = m.SzomszedokLekerdez(Irany.FEL);
		}
		while(m.SzomszedokLekerdez(Irany.BALRA) != null){
			m = m.SzomszedokLekerdez(Irany.BALRA);
		}
		balfelso = m;
		int x = 0;
		int y = 0;
		boolean kessz = false;
		while(kessz != true){
			palya[x][y] = m;
			Mezo koztes = m.SzomszedokLekerdez(Irany.LE);
			while(koztes != null){
				y = y+1;
				palya[x][y] = koztes;
				koztes = koztes.SzomszedokLekerdez(Irany.LE);
			}
			x += 1;
			if(m.SzomszedokLekerdez(Irany.JOBBRA) == null)
				kessz = true;
			m = m.SzomszedokLekerdez(Irany.JOBBRA);
		}
		
		//Palya kirajzolasa
		for(x = 0; x <magassag;x++){
			for(y = 0; y <szelesseg;y++){
				if(palya[x][y] instanceof Fal){
					System.out.print("F");
				}else if(palya[x][y] instanceof Mezo){
					if(palya[x][y].getLada() != null){
						System.out.print("L");
					}else if(palya[x][y].getMunkas() != null){
						Munkas mu = palya[x][y].getMunkas();
						for(int in = 0;in <munkasok.size();in++){
							if(munkasok.get(in) == mu)
								System.out.print(in);
						}
					}else{
						System.out.print("M");
					}
				}else if(palya[x][y] instanceof Kapcsolo){
					if(palya[x][y].getLada() != null){
						System.out.print("L");
					}else if(palya[x][y].getMunkas()!= null){
						Munkas mu = palya[x][y].getMunkas();
						for(int in = 0;in <munkasok.size();in++){
							if(munkasok.get(in) == mu)
								System.out.print(in);
						}
					}else{
						System.out.print("K");
					}
				}else if(palya[x][y] instanceof Lyuk){
					System.out.print("Y");
				
				}else if(palya[x][y] instanceof Cel){
					if(palya[x][y].getLada() != null){
						System.out.print("L");
					}else if(palya[x][y].getMunkas()!= null){
						Munkas mu = palya[x][y].getMunkas();
						for(int in = 0;in <munkasok.size();in++){
							if(munkasok.get(in) == mu)
								System.out.print(in);
						}
					}else{
						System.out.print("C");
					}
				}
			}
		}
		System.out.println(x);
		System.out.println(y);
		
		//Jatek maga addig tart amig a tart valtozo true
		while(tart == true){
			
			komm = null;
		    volt = false;
			
		    //Parancs beolvasasa
			while(volt == false){
				Scanner  sc = new Scanner (System.in);
				komm = sc.nextLine();
				if(komm.equals("tol w")){
					i = Irany.FEL;
					volt = true;
				}else if(komm.equals("tol s")){
					i = Irany.LE;
					volt = true;
				}else if(komm.equals("tol d")){
					i = Irany.JOBBRA;
					volt = true;
				}else if(komm.equals("tol a")){
					i = Irany.BALRA;
					volt = true;
				}else if(komm.equals("next")){
					volt = true;
				}
			}
			
			//Ha a kovetkezo parancsot kapta a program
			if(komm.equals("next")){
				
				megLephet = MaxLepes;
				boolean kov = false;
				
				//Keresi a kovetkezo eletben levo munkast
				while(kov = false){
					
					aktivMunkas += 1;
					if(aktivMunkas == munkasok.size())
						aktivMunkas = 0;
					
					//Ha a kovetkezo kivalasztott munkas eletben van akkor leallitja a kerest
					if(munkasok.get(aktivMunkas).Elet() == true){
						kov = true;
						megLephet = MaxLepes;
					}
				}
			//Ha valamelyik iranyba mozgas utasitast kapott a jatek
			}else{
				
				//Megfelelő irányba történő lépés végrehajtása a munkással
				k = munkasok.get(aktivMunkas).Mozog(i);
				
				//Ha tudtunk lépni a munkással akkor a lépés számot csökkentjük 1 el ha pontot értünk 
				//Nullázzuk a hátralévő lépés számot.
				if(k == Kimenetel.Mozoghat){
					megLephet -= megLephet;
				}else if(k == Kimenetel.PontotErt){
					megLephet = 0;
				}
				
				//Ellenorzi hogy vege van e a jateknak a lepes után ha nm és az adott munkás már 
				//nem tud tobbet lepni kivalasztja a soronkovetkezo munkast
				if(JatekVege() == false){
					
					//Ha mar nem tud tobbet lepni a munkas a kovetkezo jon
					if(megLephet == 0){
						megLephet = MaxLepes;
						boolean kov = false;
						
						//Keresi a kovetkezo eletben levo munkast
						while(kov = false){
							
							//Kovetkezo munkasra lép növelve a változót ha végig ér előre állítja
							aktivMunkas += 1;
							if(aktivMunkas == munkasok.size())
								aktivMunkas = 0;
							
							//Ha a kovetkezo kivalasztott munkas eletben van akkor leallitja a kerest
							if(munkasok.get(aktivMunkas).Elet() == true){
								kov = true;
								megLephet = MaxLepes;
							}
						}
					}
				}else{
					tart = false;
				}
			}
			
			//Palya 2-d kepenek a frissitese kirajzolas elott
			m = mezok.get(0);
			//Megkeresi a balfelso sarkot
			while(m.SzomszedokLekerdez(Irany.FEL) != null){
				m = m.SzomszedokLekerdez(Irany.FEL);
			}
			while(m.SzomszedokLekerdez(Irany.BALRA) != null){
				m = m.SzomszedokLekerdez(Irany.BALRA);
			}
			balfelso = m;
			x = 0;
			y = 0;
			kessz = false;
			while(kessz != true){
				palya[x][y] = m;
				Mezo koztes = m.SzomszedokLekerdez(Irany.LE);
				while(koztes != null){
					y = y+1;
					palya[x][y] = koztes;
					koztes = koztes.SzomszedokLekerdez(Irany.LE);
				}
				x += 1;
				if(m.SzomszedokLekerdez(Irany.JOBBRA) == null)
					kessz = true;
				m = m.SzomszedokLekerdez(Irany.JOBBRA);
			}
			
			//Palya kirajzolasa
			for(x = 0; x <magassag;x++){
				for(y = 0; y <szelesseg;y++){
					if(palya[x][y] instanceof Fal){
						System.out.print("F");
					}else if(palya[x][y] instanceof Mezo){
						if(palya[x][y].getLada() != null){
							System.out.print("L");
						}else if(palya[x][y].getMunkas() != null){
							Munkas mu = palya[x][y].getMunkas();
							for(int in = 0;in <munkasok.size();in++){
								if(munkasok.get(in) == mu)
									System.out.print(in);
							}
						}else{
							System.out.print("M");
						}
					}else if(palya[x][y] instanceof Kapcsolo){
						if(palya[x][y].getLada() != null){
							System.out.print("L");
						}else if(palya[x][y].getMunkas()!= null){
							Munkas mu = palya[x][y].getMunkas();
							for(int in = 0;in <munkasok.size();in++){
								if(munkasok.get(in) == mu)
									System.out.print(in);
							}
						}else{
							System.out.print("K");
						}
					}else if(palya[x][y] instanceof Lyuk){
						System.out.print("Y");
					
					}else if(palya[x][y] instanceof Cel){
						if(palya[x][y].getLada() != null){
							System.out.print("L");
						}else if(palya[x][y].getMunkas()!= null){
							Munkas mu = palya[x][y].getMunkas();
							for(int in = 0;in <munkasok.size();in++){
								if(munkasok.get(in) == mu)
									System.out.print(in);
							}
						}else{
							System.out.print("C");
						}
					}
				}
				System.out.println();
			}
				//JAtek vegen a gyoztes meghatarozasa
			Munkas[] eredmeny = new Munkas[munkasok.size()];
			int n = eredmeny.length;
			
			for (int index = 0; index < n; index++){
				eredmeny[index] = munkasok.get(index);
			}
		    Munkas temp;
		    //sorba rakja oket
		    for (int index = 0; index < n; index++) {
		        for (int j = 1; j < (n - index); j++) {

		            if (eredmeny[j - 1].getPont() > eredmeny[j].getPont()) {
		                temp = eredmeny[j - 1];
		                eredmeny[j - 1] = eredmeny[j];
		                eredmeny[j] = temp;
		            }

		        }
		    }
		    //Eredmenyek kiirasa
		    int helyezett = 1;
		    for (int index = 0; index < n; index++){
				if(index == 0){
					System.out.println(helyezett + ". lett:" + eredmeny[index].getNev());
				}else{
					//Ha a kovetkezonek kevesebb pontja van akkor a helyezes szamanka novelese
					if(eredmeny[index - 1].getPont() > eredmeny[index].getPont())
						helyezett += 1;
					System.out.println(helyezett + ". lett:" + eredmeny[index].getNev());
				}
			}
		    
		    
		}
	}
	
	boolean JatekVege(){
		//Elosszor megvizsgalja hogy van-e meg elo munkas
		boolean elo = false;
		for(int i = 0; i < munkasok.size();i++){
			if(munkasok.get(i).Elet() == true)
				elo = true;
		}
		
		//Ha nincs elo munkas falsal ter vissza ami a jatek vegét jelenti
		if(elo == false)
			return true;
		
		boolean tolhato = false;
		int i = 0;
		Mezo m = null;
		List<Mezo> jatekvm = new ArrayList();
		jatekvm = mezok;
		
		while(tolhato == false || i == mezok.size()){
			m = jatekvm.get(i);
			
			/*Megnezi hogy a lada eltolhato e valamelyik iranyba ha igen akkor megnezi hogy van
			 * emelette üres mezo ha igen akkor abból a mezőből kiindulva megnézi az összes
			 * lehetseges utat amíg nem talál egy mezőn munkást vagy minden lehetséges út el nem
			 * fogyott. 
			 */
			int index = 0;
			while(index < 4){
				Irany elso = null;
				Irany ellentetes = null;
				
				switch (index){
					case 0:{elso = Irany.JOBBRA; ellentetes = Irany.BALRA;}
					break;
					case 1:{elso = Irany.BALRA; ellentetes = Irany.JOBBRA;}
					break;
					case 2:{elso = Irany.FEL; ellentetes = Irany.LE;}
					break;
					case 3:{elso = Irany.LE; ellentetes = Irany.FEL;}
					break;
					default:
						break;
				}
				//megnezi hogy mozoghat e a lada es ha igen az ellentetes oldalon milyen mezo van
				if(m.Mozog(elso) == Kimenetel.Mozoghat || m.Mozog(elso) == Kimenetel.PontotErt ){
					if(m.SzomszedokLekerdez(ellentetes) instanceof Mezo || 
							m.SzomszedokLekerdez(ellentetes) instanceof Kapcsolo ||
							m.SzomszedokLekerdez(ellentetes) instanceof Cel ||
							m.SzomszedokLekerdez(ellentetes) instanceof Lyuk){
						
						//MEzo a kezdo vizsgalt mezore allitasa
						m = m.SzomszedokLekerdez(elso);
						
						//HA munkas all rajta es mozoghat akkor igaz
						if(m.getMunkas() != null)
							return false;
						
						
						if(m.getLada() == null){
							jatekvm = mezok;
							List<Mezo> latogatott = new ArrayList();
							List<Mezo> latogatando = new ArrayList();
							latogatott.add(m);
							
							//Kezdo meglatogatandokkal valo feltoltes
							if(m.SzomszedokLekerdez(Irany.JOBBRA) != null)
								latogatando.add(m.SzomszedokLekerdez(Irany.JOBBRA));
							//Kezdo meglatogatandokkal valo feltoltes
							if(m.SzomszedokLekerdez(Irany.BALRA) != null)
								latogatando.add(m.SzomszedokLekerdez(Irany.BALRA));
							//Kezdo meglatogatandokkal valo feltoltes
							if(m.SzomszedokLekerdez(Irany.FEL) != null)
								latogatando.add(m.SzomszedokLekerdez(Irany.FEL));
							//Kezdo meglatogatandokkal valo feltoltes
							if(m.SzomszedokLekerdez(Irany.LE) != null)
								latogatando.add(m.SzomszedokLekerdez(Irany.LE));
							
							while (latogatando.size() == 0){
								m = latogatando.get(0);
								
								//Ha van rajt munkas akkor visszater azzal hogy meg nem ert veget a jatek 
								if(m.getMunkas() != null)
									 return false;
								
								if(m.getLada() == null){
									if(m instanceof Mezo || m instanceof Cel || m instanceof Lyuk
											|| m instanceof Kapcsolo){
										//Megnezi hogy az adott mezok voltak e mar ha igen nem adja oket a
										// latogatando listahoz
										boolean egyezik = false;
										for(int in= 0;in < latogatott.size();in++){
											if(m.SzomszedokLekerdez(Irany.JOBBRA) == latogatott.get(in))
												egyezik = true;
										}
										if(egyezik == false && m.SzomszedokLekerdez(Irany.JOBBRA) != null)
											latogatando.add(m.SzomszedokLekerdez(Irany.JOBBRA));
										egyezik = false;
										//Balra levo mezo
										for(int in= 0;in < latogatott.size();in++){
											if(m.SzomszedokLekerdez(Irany.BALRA) == latogatott.get(in))
												egyezik = true;
										}
										if(egyezik == false && m.SzomszedokLekerdez(Irany.BALRA) != null)
											latogatando.add(m.SzomszedokLekerdez(Irany.BALRA));
										egyezik = false;
										//Fel levo mezo
										for(int in= 0;in < latogatott.size();in++){
											if(m.SzomszedokLekerdez(Irany.FEL) == latogatott.get(in))
												egyezik = true;
										}
										if(egyezik == false && m.SzomszedokLekerdez(Irany.FEL) != null)
											latogatando.add(m.SzomszedokLekerdez(Irany.FEL));
										egyezik = false;
										
										//Le levo mezo
										for(int in= 0;in < latogatott.size();in++){
											if(m.SzomszedokLekerdez(Irany.LE) == latogatott.get(in))
												egyezik = true;
										}
										if(egyezik == false && m.SzomszedokLekerdez(Irany.LE) != null)
											latogatando.add(m.SzomszedokLekerdez(Irany.LE));
									}
									latogatando.remove(0);
								}
							}
							
						}
					}
				
				}
				//Palya visszaalitasa a kezdo palyara
				jatekvm = mezok;
				//INdex novelese a vizsgalt iranyokra
				index += 1;	
			}
		}
		
		return true;
	}
}
