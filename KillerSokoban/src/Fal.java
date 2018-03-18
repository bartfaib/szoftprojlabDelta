import java.util.ArrayList;
import java.util.List;

public class Fal extends Mezo {
	//Ures konstruktor
	public Fal(){
		System.out.println("Fal osztaly ctor");
		this.szomszedok = new ArrayList<Mezo>();
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
	}
	
	public Fal(List<Mezo> szomsz) {
		super(szomsz);
		System.out.println("Fal Ctor");
	}
	public Kimenetel Mozog(Irany i){
		System.out.println("Fal mozog " + i);
		System.out.println("Fal Return Nem mozoghat");
		return Kimenetel.NemMozoghat;
	}
}
