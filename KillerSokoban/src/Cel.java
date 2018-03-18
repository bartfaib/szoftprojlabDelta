import java.util.List;

public class Cel extends Mezo {
	public Cel(List<Mezo> szomsz) {
		super(szomsz);
		System.out.println("Cel Ctor");
	}
	
	public Cel(List<Mezo> szomsz, Lada l) {
		super(szomsz, l);
		System.out.println("Cel Ctor");
	}
	
	public Cel(List<Mezo> szomsz, Munkas m) {
		super(szomsz, m);
		System.out.println("Cel Ctor");
	}
	
	public Kimenetel Mozog(Irany i){
		System.out.println("Cel Mozog");
		if (this.getMunkas()!= null) {
			if (this.getMunkas().Mozog(i) != Kimenetel.NemMozoghat) {
				if (this.getSzomsz().get(i.getValue()-2).getLada() != null) { //-2 kell mert ellentétes irányból jövõt kérdezek Feltétel ( ha mögöttem láda val)
					System.out.println("Cel Return PontotErt");
					return Kimenetel.PontotErt;
				}
			}
			System.out.println("Cel Return"+this.getMunkas().Mozog(i));
			return this.getMunkas().Mozog(i);
		}
		if (this.getSzomsz().get(i.getValue()-2).getLada() != null) { //-2 kell mert ellentétes irányból jövõt kérdezek Feltétel ( ha mögöttem láda val)
			System.out.println("Cel Return PontotErt");
			return Kimenetel.PontotErt;
		}
		System.out.println("Cel Return Mozoghat");
		return Kimenetel.Mozoghat;
	}
	public void add(Munkas m){
		System.out.println("Cel ADD munkas");
		this.setMunkas(m);
	}
	public void add(Lada l){
		System.out.println("Cel ADD lada");
		this.setLada(l);
	}
	

}
