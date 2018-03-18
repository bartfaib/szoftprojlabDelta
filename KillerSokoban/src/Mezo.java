
import java.util.ArrayList;
import java.util.List;
public class Mezo {
	private Munkas munkas;
	private Lada lada;
	protected List<Mezo> szomszedok;
	
	public Kimenetel Mozog ( Irany i ) {
		System.out.println("Mezo MOZOG "+ i);
		//csak a kiiras miatt kell felvenni
		Kimenetel k = null;
		
		if(lada != null) {
			k = lada.Mozog(i);
			
			System.out.println("Mezo mozog Return"+k);
			return k;
		}else if (munkas != null) {
			k = munkas.Mozog(i);
			System.out.println("Mezo Mozog Return "+k);
			return k;
		}else {
			System.out.println("Mezo Mozog Return Mozoghat");
			return Kimenetel.Mozoghat;
		}
	}
	public Mezo SzomszedokLekerdez ( Irany i ){
		System.out.println("Szomszedok Lekerdez "+i);
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
	
	//szomszed hozzaadasa
	public void setSzomszed(Irany i, Mezo m){
		szomszedok.add(i.getValue(),m);
	}
	
	
	public void Torol () {
		System.out.println("Mezo TOROL");
		this.munkas=null;
		this.lada=null;
	}
	//Ures konstruktor
	public Mezo(){
		System.out.println("Mezo osztaly ctor");
		this.szomszedok = new ArrayList<Mezo>();
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		this.lada = null;
		this.munkas = null;
	}
	
	public Mezo(List<Mezo> szomsz, Lada l){
	System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomsz;
		this.lada = l;
		this.munkas = null;
	}
	
	public Mezo(List<Mezo> szomsz, Munkas m){
	System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomsz;
		this.lada = null;
		this.munkas = m;
	}
	
	public Mezo(List<Mezo> szomsz){
	System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomsz;
		this.lada = null;
		this.munkas = null;
	}
	
	public Munkas getMunkas() {
		return this.munkas;
	}
	
	public void setMunkas(Munkas m) {
		this.munkas = m;
	}
	
	public Munkas getLada() {
		return this.munkas;
	}
	
	public void setLada(Lada l) {
		this.lada = l;
	}
	
	public List<Mezo> getSzomsz(){
		return this.szomszedok;
	}
}
