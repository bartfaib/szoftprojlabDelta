
public class Lada {
	private Mezo indulo;
	
	Kimenetel Mozog(Irany i){
		System.out.println("Lada mozog");
		
		Mezo szomszed = indulo.SzomszedokLekerdez(i);
		
		Kimenetel k = szomszed.Mozog(i);
		
		if(szomszed.Mozog(i) == Kimenetel.Mozoghat || szomszed.Mozog(i) == Kimenetel.PontotErt) {
			szomszed.Add(this);
			indulo.Torol();
			System.out.println("Mozoghat a Lada");
		}else {
			System.out.println("Nem mozoghat a Lada");
		}
		
		return k;
	}

}
