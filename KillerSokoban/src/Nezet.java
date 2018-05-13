
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.*;

import javax.swing.*;

public class Nezet extends JPanel{
	//munkasok listaja
	private List<Munkas> munkasok; 
	//mezok listaja
	private List<Mezo> mezok;	
	//2d-s palya 
	Mezo[][] palya;	
	//2d-s palya szelessege es magassaga
	int magassag;
	int szelesseg;
	
	//Fugveny ami a kapott mezo listabol a kirajzolashoz egy 2d-s tombe helyezi a mezoket
	private Mezo[][] palyaTo2D(){
		 magassag = 1;
		 szelesseg = 1;

		//megnezi mekkora tombre lessz szukseg
		Mezo m = mezok.get(0);
		
		while (m.SzomszedokLekerdez(Irany.FEL) != null) {
			m = m.SzomszedokLekerdez(Irany.FEL);
			magassag += 1;
		}
		m = mezok.get(0);
		while (m.SzomszedokLekerdez(Irany.LE) != null) {
			m = m.SzomszedokLekerdez(Irany.LE);
			magassag += 1;
		}
		m = mezok.get(0);
		while (m.SzomszedokLekerdez(Irany.JOBBRA) != null) {
			m = m.SzomszedokLekerdez(Irany.JOBBRA);
			szelesseg += 1;
		}
		m = mezok.get(0);
		while (m.SzomszedokLekerdez(Irany.BALRA) != null) {
			m = m.SzomszedokLekerdez(Irany.BALRA);
			szelesseg += 1;
		}

		// kirajzolashoz a 2d-s tomb
		Mezo[][] palya = new Mezo[magassag][szelesseg];
		
		//Elmegy a bal felsõ sarokba
		while (m.SzomszedokLekerdez(Irany.FEL) != null) {
			m = m.SzomszedokLekerdez(Irany.FEL);
		}
		while (m.SzomszedokLekerdez(Irany.BALRA) != null) {
			m = m.SzomszedokLekerdez(Irany.BALRA);
		}
		
		int x = 0;
		int y = 0;
		boolean kessz = false;
		
		//balfelso sarokbol kiindulva feltolti a 2d-s tombe a palya elemeit
		while (kessz != true) {
			palya[x][y] = m;
			Mezo koztes = m.SzomszedokLekerdez(Irany.LE);
			while (koztes != null) {
				x = x + 1;
				palya[x][y] = koztes;
				koztes = koztes.SzomszedokLekerdez(Irany.LE);
			}
			x = 0; // RESETELNI X-t
			y += 1;
			if (m.SzomszedokLekerdez(Irany.JOBBRA) == null)
				kessz = true;
			m = m.SzomszedokLekerdez(Irany.JOBBRA);
		}
		
		//visszater a megkapott 2d-s palyaval
		return palya;
		
	}
	
