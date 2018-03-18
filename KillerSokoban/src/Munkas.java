

public class Munkas{
	private String nev;
	private int pontok;
	private int lepett;
	private boolean kezdo;
	private boolean elet;
	private Mezo indulo;
	
	public Kimenetel Mozog (Irany i) {
		System.out.println(this.nev + " Munkas mozog");
		
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
				System.out.println(this.nev + " Munkas mozog Return Mozoghat");
				return Kimenetel.Mozoghat;
			}			
		}
		System.out.println(this.nev+" Munkas mozog Return"+k);
		return k;
		
	}
	
	public void Halal () {
		this.elet = false;
		System.out.println(this.nev + " Munkas Meghalt");
	}
	
	public Munkas (String n, Mezo i) {
		System.out.println("Munkas osztály ctor");
		this.nev = n;
		this.pontok = 0;
		this.lepett = 0;
		this.kezdo = false;
		this.elet = true;
		this.indulo = i;
	}
	
	public Munkas (String n, Mezo i, boolean a) {
		System.out.println("Munkas osztály ctor");
		this.nev = n;
		this.pontok = 0;
		this.lepett = 0;
		this.kezdo = a;
		this.elet = true;
		this.indulo = i;
	}	
	
}
