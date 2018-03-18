import java.util.ArrayList;
import java.util.List;

public class Lyuk extends Mezo {
private boolean Nyitott = false;
 
//Ures konstruktor
public Lyuk(){
	System.out.println("Lyuk osztaly ctor");
	this.szomszedok = new ArrayList<Mezo>();
	szomszedok.add(null);
	szomszedok.add(null);
	szomszedok.add(null);
	szomszedok.add(null);
}

public Lyuk(List<Mezo> szomsz, boolean nyit) {
	super(szomsz);
	System.out.println("Lyuk Ctor");
	this.Nyitott =nyit;
}

public Lyuk(boolean nyit) {
	System.out.println("Lyuk Ctor" + nyit);
	this.Nyitott =nyit;
}
 public Kimenetel Mozog(Irany i){
		System.out.println("Lyuk MOZOG "+ i);
		
		if(this.getLada() != null) {
			System.out.println("Lyuk mozog Return"+this.getLada().Mozog(i));
			return this.getLada().Mozog(i);
		}else if (this.getMunkas() != null) {
			System.out.println("Lyuk mozog Return"+this.getMunkas().Mozog(i));
			return this.getMunkas().Mozog(i);
		}else {
			System.out.println("Lyuk mozog Return Mozoghat");
			return Kimenetel.Mozoghat;
		}
 }
 
 public void Add(Munkas m){
	 if(this.Nyitott == true) {
		System.out.println("Lyuk ADD munkas Nyitott");
		m.Halal();
	 } else {
			System.out.println("Lyuk ADD munkas Zart");
			this.setMunkas(m);
	 }
 }
	 
 
 public void Add(Lada l){
	 if(this.Nyitott == true) {
		System.out.println("Cel ADD lada Nyitott");
		this.setLada(null);
	 } else {
			System.out.println("Lyuk ADD lada Zart");
			this.setLada(l);
	 }
 }
 
	public void Torol(){
		System.out.println("Lyuk Torol");
		this.setLada(null);
		this.setMunkas(null);
	}
 
}