	//konstruktor
	public Nezet(List<Munkas> m,List<Mezo> p){
		munkasok = m;
		mezok = p;
	}
	public void Kirajzol(List<Munkas> m, List<Mezo> p) {
		
		munkasok = m;
		mezok = p;		
		JPanel pfelso = new JPanel();
		pfelso.setLayout(new FlowLayout());
		
		JPanel palso = new JPanel(){
			 @Override
		     public void paintComponent(Graphics g) {
		         super.paintComponent(g);
		         for (int x = 0; x < magassag; x++) {
		 			for (int y = 0; y < szelesseg; y++) {
		 				//Ha falat kell kirajzolni
		 				if (palya[x][y] instanceof Fal) {
		 					g.setColor(Color.gray);
		 					g.fillRect(x*40, y*40, 40, 40);
							g.setColor(Color.black);
							g.drawRect(x*40, y*40, 40, 40);
		 				//Ha kapcsolot kell kirajzolni
		 				}else if (palya[x][y] instanceof Kapcsolo) {
		 					//ha lada van rajta
		 					if (palya[x][y].getLada() != null) {
		 						Color c = new Color(205,133,63);
		 						g.setColor(c);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					//HA munkas van rajta
		 					} else if (palya[x][y].getMunkas() != null) {
		 						//lekeri amunkast megnezi hogy melyik es a neki megfelelo szinnel kirajzolja azt
		 						Munkas mu = palya[x][y].getMunkas();
		 						g.setColor(Color.white);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40+10, y*40+10, 20, 20);
		 						g.setColor(munkasSzine(mu));
		 						g.fillOval(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					//nincs semmi a kapcsolon
		 					} else {
		 						g.setColor(Color.white);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40+10, y*40+10, 20, 20);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					}
		 				//Lyuk kirajzolasa
		 				} else if (palya[x][y] instanceof Lyuk) {
		 					//Ha nyitva van a lyuk
		 					if (palya[x][y].getNyitva() == true) {
		 						g.setColor(Color.black);
		 						g.fillRect(x*40, y*40, 40, 40);
		 					//ha bevan zárva akkor sima mezonek nez ki
		 					} else {
		 						g.setColor(Color.white);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					}
		 					//Cel kirajzolasa
		 				} else if (palya[x][y] instanceof Cel) {
		 					//ha lada van a celon
		 					if (palya[x][y].getLada() != null) {
		 						Color c = new Color(205,133,63);
		 						g.setColor(c);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					//ha munkas all a celon
		 					} else if (palya[x][y].getMunkas() != null) {
		 						Munkas mu = palya[x][y].getMunkas();
		 						g.setColor(Color.green);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(munkasSzine(mu));
		 						g.fillOval(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					//Ha nincs a celon semmi
		 					} else {
		 						g.setColor(Color.green);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					}
		 				//smima mezo kirajzolasa
		 				} else if (palya[x][y] instanceof Mezo) {
		 					//ha lada van rajta
		 					if (palya[x][y].getLada() != null) {
		 						Color c = new Color(205,133,63);
		 						g.setColor(c);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					//ha munkas van a celon
		 					} else if (palya[x][y].getMunkas() != null) {
		 						Munkas mu = palya[x][y].getMunkas();
		 						g.setColor(munkasSzine(mu));
		 						g.fillOval(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					//Ha csak olaj van a mezon
		 					} else if (palya[x][y].getOlaj()) {
		 						Color c = new Color(105,105,105);
		 						g.setColor(c);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					//Ha mez van rajta
		 					} else if (palya[x][y].getMez()) {
		 						Color c = new Color(255,255,0);
		 						g.setColor(c);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					} else {
		 						g.setColor(Color.white);
		 						g.fillRect(x*40, y*40, 40, 40);
		 						g.setColor(Color.black);
		 						g.drawRect(x*40, y*40, 40, 40);
		 					}
		 				}
		 			}
		 		}
		     }
		};
		
		for(int i = 0; i < m.size();i++){
			
			JLabel lab1 = new JLabel(m.get(i).getNev()+ "   Pont: " + m.get(i).getPont());
			lab1.setForeground(munkasSzine(m.get(i)));
			pfelso.add(lab1, FlowLayout.LEFT);
		}
		
		this.setLayout(new BorderLayout());
		this.add(pfelso,BorderLayout.NORTH);
		this.add(palso,BorderLayout.CENTER);
		
		palya = palyaTo2D();
	}
	
	//kivalasztja a megfelelo szint a megfelelo munkashoz
	private Color munkasSzine(Munkas m){
		Color c = Color.black;	
		for (int in = 0; in < munkasok.size(); in++) {
				if (munkasok.get(in) == m)
					switch(in){
					case 0:
						c = Color.red;
						break;
					case 1:
						c = Color.blue;
						break;
					case 2:
						c = Color.GREEN;
						break;
					case 3:
						c = Color.PINK;
						break;
						default:
							break;
					}
			}
		return c;
	}
	
}
