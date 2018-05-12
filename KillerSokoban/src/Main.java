import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jatek {
	private List<Munkas> munkasok;
	private static List<Mezo>   mezok;
	int MaxLepes = 5;
	boolean vege = false;
	
	public Jatek(List<Mezo> palya, List<String> jatekosok){
		mezok = new ArrayList<Mezo>();
		mezok = palya;
		munkasok = new ArrayList<>();
		// Ha nem kap jatekosokat akkor a palyan levoket keri meg es oket adja
		// hozza a munkas listahoz
		if (jatekosok == null) {
			for (int i = 0; i < mezok.size(); i++) {
				Mezo m = mezok.get(i);
				if (m.getMunkas() != null) {
					munkasok.add(m.getMunkas());
				}
			}
		} else {
			while (jatekosok.size() > 0) {
				boolean talalt = false;
				Random generator = new Random();
				while (talalt != true) {
					int i = generator.nextInt(mezok.size());
					/*
					 * ha kapcsolo cel vagy mezo a veletlenul kivalasztott akkor
					 * megnezi hogy va e rajta valami ha nincs akkor arra a
					 * mezőe rakja a munkast
					 */
					if(mezok.get(i) instanceof Fal || mezok.get(i) instanceof Lyuk || 
							mezok.get(i) instanceof Cel || mezok.get(i).getOlaj() || mezok.get(i).getMez()){
						
					}else if(mezok.get(i) instanceof Mezo){
						if(mezok.get(i).getLada() == null && mezok.get(i).getMunkas() == null){
							Munkas m = new Munkas(jatekosok.get(0), mezok.get(i));
							munkasok.add(m);
							mezok.get(i).Add(m);
							jatekosok.remove(0);
						}
					}
				}
			}
		}
	}

	int magassag = 1;
	int szelesseg = 1;
	int x = 0;
	int y = 0;
	boolean kessz;

	public void PalyaKirajzolas(Mezo m, Mezo[][] palya) {
		// Palya 2-d kepenek a frissitese kirajzolas elott
		m = mezok.get(0);
		// Megkeresi a balfelso sarkot
		while (m.SzomszedokLekerdez(Irany.FEL) != null) {
			m = m.SzomszedokLekerdez(Irany.FEL);
		}
		while (m.SzomszedokLekerdez(Irany.BALRA) != null) {
			m = m.SzomszedokLekerdez(Irany.BALRA);
		}

		x = 0;
		y = 0;
		kessz = false;

		while (kessz != true) {
			palya[x][y] = m;
			Mezo koztes = m.SzomszedokLekerdez(Irany.LE);
			while (koztes != null) {
				x = x + 1;
				palya[x][y] = koztes;
				koztes = koztes.SzomszedokLekerdez(Irany.LE);
			}
			x = 0; // RESETELNI X-t
			y += 1;
			if (m.SzomszedokLekerdez(Irany.JOBBRA) == null)
				kessz = true;
			m = m.SzomszedokLekerdez(Irany.JOBBRA);
		}

		for (x = 0; x < magassag; x++) {
			for (y = 0; y < szelesseg; y++) {
				if (palya[x][y] instanceof Fal) {
					System.out.print("F");
				} else if (palya[x][y] instanceof Kapcsolo) {
					if (palya[x][y].getLada() != null) {
						System.out.print("L");
					} else if (palya[x][y].getMunkas() != null) {
						Munkas mu = palya[x][y].getMunkas();
						for (int in = 0; in < munkasok.size(); in++) {
							if (munkasok.get(in) == mu)
								System.out.print(in);
						}
					} else {
						System.out.print("K");
					}
				}else if(palya[x][y] instanceof Lyuk){
					if(palya[x][y].getState()) {
					System.out.print("Y");}
					else {System.out.print("M");}
				
				}else if(palya[x][y] instanceof Cel){
					if(palya[x][y].getLada() != null){
						System.out.print("L");
					}else{
						System.out.print("C");
					}
				}else if(palya[x][y].getMunkas()!= null){
					Munkas mu = palya[x][y].getMunkas();
					for(int in = 0;in <munkasok.size();in++){
						if(munkasok.get(in) == mu)
							System.out.print(in);
					}
				}else if(palya[x][y] instanceof Mezo){
					if(palya[x][y].getLada() != null){
						System.out.print("L");
					} else if (palya[x][y].getMunkas() != null) {
						Munkas mu = palya[x][y].getMunkas();
						for (int in = 0; in < munkasok.size(); in++) {
							if (munkasok.get(in) == mu)
								System.out.print(in);
						}
					}else if(palya[x][y].getOlaj()){
						System.out.print("O");
					}else if(palya[x][y].getMez()){
						System.out.print("E");
					}
					else{
						System.out.print("-");
					}
				}
			}
			System.out.print("\n");
		}
		for (int index = 0; index < munkasok.size(); index++) {
			if (munkasok.get(index).Elet() == false) {
				System.out.println(munkasok.get(index).getNev() + " (" + index + ") doglott, pont: "
						+ munkasok.get(index).getPont());
			} else {
				System.out.println(
						munkasok.get(index).getNev() + " (" + index + ") elo, pont: " + munkasok.get(index).getPont());
			}
		}
<<<<<<< HEAD
		
		for(int index = 0 ;index < mezok.size();index++){
			if(mezok.get(index).getMunkas()!= null){
				//System.out.println("talalt");
=======
	}

	int aktivMunkas = 0;
	int maxLepesSzam = 8;
	Irany mozgasiIrany = null;
	int lepesSzam = maxLepesSzam;
	boolean jatekFolyik = true;
	boolean vanErvenyesParancs = false;
	String felhasznaloiParancs = null;

	public void Kor() {
		aktivMunkas = 0;
		munkasok.get(aktivMunkas).setKezdo(true);
		lepesSzam = maxLepesSzam;
		mozgasiIrany = null;
		jatekFolyik = true;

		magassag = 1;
		szelesseg = 1;

		Mezo m = mezok.get(0);
		while (m.SzomszedokLekerdez(Irany.FEL) != null) {
			m = m.SzomszedokLekerdez(Irany.FEL);
			magassag += 1;
		}
		m = mezok.get(0);
		while (m.SzomszedokLekerdez(Irany.LE) != null) {
			m = m.SzomszedokLekerdez(Irany.LE);
			magassag += 1;
		}
		m = mezok.get(0);
		while (m.SzomszedokLekerdez(Irany.JOBBRA) != null) {
			m = m.SzomszedokLekerdez(Irany.JOBBRA);
			szelesseg += 1;
		}
		m = mezok.get(0);
		while (m.SzomszedokLekerdez(Irany.BALRA) != null) {
			m = m.SzomszedokLekerdez(Irany.BALRA);
			szelesseg += 1;
		}

		// kirajzolashoz a 2d-s tomb
		Mezo[][] palya = new Mezo[magassag][szelesseg];

		while (m.SzomszedokLekerdez(Irany.FEL) != null) {
			m = m.SzomszedokLekerdez(Irany.FEL);
		}
		while (m.SzomszedokLekerdez(Irany.BALRA) != null) {
			m = m.SzomszedokLekerdez(Irany.BALRA);
		}

		for (int index = 0; index < mezok.size(); index++) {
			if (mezok.get(index).getMunkas() != null) {
				System.out.println("Munkas megtalalva.");
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
			}
		}

		while (jatekFolyik) {
			PalyaKirajzolas(m, palya);

			System.out.println("Az iranyitas a 'wasd om' gombok utan ENTER-rel tortenik.");
			if (munkasok.get(aktivMunkas).Elet() == true) {
				System.out.println(munkasok.get(aktivMunkas).getNev() + " (" + aktivMunkas + ") kovetkezik " + lepesSzam
						+ " lepes van hatra.");
			} else {
				System.out.println(munkasok.get(aktivMunkas).getNev() + " (" + aktivMunkas + ") doglott " + lepesSzam
						+ " lepes van hatra.");
			}

			felhasznaloiParancs = null;
			vanErvenyesParancs = false;

			// Parancs beolvasasa
			while (vanErvenyesParancs == false) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try {
					String s = br.readLine();

					felhasznaloiParancs = s;
					s = null;
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
<<<<<<< HEAD
				//System.out.println(komm);
					switch(komm) {
					case("tol w"):{
						irany = Irany.FEL;
						volt = true;
					}
=======

				switch (felhasznaloiParancs) {
				case ("w"): {
					mozgasiIrany = Irany.FEL;
					vanErvenyesParancs = true;
				}
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
					break;

				case ("s"): {
					mozgasiIrany = Irany.LE;
					vanErvenyesParancs = true;
				}
					break;

				case ("a"): {
					mozgasiIrany = Irany.BALRA;
					vanErvenyesParancs = true;
				}
					break;

				case ("d"): {
					mozgasiIrany = Irany.JOBBRA;
					vanErvenyesParancs = true;
				}
					break;

				case (""): {
					vanErvenyesParancs = true;
				}
					break;

				case ("o"): {
					mozgasiIrany = null;
					munkasok.get(aktivMunkas).addOlaj();
					vanErvenyesParancs = true;
				}
					break;
<<<<<<< HEAD
					
					case("addMez"):{
						irany = null;
						munkasok.get(aktivMunkas).addMez();
						volt = true;
					}
					break;
					case("Exit"):{
						irany = null;
						volt = true;
						tart = false;
						
					}
					break;
					}
=======
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df

				case ("m"): {
					mozgasiIrany = null;
					munkasok.get(aktivMunkas).addMez();
					vanErvenyesParancs = true;
				}
<<<<<<< HEAD
			//Ha valamelyik iranyba mozgas utasitast kapott a jatek
			}else if(irany != null){
				
				//Megfelelo iranyba tolasa a munkasnak
				k = munkasok.get(aktivMunkas).Mozog(irany, 0);
				
				//Ha tudtunk l駱ni a munk疽sal akkor a l駱駸 sz疥ot cskentj�k 1 el ha pontot 駻t�nk 
				//Null痙zuk a h疸ral騅� l駱駸 sz疥ot.
				if(k == Kimenetel.Mozoghat){
					megLephet -= megLephet;
				}else if(k == Kimenetel.PontotErt){
					megLephet = 0;
=======
					break;
				}

			}

			if (mozgasiIrany != null) {
				if (munkasok.get(aktivMunkas).Mozog(mozgasiIrany) == Kimenetel.PontotErt) {
					lepesSzam = 0;
					// Ha pontot értünk Nullázuk a hátralévő lépés számot.
				} else {
					lepesSzam -= 1;
					// Egyébként 1 el csökentjük a lépés számot.
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
				}

				// Ellenorzi hogy vege van e a jateknak a lepes utç–Ł ha nm é§¸
				// az adott munká mç–µ
				// nem tud tobbet lepni kivalasztja a soronkovetkezo munkast
				if (JatekVege()) {
					jatekFolyik = false;
				} else {
					// Ha mar nem tud tobbet lepni a munkas a kovetkezo jon
					if (lepesSzam == 0) {
						lepesSzam = maxLepesSzam;
						boolean kov = false;
						munkasok.get(aktivMunkas).setKezdo(false);
						// Keresi a kovetkezo eletben levo munkast
						while (kov == false) {

							// Kovetkezo munkasra lé§± nî’želve a vátozî‰¨ ha
							// vé¦®ig é§» előe álĺ’śja
							aktivMunkas += 1;
							if (aktivMunkas == munkasok.size())
								aktivMunkas = 0;

							// Ha a kovetkezo kivalasztott munkas eletben van
							// akkor leallitja a kerest
							if (munkasok.get(aktivMunkas).Elet() == true) {
								kov = true;
								munkasok.get(aktivMunkas).setKezdo(true);
							}
						}
					}
				}
			}

			// Ha a kovetkezo parancsot kapta a program vagy megdoglott a
			// munkasunk
			if (felhasznaloiParancs.equals("") || munkasok.get(aktivMunkas).Elet() == false) {
				// Elosszor megvizsgalja hogy van-e meg elo munkas
				boolean vanEloMunkas = false;
				for (int i = 0; i < munkasok.size(); i++) {
					if (munkasok.get(i).Elet() == true)
						vanEloMunkas = true;
				}
<<<<<<< HEAD
				x=0;
				y += 1;
				if(m.SzomszedokLekerdez(Irany.JOBBRA) == null)
					kessz = true;
				m = m.SzomszedokLekerdez(Irany.JOBBRA);
			}
			
			//Palya kirajzolasa
			for(x = 0; x <magassag;x++){
				for(y = 0; y <szelesseg;y++){
					if(palya[x][y] instanceof Fal){
						System.out.print("F");
					}else if(palya[x][y] instanceof Kapcsolo){
						if(palya[x][y].getLada() != null){
							System.out.print("L");
						}else{
							System.out.print("K");
						}
					}else if(palya[x][y] instanceof Lyuk){
						if(palya[x][y].getState()) {
						System.out.print("Y");}
						else {System.out.print("M");}

					}else if(palya[x][y].getMunkas()!= null){
						Munkas mu = palya[x][y].getMunkas();
						for(int in = 0;in <munkasok.size();in++){
							if(munkasok.get(in) == mu)
								System.out.print(in);
						}}else if(palya[x][y] instanceof Cel){
						if(palya[x][y].getLada() != null){
							System.out.print("L");
						}else{
							System.out.print("C");
						}
					}else if(palya[x][y].getMunkas()!= null){
						Munkas mu = palya[x][y].getMunkas();
						for(int in = 0;in <munkasok.size();in++){
							if(munkasok.get(in) == mu)
								System.out.print(in);
						}
					}else if(palya[x][y] instanceof Mezo){
						if(palya[x][y].getLada() != null){
							System.out.print("L");
						}else if(palya[x][y].getMunkas() != null){
							Munkas mu = palya[x][y].getMunkas();
							for(int in = 0;in <munkasok.size();in++){
								if(munkasok.get(in) == mu)
									System.out.print(in);
							}
						}else if(palya[x][y].getOlaj()){
							System.out.print("O");
						}else if(palya[x][y].getMez()){
							System.out.print("E");
						}
						else{
							System.out.print("M");
=======

				// Ha nincs elo munkas falsal ter vissza ami a jatek
				// vegétjelenti
				if (!vanEloMunkas) {
					jatekFolyik = false;
				} else {
					lepesSzam = maxLepesSzam;
					munkasok.get(aktivMunkas).setKezdo(false);

					// Keresi a kovetkezo eletben levo munkast
					while (true) {
						aktivMunkas += 1;
						if (aktivMunkas == munkasok.size())
							aktivMunkas = 0;

						// Ha a kovetkezo kivalasztott munkas eletben van akkor
						// leallitja a kerest
						if (munkasok.get(aktivMunkas).Elet() == true) {
							munkasok.get(aktivMunkas).setKezdo(true);
							break;
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
						}
					}
				}
			}
		}
<<<<<<< HEAD
		//J疸駝 v馮e kiirat疽ok
		//JAtek vegen a gyoztes meghatarozasa

		Munkas winner = munkasok.get(0);
		
			for(int ii = 0; ii< munkasok.size(); ii++) {
					if (munkasok.get(ii).getPont() > winner.getPont()) {
						winner=munkasok.get(ii);
				}
			}
			System.out.println("A győztes: " + winner.getNev() + " Pontja: " + winner.getPont()+ "!!!");
			}
		

	
	boolean JatekVege(){
		//Elosszor megvizsgalja hogy van-e meg elo munkas
		boolean elo = false;
		for(int i = 0; i < munkasok.size();i++){
			if(munkasok.get(i).Elet() == true)
				elo = true;
=======

		System.out.println("Game Over");

		// Jç–¸é§ť vé¦®e kiiratáok
		// JAtek vegen a gyoztes meghatarozasa
		Munkas[] eredmeny = new Munkas[munkasok.size()];

		for (int index = 0; index < eredmeny.length; index++) {
			eredmeny[index] = munkasok.get(index);
		}
		
		// sorba rakja oket
		for (int j = 0; j < eredmeny.length; j++) {
			for (int index = 0; index < eredmeny.length - 1; index++) {
				if (eredmeny[index].getPont() > eredmeny[index + 1].getPont()) {
					Munkas temp = eredmeny[index + 1];
					eredmeny[index + 1] = eredmeny[index];
					eredmeny[index] = temp;
				}
			}
		}
		// Eredmenyek kiirasa
		int helyezett = 1;
		for (int index = 0; index < eredmeny.length; index++) {
			System.out
			.println(helyezett + ". lett: " + eredmeny[index].getNev() + ", " + eredmeny[index].getPont());
			if (index < eredmeny.length - 1 && eredmeny[index].getPont() > eredmeny[index + 1].getPont()) {
				// Ha a kovetkezonek kevesebb pontja van akkor a helyezes
				// szamanka novelese
				helyezett += 1;
			}
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
		}
	}

	boolean JatekVege() {
		boolean vanTolhatoLada = false;
		int i = 0;
		Mezo m = null;
		List<Mezo> jatekvm = new ArrayList<Mezo>();
		jatekvm = mezok;
<<<<<<< HEAD
		boolean Vanelada = false;

		
		while(tolhato == false && i < mezok.size()){
=======

		while (vanTolhatoLada == false && i < mezok.size()) {
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
			m = jatekvm.get(i);

			/*
			 * Megnezi hogy a lada eltolhato e valamelyik iranyba ha igen akkor
			 * megnezi hogy van emelette üres mezo ha igen akkor abbî‰  a
			 * mezőîŹ� kiindulva megné¨·i az î’›szes lehetseges utat amĺ�• nem
			 * talá egy mezé munkát vagy minden lehetsé¦®es ĺ�€ el nem fogyott.
			 */
			int index = 0;
			while (index < 4) {
				Irany elso = null;
				Irany ellentetes = null;

				switch (index) {
				case 0: {
					elso = Irany.JOBBRA;
					ellentetes = Irany.BALRA;
				}
					break;
				case 1: {
					elso = Irany.BALRA;
					ellentetes = Irany.JOBBRA;
				}
					break;
				case 2: {
					elso = Irany.FEL;
					ellentetes = Irany.LE;
				}
					break;
				case 3: {
					elso = Irany.LE;
					ellentetes = Irany.FEL;
				}
					break;
				default:
					break;
				}
<<<<<<< HEAD
				
				//megnezi hogy mozoghat e a lada es ha igen az ellentetes oldalon milyen mezo van
				
				//System.out.println(m.SzomszedokLekerdez(elso));
				Kimenetel k = m.Mozog(elso, 0);
				//System.out.println("lefutott");
				if(k == Kimenetel.Mozoghat || k == Kimenetel.PontotErt ){
					if(m.SzomszedokLekerdez(ellentetes) instanceof Mezo || 
							m.SzomszedokLekerdez(ellentetes) instanceof Kapcsolo ||
							m.SzomszedokLekerdez(ellentetes) instanceof Cel ||
							m.SzomszedokLekerdez(ellentetes) instanceof Lyuk){
						//MEzo a kezdo vizsgalt mezore allitasa
=======

				// megnezi hogy mozoghat e a lada es ha igen az ellentetes
				// oldalon milyen mezo van

				Kimenetel k = m.Mozog(elso);
				if (k == Kimenetel.Mozoghat || k == Kimenetel.PontotErt) {
					if (m.SzomszedokLekerdez(ellentetes) instanceof Mezo
							|| m.SzomszedokLekerdez(ellentetes) instanceof Kapcsolo
							|| m.SzomszedokLekerdez(ellentetes) instanceof Cel
							|| m.SzomszedokLekerdez(ellentetes) instanceof Lyuk) {
						// MEzo a kezdo vizsgalt mezore allitasa
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
						m = m.SzomszedokLekerdez(ellentetes);
						vanTolhatoLada = true;
						// HA munkas all rajta es mozoghat akkor igaz
						if (m.getMunkas() != null)
							vanTolhatoLada = false;

						if (m.getLada() == null) {
							jatekvm = mezok;
							List<Mezo> latogatott = new ArrayList<Mezo>();
							List<Mezo> latogatando = new ArrayList<Mezo>();
							latogatott.add(m);
<<<<<<< HEAD
							//System.out.println(elso+ "elso");
							//Kezdo meglatogatandokkal valo feltoltes
							if(m.SzomszedokLekerdez(Irany.JOBBRA) != null)
=======
							// Kezdo meglatogatandokkal valo feltoltes
							if (m.SzomszedokLekerdez(Irany.JOBBRA) != null)
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
								latogatando.add(m.SzomszedokLekerdez(Irany.JOBBRA));
							// Kezdo meglatogatandokkal valo feltoltes
							if (m.SzomszedokLekerdez(Irany.BALRA) != null)
								latogatando.add(m.SzomszedokLekerdez(Irany.BALRA));
							// Kezdo meglatogatandokkal valo feltoltes
							if (m.SzomszedokLekerdez(Irany.FEL) != null)
								latogatando.add(m.SzomszedokLekerdez(Irany.FEL));
							// Kezdo meglatogatandokkal valo feltoltes
							if (m.SzomszedokLekerdez(Irany.LE) != null)
								latogatando.add(m.SzomszedokLekerdez(Irany.LE));

							while (latogatando.size() == 0) {
								m = latogatando.get(0);

								// Ha van rajt munkas akkor visszater azzal hogy
								// meg nem ert veget a jatek
								if (m.getMunkas() != null)
									return false;

								if (m.getLada() == null) {
									if (m instanceof Mezo || m instanceof Cel || m instanceof Lyuk
											|| m instanceof Kapcsolo) {
										// Megnezi hogy az adott mezok voltak e
										// mar ha igen nem adja oket a
										// latogatando listahoz
										boolean egyezik = false;
										for (int in = 0; in < latogatott.size(); in++) {
											if (m.SzomszedokLekerdez(Irany.JOBBRA) == latogatott.get(in))
												egyezik = true;
										}
										if (egyezik == false && m.SzomszedokLekerdez(Irany.JOBBRA) != null)
											latogatando.add(m.SzomszedokLekerdez(Irany.JOBBRA));
										egyezik = false;
										// Balra levo mezo
										for (int in = 0; in < latogatott.size(); in++) {
											if (m.SzomszedokLekerdez(Irany.BALRA) == latogatott.get(in))
												egyezik = true;
										}
										if (egyezik == false && m.SzomszedokLekerdez(Irany.BALRA) != null)
											latogatando.add(m.SzomszedokLekerdez(Irany.BALRA));
										egyezik = false;
										// Fel levo mezo
										for (int in = 0; in < latogatott.size(); in++) {
											if (m.SzomszedokLekerdez(Irany.FEL) == latogatott.get(in))
												egyezik = true;
										}
										if (egyezik == false && m.SzomszedokLekerdez(Irany.FEL) != null)
											latogatando.add(m.SzomszedokLekerdez(Irany.FEL));
										egyezik = false;

										// Le levo mezo
										for (int in = 0; in < latogatott.size(); in++) {
											if (m.SzomszedokLekerdez(Irany.LE) == latogatott.get(in))
												egyezik = true;
										}
										if (egyezik == false && m.SzomszedokLekerdez(Irany.LE) != null)
											latogatando.add(m.SzomszedokLekerdez(Irany.LE));
									}
									latogatando.remove(0);
<<<<<<< HEAD
									//System.out.println("Latogatando:"+latogatando.size());
=======
									System.out.println("Latogatando:" + latogatando.size());
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
								}
							}

						}
					}

				}
				// Palya visszaalitasa a kezdo palyara
				jatekvm = mezok;
				// INdex novelese a vizsgalt iranyokra
				index += 1;
			}
			i += 1;
		}
<<<<<<< HEAD
		i = 0;
		tolhato = false;
		while(!Vanelada && i < jatekvm.size()){
			Mezo me = jatekvm.get(i);
			if (me.getLada() != null) {
				Vanelada= true;
				tolhato = true;
			}
			i++;
		}
		if(this.vege==true) {
			tolhato = false;
			System.out.println("VÉGE");
		}
		return !tolhato;
=======

		return !vanTolhatoLada;
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
	}
	
	
}
