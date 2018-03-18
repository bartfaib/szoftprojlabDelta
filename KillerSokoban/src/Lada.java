
public class Lada {
	private Mezo indulo;
	
	Kimenetel Mozog(Irany i){
		System.out.println("Lada mozog");
		
		Mezo szomszed = indulo.SzomszedokLekerdez(i);
		
		Kimenetel k = szomszed.Mozog(i);
		
		if(szomszed.Mozog(i) == Kimenetel.Mozoghat || szomszed.Mozog(i) == Kimenetel.PontotErt) {
			szomszed.Add(this);
			indulo.Torol();
			System.out.println("Return Mozoghat a Lada");
		}else {
			System.out.println("Return Nem mozoghat a Lada");
		}
		
		return k;
	}

}
