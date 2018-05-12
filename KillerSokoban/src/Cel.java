import java.util.ArrayList;
import java.util.List;

public class Cel extends Mezo {
	private boolean teszt = false;

	public void setTeszt(boolean t) {
		teszt = t;
	}

	// Ures konstruktor
	public Cel() {
		if (teszt)
			System.out.println("Cel osztaly ctor");
		this.szomszedok = new ArrayList<Mezo>();
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
	}

	public Cel(List<Mezo> szomsz) {
		super(szomsz);
		if (teszt)
			System.out.println("Cel Ctor");
	}

	public Cel(List<Mezo> szomsz, Lada l) {
		super(szomsz, l);
		if (teszt)
			System.out.println("Cel Ctor");
	}

	public Cel(List<Mezo> szomsz, Munkas m) {
		super(szomsz, m);
		if (teszt)
			System.out.println("Cel Ctor");
	}

	// a mozog irannyal ellentetes irany meghatarozasa
	private int iranyEllentetes(Irany i) {
		switch (i.getValue()) {
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
	public Kimenetel Mozog(Irany i,int tomeg){
		if( teszt) System.out.println("Cel Mozog");
		
		if (this.getMunkas()!= null) {
				if (this.getMunkas().Mozog(i,tomeg) != Kimenetel.NemMozoghat) {
				if (this.getSzomsz().get(iranyEllentetes(i)).getLada() != null) {
					if (teszt)
						System.out.println("Cel Return PontotErt");
					return Kimenetel.PontotErt;
				}
				this.Torol();
			}
			if( teszt) System.out.println("Cel Return"+this.getMunkas().Mozog(i,tomeg));
		}

		if (this.getSzomsz().get(iranyEllentetes(i)).getLada() != null) {
			if (teszt)
				System.out.println("Cel Return PontotErt ");
			return Kimenetel.PontotErt;
		}

		if (teszt)
			System.out.println("Cel Return Mozoghat");
		return Kimenetel.Mozoghat;
	}

	public void Add(Lada l) {
		if (teszt)
			System.out.println("Cel ADD lada");
		this.setLada(null);
	}

}
