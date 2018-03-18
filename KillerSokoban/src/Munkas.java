

public class Munkas{
	private String nev;
	private int pontok;
	private int lepett;
	private boolean kezdo;
	private boolean elet;
	private Mezo indulo;
	
	public Kimenetel Mozog (Irany i) {
		System.out.println(nev+" "+"Munkas mozog");
		
		Mezo szomszed = indulo.SzomszedokLekerdez(i);
		Kimenetel k = szomszed.Mozog(i);
		if(k == Kimenetel.Mozoghat || k == Kimenetel.PontotErt) {
			szomszed.Add(this);
			indulo.Torol();
			if(k == Kimenetel.PontotErt && this.kezdo == true) {
				this.pontok +=1;
				System.out.println(nev+"Kapott"+"1 pontot igy van :"+this.pontok);
			}
			System.out.println("Mozoghat a munkas");
		}else {
			System.out.println("Nem mozoghat a munkas");
		}
		
		return k;
		
	}
	
	public void Halal () {
		
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
	
}
