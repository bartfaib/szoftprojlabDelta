import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu extends JFrame{
	
	public Menu() {
		super("KillerSokoban");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		//this.setLayout(null);
		GraphicMenu menu = new GraphicMenu();
		this.add(menu);
		this.setVisible(true);
		
	}
	
	


}
