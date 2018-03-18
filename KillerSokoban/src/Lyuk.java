import java.util.List;

public class Lyuk extends Mezo {
private boolean Nyitott = false;
 
 
public Lyuk(List<Mezo> szomsz) {
	super(szomsz);
	System.out.println("Lyuk Ctor");
}


 public Kimenetel Mozog(Irany i){
		System.out.println("Mezo MOZOG "+ i);
		
		if(this.getLada() != null) {
			System.out.println("Kapcsolo mozog Return"+this.getLada().Mozog(i));
			return this.getLada().Mozog(i);
		}else if (this.getMunkas() != null) {
			System.out.println("Kapcsolo mozog Return"+this.getMunkas().Mozog(i));
			return this.getMunkas().Mozog(i);
		}else {
			System.out.println("Kapcsolo mozog Return Mozoghat");
			return Kimenetel.Mozoghat;
		}
 }
 
 public void Add(Munkas m){
	 if(this.Nyitott == true) {
		System.out.println("Lyuk ADD munkas Nyitott");
		this.getMunkas().Halal();
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
