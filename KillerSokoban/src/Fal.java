import java.util.ArrayList;
import java.util.List;

public class Fal extends Mezo {
	//Ures konstruktor
	private boolean teszt = false;	

	public void setTeszt (boolean t) { teszt = t; }
	public Fal(){
		
		if(teszt)System.out.println("Fal osztaly ctor");
		this.szomszedok = new ArrayList<Mezo>();
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
	}
	
	public Fal(List<Mezo> szomsz) {
		super(szomsz);	
		if(teszt)System.out.println("Fal Ctor");
	}
	public Kimenetel Mozog(Irany i){
		if(teszt)System.out.println("Fal mozog " + i);
		if(teszt)System.out.println("Fal Return Nem mozoghat");
		return Kimenetel.NemMozoghat;
	}
}
