
import java.util.List;
public class Mezo {
	private Munkas munkas;
	private Lada lada;
	private List<Mezo> szomszedok;
	
	public Kimenetel Mozog ( Irany i ) {
		System.out.println("Mezo MOZOG "+ i);
		
		if(lada != null) {			
			return lada.Mozog(i);
		}else if (munkas != null) {
			return munkas.Mozog(i);
		}else {
			return Kimenetel.Mozoghat;
		}
	}
	public Mezo SzomszedokLekerdez ( Irany i ){
		System.out.println("Szomszedok Lekerdez : "+i+" iranyba");
		return szomszedok.get(i.getValue());		
	}
	
	public void Add (Munkas m) {
		System.out.println("Mezo ADD Munkas");
		this.munkas=m;
	}	

	public void Add (Lada l) {
		System.out.println("Mezo ADD Lada");
		this.lada=l;
	}
	
	
	public void Torol () {
		System.out.println("Mezo TOROL");
		this.munkas=null;
		this.lada=null;
	}
	
	public Mezo(List<Mezo> szomsz, Lada l, Munkas m){
	System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomszedok;
		this.lada = l;
		this.munkas = m;
	}
	
	public Mezo(List<Mezo> szomsz, Lada l){
	System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomszedok;
		this.lada = l;
		this.munkas = null;
	}
	
	public Mezo(List<Mezo> szomsz, Munkas m){
	System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomszedok;
		this.lada = null;
		this.munkas = m;
	}
	
	public Mezo(List<Mezo> szomsz){
	System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomszedok;
		this.lada = null;
		this.munkas = null;
	}
	
}
