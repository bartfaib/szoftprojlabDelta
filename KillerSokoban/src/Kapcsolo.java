import java.util.List;

public class Kapcsolo extends Mezo {
	
	private Lyuk lyuk;
	
	public Kapcsolo(List<Mezo> szomsz) {
		super(szomsz);
		System.out.println("Kapcsolo Ctor");
	}
	
	public Kimenetel Mozog(Irany i){
		System.out.println("Kapcsolo MOZOG "+ i);
		
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
		System.out.println("Kapcs ADD munkas");
		this.setMunkas(m);		
	}
	
	public void Add(Lada l){
		System.out.println("Kapcs ADD lada");
		this.setLada(l);		
	}
	
	public void Torol(){
		System.out.println("Kapcsolo Torol");
		this.setLada(null);
		this.setMunkas(null);
	}
}
