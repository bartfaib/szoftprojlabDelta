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
		ArrayList<String> List = new ArrayList<String>();

		try {
			tempAlpha = new Scanner(new File(System.getProperty("user.dir") + "\\Maps\\Sample\\" + fileName));

			while (tempAlpha.hasNextLine()) {
				Scanner tempBeta = new Scanner(tempAlpha.nextLine());
				while (tempBeta.hasNext()) {
					String s = tempBeta.next();
					List.add(s);
				}
				tempBeta.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			tempAlpha.close();
		}

		return List;
	}

	public ArrayList<Mezo> Beolvasas() {
		int zs = 0;
		boolean teszt = false;
		// System.out.println("Beolvas");

		ArrayList<String> List = new ArrayList<String>(Init());
		ArrayList<Mezo> mezok = new ArrayList<Mezo>();
		ArrayList<Kapcsolo> kapcsolok = new ArrayList<Kapcsolo>();
		ArrayList<Lyuk> lyukak = new ArrayList<Lyuk>();

		for (int i = 0; i < List.size(); i++) {
			char[] betuk = List.get(i).toCharArray();

			for (int j = 0; j < betuk.length; j++) {
				switch (betuk[j]) {
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

				case 'E': {
					Mezo m = new Mezo();
					m.setOlaj();
					mezok.add(m);

				}

				case 'Z': {
					Mezo m = new Mezo();
					m.setMez();
					mezok.add(m);

				}
					break;

				default:
					break;

				}

				if (i == 0) { // Elsõ sor
					if (j != 0) {
						// System.out.print("Set Balra + Jobbra");
						mezok.get(j).setSzomszed(Irany.BALRA, mezok.get(j - 1));
						mezok.get(j - 1).setSzomszed(Irany.JOBBRA, mezok.get(j));
						zs++;
						if (betuk[j] == 'L') {
							mezok.get(j).getLada().setIndulo(mezok.get(j));
						}
					}
				}
				if (i > 0) { // Nem elsõ sor
					int r = i * betuk.length;
					int rm = (i - 1) * betuk.length;
					// System.out.println(r+" "+i+" "+ rm + " " + j + "
					// "+mezok.size());
					if (j == 0) { // Elsõ eleme
						// System.out.print("Set Le + Fel");
						mezok.get(rm + j).setSzomszed(Irany.LE, mezok.get(r + j));
						mezok.get(r + j).setSzomszed(Irany.FEL, mezok.get(rm + j));
						zs++;
						if (betuk[j] == 'L') {
							mezok.get(r + j).getLada().setIndulo(mezok.get(r + j));
						}
					}
					if (j != 0) { // NEM elsõ elem
						// System.out.print("Set Balra + Jobbra + le + fel");
						mezok.get(rm + j).setSzomszed(Irany.LE, mezok.get(r + j));
						mezok.get(r + j).setSzomszed(Irany.FEL, mezok.get(rm + j));
						mezok.get(r + j).setSzomszed(Irany.BALRA, mezok.get(r + j - 1));
						mezok.get(r + j - 1).setSzomszed(Irany.JOBBRA, mezok.get(r + j));
						zs++;
						if (betuk[j] == 'L') {
							mezok.get(r + j).getLada().setIndulo(mezok.get(r + j));
						}

					}
				}
			}

		}

		for (int i = 0; i < mezok.size(); i++) {
			// System.out.println(i + mezok.get(i).szomszedok.size());
			for (int j = 0; j < mezok.get(i).szomszedok.size(); j++) {
				// System.out.print(j);

			}
			// System.out.println("\n");
		}
		// System.out.println("Beolvas Vege " + zs);
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
