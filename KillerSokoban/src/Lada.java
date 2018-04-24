
public class Lada {
	private Mezo indulo;
	private boolean teszt = false;	
	
	public void setTeszt (boolean t) { teszt = t; }
	public void setIndulo(Mezo indulo){
		this.indulo = new Mezo();
		this.indulo = indulo;
	}
	
	Kimenetel Mozog(Irany i){
		if( teszt) System.out.println("Lada mozog");
		Mezo szomszed = indulo.SzomszedokLekerdez(i);
		
		Kimenetel k = szomszed.Mozog(i);
		
		if(k == Kimenetel.Mozoghat || k == Kimenetel.PontotErt) {
			szomszed.Add(this);
			indulo.Torol();
		}
		if( teszt) System.out.println("Lada Mozog Return " +k);
		return k;
	}

}
