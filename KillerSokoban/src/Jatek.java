import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jatek {
	private List<Munkas> munkasok;
	private static List<Mezo> mezok;

	public Jatek(List<Mezo> palya, List<String> jatekosok) {
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
					if (mezok.get(i) instanceof Fal || mezok.get(i) instanceof Lyuk || mezok.get(i) instanceof Cel) {

					} else if (mezok.get(i) instanceof Mezo) {
						if (mezok.get(i).getLada() == null && mezok.get(i).getMunkas() == null) {
							talalt = true;
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
				} else if (palya[x][y] instanceof Lyuk) {
					if (palya[x][y].getNyitva() == true) {
						System.out.print("Y");
					} else {
						System.out.print("X");

					}
				} else if (palya[x][y] instanceof Cel) {
					if (palya[x][y].getLada() != null) {
						System.out.print("L");
					} else if (palya[x][y].getMunkas() != null) {
						Munkas mu = palya[x][y].getMunkas();
						for (int in = 0; in < munkasok.size(); in++) {
							if (munkasok.get(in) == mu)
								System.out.print(in);
						}
					} else {
						System.out.print("C");
					}
				} else if (palya[x][y] instanceof Mezo) {
					if (palya[x][y].getLada() != null) {
						System.out.print("L");
					} else if (palya[x][y].getMunkas() != null) {
						Munkas mu = palya[x][y].getMunkas();
						for (int in = 0; in < munkasok.size(); in++) {
							if (munkasok.get(in) == mu)
								System.out.print(in);
						}
					} else if (palya[x][y].getOlaj()) {
						System.out.print("O");
					} else if (palya[x][y].getMez()) {
						System.out.print("E");
					} else {
						System.out.print("-");
					}
				}
			}
			System.out.print("\n");
		}
		for (int index = 0; index < munkasok.size(); index++) {
			if(munkasok.get(index).Elet() == false) {
				System.out
				.println(munkasok.get(index).getNev() + " (" + index + ") doglott, pont: " + munkasok.get(index).getPont());
			} else {
				System.out
				.println(munkasok.get(index).getNev() + " (" + index + ") elo, pont: " + munkasok.get(index).getPont());
			}
		}
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

				switch (felhasznaloiParancs) {
				case ("w"): {
					mozgasiIrany = Irany.FEL;
					vanErvenyesParancs = true;
				}
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

				case ("m"): {
					mozgasiIrany = null;
					munkasok.get(aktivMunkas).addMez();
					vanErvenyesParancs = true;
				}
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

			// Ha a kovetkezo parancsot kapta a program vagy megdoglott a munkasunk
			if (felhasznaloiParancs.equals("") || munkasok.get(aktivMunkas).Elet() == false) {
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
					}
				}
			}
		}

		// Jç–¸é§ť vé¦®e kiiratáok
		// JAtek vegen a gyoztes meghatarozasa
		Munkas[] eredmeny = new Munkas[munkasok.size()];
		int n = eredmeny.length;

		for (int index = 0; index < n; index++) {
			eredmeny[index] = munkasok.get(index);
		}
		Munkas temp;
		// sorba rakja oket
		for (int index = 0; index < n; index++) {
			for (int j = 1; j < (n - index); j++) {

				if (eredmeny[j - 1].getPont() > eredmeny[j].getPont()) {
					temp = eredmeny[j - 1];
					eredmeny[j - 1] = eredmeny[j];
					eredmeny[j] = temp;
				}

			}
		}
		// Eredmenyek kiirasa
		int helyezett = 1;
		for (int index = 0; index < n; index++) {
			if (index == 0) {
				System.out.println(helyezett + ". lett:" + eredmeny[index].getNev());
			} else {
				// Ha a kovetkezonek kevesebb pontja van akkor a helyezes
				// szamanka novelese
				if (eredmeny[index - 1].getPont() > eredmeny[index].getPont())
					helyezett += 1;
				System.out.println(helyezett + ". lett:" + eredmeny[index].getNev());
			}
		}
	}

	boolean JatekVege() {
		// Elosszor megvizsgalja hogy van-e meg elo munkas
		boolean vanEloMunkas = false;
		for (int i = 0; i < munkasok.size(); i++) {
			if (munkasok.get(i).Elet() == true)
				vanEloMunkas = true;
		}

		// Ha nincs elo munkas falsal ter vissza ami a jatek vegétjelenti
		if (!vanEloMunkas)
			return true;

		boolean vanTolhatoLada = false;
		int i = 0;
		Mezo m = null;
		List<Mezo> jatekvm = new ArrayList<Mezo>();
		jatekvm = mezok;

		while (vanTolhatoLada == false && i < mezok.size()) {
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

				// megnezi hogy mozoghat e a lada es ha igen az ellentetes
				// oldalon milyen mezo van

				Kimenetel k = m.Mozog(elso);
				if (k == Kimenetel.Mozoghat || k == Kimenetel.PontotErt) {
					if (m.SzomszedokLekerdez(ellentetes) instanceof Mezo
							|| m.SzomszedokLekerdez(ellentetes) instanceof Kapcsolo
							|| m.SzomszedokLekerdez(ellentetes) instanceof Cel
							|| m.SzomszedokLekerdez(ellentetes) instanceof Lyuk) {
						// MEzo a kezdo vizsgalt mezore allitasa
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
							// Kezdo meglatogatandokkal valo feltoltes
							if (m.SzomszedokLekerdez(Irany.JOBBRA) != null)
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
									System.out.println("Latogatando:" + latogatando.size());
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

		return !vanTolhatoLada;
	}
}
