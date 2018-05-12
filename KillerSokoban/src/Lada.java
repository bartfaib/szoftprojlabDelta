
public class Lada {
	private Mezo indulo;
	private boolean teszt = false;
	
	public void setTeszt (boolean t) { teszt = t; }
	public void setIndulo(Mezo indulo){
		this.indulo = new Mezo();
		this.indulo = indulo;
	}
	
	Kimenetel Mozog(Irany i,int tomeg){
		if( teszt) System.out.println("Lada mozog");
		Mezo szomszed = indulo.SzomszedokLekerdez(i);
		if(this.indulo.getOlaj()) {
			tomeg-=20*0.5;
		}else if(this.indulo.getMez()) {
			tomeg-=20*2;
		}else tomeg-=20;
		
		if(tomeg < 0) {
			return Kimenetel.NemMozoghat;
		}
		Kimenetel k = szomszed.Mozog(i,tomeg);

		if(k == Kimenetel.Mozoghat || k == Kimenetel.PontotErt) {
			Mezo korabbi = indulo;
			szomszed.Add(this);
			korabbi.Torol();
		}
		if (teszt)
			System.out.println("Lada Mozog Return " + k);
		return k;
	}

}
