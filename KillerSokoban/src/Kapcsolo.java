import java.util.ArrayList;
import java.util.List;

public class Kapcsolo extends Mezo {
	
	private Lyuk lyuk = null;
	private boolean teszt = false;	
	
	public void setTeszt (boolean t) { teszt = t; }
	//Ures konstruktor
	public Kapcsolo(){
		if( teszt) System.out.println("Kapcsolo osztaly ctor");
		this.szomszedok = new ArrayList<Mezo>();
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
	}
	
	public Kapcsolo(List<Mezo> szomsz) {
		super(szomsz);
		lyuk = null;
		if( teszt) System.out.println("Kapcsolo Ctor");
	}
	
	public Kimenetel Mozog(Irany i){
		if( teszt) System.out.println("Kapcsolo MOZOG "+ i);
		
		if(this.getLada() != null) {
			if( teszt) System.out.println("Kapcsolo mozog Return"+this.getLada().Mozog(i));
			return this.getLada().Mozog(i);
		}else if (this.getMunkas() != null) {
			if( teszt) System.out.println("Kapcsolo mozog Return"+this.getMunkas().Mozog(i));
			return this.getMunkas().Mozog(i);
		}else {
			if( teszt) System.out.println("Kapcsolo mozog Return Mozoghat");
			return Kimenetel.Mozoghat;
		}
	}
	
	public void Add(Munkas m){
		if( teszt) System.out.println("Kapcs ADD munkas");
		super.Add(m);		
	}
	
	public void Add(Lada l){
		if( teszt) System.out.println("Kapcs ADD lada");
		super.Add(l);
		if(lyuk != null )this.lyuk.setStateTrue();
	}
	
	public void Torol(){
		if( teszt) System.out.println("Kapcsolo Torol");
		if(lyuk != null )this.lyuk.setStateFalse();
		super.Torol();
	}
	
	public void setLyuk(Lyuk l) {
		this.lyuk = l;
	}
	
	public Lyuk getLyuk() {
		return this.lyuk;
	}
}
