
public class Munkas {
	private String nev;
	private int pontok;
	private boolean kezdo;
	private boolean elet;
	private Mezo indulo;
	private boolean teszt = false;

	public void setTeszt(boolean t) {
		teszt = t;
	}

	public void setKezdo(boolean k) {
		kezdo = k;
	}

	public void setIndulo(Mezo m) {
		this.indulo = m;
	}

	public void addOlaj() {
		indulo.setOlaj();
	}

	public void addMez() {
		indulo.setMez();
	}
	public Kimenetel Mozog (Irany i,int tomeg) {
		if( i == null) System.out.println(this.nev + " Munkas mozog" + i);
		
		
		Mezo szomszed = indulo.SzomszedokLekerdez(i);
		Kimenetel k = szomszed.Mozog(i, 60);
		
		if(k == Kimenetel.Mozoghat || k == Kimenetel.PontotErt) {
			Mezo korabbi = indulo;
			szomszed.Add(this);
			korabbi.Torol();
			if (k == Kimenetel.PontotErt && this.kezdo == true) {
				this.pontok += 1;
			}
		} else {
			if (this.kezdo == false) {
				this.Halal();
				if( teszt) System.out.println(this.nev + " Munkas mozog Return Mozoghat");
				return Kimenetel.Mozoghat;
			}
		}
		if (teszt)
			System.out.println(this.nev + " Munkas mozog Return" + k);
		return k;

	}

	public void Halal() {
		this.elet = false;
		indulo.Torol();
		System.out.println(this.nev + " Munkas Meghalt");
	}

	public boolean Elet() {
		return elet;
	}

	public Munkas(String n, Mezo i) {
		if (teszt)
			System.out.println(n + "Munkas oszt�ly ctor");
		this.nev = n;
		this.pontok = 0;
		this.kezdo = false;
		this.elet = true;
		this.indulo = i;
	}

	public Munkas(String n, Mezo i, boolean a) {
		if (teszt)
			System.out.println(n + "Munkas oszt�ly ctor");
		this.nev = n;
		this.pontok = 0;
		this.kezdo = a;
		this.elet = true;
		this.indulo = i;
	}

	public int getPont() {
		return pontok;
	}

	public String getNev() {
		return nev;
	}

}
