
import java.util.ArrayList;
import java.util.List;

public class Mezo {
	private Munkas munkas;
	private Lada lada;
	protected List<Mezo> szomszedok;
	private boolean teszt = false;
	private Kenoanyag surlodas = Kenoanyag.Semleges;
	protected boolean Nyitott = true;

	public void setTeszt(boolean t) {
		teszt = t;
	}

	public void setOlaj() {
		surlodas = Kenoanyag.Csuszos;
	}

	public void setMez() {
		surlodas = Kenoanyag.Ragacsos;
	}

	public boolean getOlaj() {
		if (surlodas == Kenoanyag.Csuszos)
			return true;
		return false;
	}

	public boolean getMez() {
		if (surlodas == Kenoanyag.Ragacsos)
			return true;
		return false;
	}

	public Kimenetel Mozog(Irany i) {
		if (i == null)
			System.out.println("Mezo MOZOG " + i);
		// csak a kiiras miatt kell felvenni
		Kimenetel k = null;

		if (lada != null) {
			k = lada.Mozog(i);

			if (teszt)
				System.out.println("Mezo mozog RETURN" + k);
			return k;
		} else if (munkas != null) {
			k = munkas.Mozog(i);
			if (teszt)
				System.out.println("Mezo Mozog RETURN " + k);
			return k;
		} else {
			if (teszt)
				System.out.println("Mezo Mozog RETURN Mozoghat");
			return Kimenetel.Mozoghat;
		}
	}

	public Mezo SzomszedokLekerdez(Irany i) {

		if (i == null)
			System.out.println("Szomszedok Lekerdez " + i);
		if (teszt)
			System.out.println("Szomszedok Lekerdez RETURN");
		return szomszedok.get(i.getValue());
	}

	public void Add(Munkas m) {
		if (teszt)
			System.out.println("Mezo ADD Munkas");
		if (teszt)
			System.out.println("Mezo ADD Munkas RETURN");
		this.munkas = m;
		this.munkas.setIndulo(this);
	}

	public void Add(Lada l) {
		if (teszt)
			System.out.println("Mezo ADD Lada");
		if (teszt)
			System.out.println("Mezo ADD Lada RETURN");
		this.lada = l;
		l.setIndulo(this);
	}

	// szomszed hozzaadasa
	public void setSzomszed(Irany i, Mezo m) {
		szomszedok.set(i.getValue(), m);
	}

	public void Torol() {
		if (teszt)
			System.out.println("Mezo TOROL");
		this.munkas = null;
		this.lada = null;
	}

	// Ures konstruktor
	public Mezo() {
		if (teszt)
			System.out.println("Mezo osztaly ctor");
		this.szomszedok = new ArrayList<Mezo>();
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		szomszedok.add(null);
		this.lada = null;
		this.munkas = null;
	}

	public Mezo(List<Mezo> szomsz, Lada l) {
		if (teszt)
			System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomsz;
		this.lada = l;
		this.munkas = null;
	}

	public Mezo(List<Mezo> szomsz, Munkas m) {
		if (teszt)
			System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomsz;
		this.lada = null;
		this.munkas = m;
	}

	public Mezo(List<Mezo> szomsz) {
		if (teszt)
			System.out.println("Mezo osztaly ctor");
		this.szomszedok = szomsz;
		this.lada = null;
		this.munkas = null;
	}

	public Munkas getMunkas() {
		return this.munkas;
	}

	public boolean getNyitva() {
		return Nyitott;
	}

	public void setMunkas(Munkas m) {
		this.munkas = m;
	}

	public Lada getLada() {
		return this.lada;
	}

	public void setLada(Lada l) {
		if (this.lada == null) {
			this.lada = l;
		}
		this.lada = l;
	}

	public List<Mezo> getSzomsz() {
		return this.szomszedok;
	}
}
