import java.util.List;

public class Fal extends Mezo {
	
	public Fal(List<Mezo> szomsz) {
		super(szomsz);
		System.out.println("Fal Ctor");
	}
	public Kimenetel Mozog(Irany i){
		System.out.println("Fal Return Nem mozoghat");
		return Kimenetel.NemMozoghat;
	}
}
