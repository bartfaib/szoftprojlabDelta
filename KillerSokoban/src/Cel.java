import java.util.ArrayList;
import java.util.List;

public class Cel extends Mezo {
	
	//Ures konstruktor
	public Cel(){
		System.out.println("Cel osztaly ctor");
		this.szomszedok = new ArrayList<Mezo>();
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
	}
	
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
	//a mozog irannyal ellentetes irany meghatarozasa
	private int iranyEllentetes(Irany i){
		switch(i.getValue()){
		case 0:
			return 2;
		case 1:
			return 3;
		case 2:
			return 0;
		case 3:
			return 1;
		default:
			break;
		}
		return 0;
	}
	
	public Kimenetel Mozog(Irany i){
		System.out.println("Cel Mozog");
		if (this.getMunkas()!= null) {
			if (this.getMunkas().Mozog(i) != Kimenetel.NemMozoghat) {
				if (this.getSzomsz().get(iranyEllentetes(i)).getLada() != null) { //-2 kell mert ellent騁es ir疣yb j k駻dezek Felt騁el ( ha mtem l疆a val)
					System.out.println("Cel Return PontotErt");
					return Kimenetel.PontotErt;
				}
			}
			System.out.println("Cel Return"+this.getMunkas().Mozog(i));
			return this.getMunkas().Mozog(i);
		}
		if (this.getSzomsz().get(iranyEllentetes(i)).getLada() == null) {//itt ez valamiért nem jó == != kellene ide de mégis az == vel működik úgy ahogy kéne neki //-2 kell mert ellent騁es ir疣yb j k駻dezek Felt騁el ( ha mtem l疆a val)
			System.out.println("Cel Return PontotErt ");
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
