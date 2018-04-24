

public class Munkas{
	private String nev;
	private int pontok;
	private int lepett;
	private boolean kezdo;
	private boolean elet;
	private Mezo indulo;
	private boolean teszt = true;	
	
	public void setTeszt (boolean t) { teszt = t; }
	
	public void setKezdo  (boolean k) { kezdo = k; }
	
	
	public void addOlaj() {
		indulo.setOlaj();
	}
	
	public void addMez() {
		indulo.setMez();
	}
	public Kimenetel Mozog (Irany i) {
		if( i == null) System.out.println(this.nev + " Munkas mozog" + i);
		
		
		Mezo szomszed = indulo.SzomszedokLekerdez(i);
		Kimenetel k = szomszed.Mozog(i);
		
		if(k == Kimenetel.Mozoghat || k == Kimenetel.PontotErt) {
			szomszed.Add(this);
			indulo.Torol();
			if(k == Kimenetel.PontotErt && this.kezdo == true) {
				this.pontok +=1;
				System.out.println(this.nev + " Kapott"+"1 pontot igy van :"+this.pontok);
			}
		}else {
			if (this.kezdo == false) {
				this.Halal();
				indulo.Torol();
				if( teszt) System.out.println(this.nev + " Munkas mozog Return Mozoghat");
				return Kimenetel.Mozoghat;
			}			
		}
		if( teszt) System.out.println(this.nev+" Munkas mozog Return"+k);
		return k;
		
	}
	
	public void Halal () {
		this.elet = false;
		System.out.println(this.nev + " Munkas Meghalt");
	}
	
	public boolean Elet() {
		return elet;
	}
	
	public Munkas (String n, Mezo i) {
		if( teszt) System.out.println(n + "Munkas osztály ctor");
		this.nev = n;
		this.pontok = 0;
		this.lepett = 0;
		this.kezdo = false;
		this.elet = true;
		this.indulo = i;
	}
	
	public Munkas (String n, Mezo i, boolean a) {
		if( teszt) System.out.println(n + "Munkas osztály ctor");
		this.nev = n;
		this.pontok = 0;
		this.lepett = 0;
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
