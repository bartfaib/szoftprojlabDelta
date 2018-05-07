import java.util.ArrayList;
import java.util.List;

public class Lyuk extends Mezo {
<<<<<<< HEAD
private boolean Nyitott = true;
=======
	private boolean teszt = false;
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df

	public void setTeszt(boolean t) {
		teszt = t;
	}

	// Ures konstruktor
	public Lyuk() {
		if (teszt)
			System.out.println("Lyuk osztaly ctor");
		this.szomszedok = new ArrayList<Mezo>();
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
	}

	public Lyuk(List<Mezo> szomsz, boolean nyit) {
		super(szomsz);
		if (teszt)
			System.out.println("Lyuk Ctor");
		this.Nyitott = nyit;
	}

<<<<<<< HEAD
public Lyuk(boolean nyit) {
	if( teszt) System.out.println("Lyuk Ctor" + nyit);
	this.Nyitott =nyit;
}
 public Kimenetel Mozog(Irany i,int tomeg){
		if( teszt) System.out.println("Lyuk MOZOG "+ i);
		
		if(this.getLada() != null) {
			if( teszt) System.out.println("Lyuk mozog Return"+this.getLada().Mozog(i,tomeg));
			return this.getLada().Mozog(i,tomeg);
		}else if (this.getMunkas() != null) {
			if( teszt) System.out.println("Lyuk mozog Return"+this.getMunkas().Mozog(i,tomeg));
			return this.getMunkas().Mozog(i,tomeg);
		}else {
			if( teszt) System.out.println("Lyuk mozog Return Mozoghat");
=======
	public Lyuk(boolean nyit) {
		if (teszt)
			System.out.println("Lyuk Ctor" + nyit);
		this.Nyitott = nyit;
	}

	public Kimenetel Mozog(Irany i) {
		if (teszt)
			System.out.println("Lyuk MOZOG " + i);

		if (this.getLada() != null) {
			if (teszt)
				System.out.println("Lyuk mozog Return" + this.getLada().Mozog(i));
			return this.getLada().Mozog(i);
		} else if (this.getMunkas() != null) {
			if (teszt)
				System.out.println("Lyuk mozog Return" + this.getMunkas().Mozog(i));
			return this.getMunkas().Mozog(i);
		} else {
			if (teszt)
				System.out.println("Lyuk mozog Return Mozoghat");
>>>>>>> 61319b3495590571225dbe3e131e2446e507b2df
			return Kimenetel.Mozoghat;
		}
	}

	public void Add(Munkas m) {
		if (this.Nyitott == true) {
			if (teszt)
				System.out.println("Lyuk ADD munkas Nyitott");
			m.Halal();
		} else {
			if (teszt)
				System.out.println("Lyuk ADD munkas Zart");
			super.Add(m);
			;
		}
	}

	public void Add(Lada l) {
		if (this.Nyitott == true) {
			if (teszt)
				System.out.println("Cel ADD lada Nyitott");
			this.setLada(null);
		} else {
			if (teszt)
				System.out.println("Lyuk ADD lada Zart");
			super.Add(l);
			;
		}
	}

	public void Torol() {
		if (teszt)
			System.out.println("Lyuk Torol");
		super.Torol();

	}

	public void setStateFalse() {
		this.Nyitott = false;
	}

	public void setStateTrue() {
		this.Nyitott = true;
	}
	
	public boolean getState() {
		return Nyitott;
	}
}
