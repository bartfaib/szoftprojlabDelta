import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GraphicMenu extends JPanel implements ActionListener{
	private JFrame mframe;
	JPanel mainMenu = new JPanel();
	JPanel addPlayer = new JPanel();
	JPanel changeMap = new JPanel();
	JTextField t_player1;
	JTextField t_player2;
	JTextField t_player3;
	JTextField t_player4;
	
	public GraphicMenu() {
		//System.out.println("GraphicMenü ctor");
		JButton start;
		JButton map;
		JButton exit_app;
		BoxLayout box;
		BoxLayout box2;
		BoxLayout box3;
		
		box = new BoxLayout(mainMenu, BoxLayout.Y_AXIS);
		mainMenu.setLayout(box);
		
		
		start = new JButton("A játék indítása");
		start.setText("A játék indítása");
		start.setAlignmentX(mainMenu.CENTER_ALIGNMENT);
		start.addActionListener(this);

		
		map = new JButton("Pálya módosítása");
		map.setText("Pálya módosítása");
		map.setAlignmentX(mainMenu.CENTER_ALIGNMENT);
		map.addActionListener(this);

		
		exit_app = new JButton("Kilépés");
		exit_app.setText("Kilépés");
		exit_app.setAlignmentX(mainMenu.CENTER_ALIGNMENT);
		exit_app.addActionListener(this);
		
		Dimension minSize = new Dimension(5, 175);
		Dimension prefSize = new Dimension(5, 175);
		Dimension maxSize = new Dimension(Short.MAX_VALUE, 175);
		mainMenu.add(new Box.Filler(minSize, prefSize, maxSize));
		mainMenu.add(start);
		
		minSize = new Dimension(5, 30);
		prefSize = new Dimension(5, 30);
		maxSize = new Dimension(Short.MAX_VALUE, 30);
		
		mainMenu.add(new Box.Filler(minSize, prefSize, maxSize));
		mainMenu.add(map);
		mainMenu.add(new Box.Filler(minSize, prefSize, maxSize));
		mainMenu.add(exit_app);
		
		//////////////////   Játékos hozzáadása
		
		JLabel l_player1 = new JLabel("1-es játékos:");
		l_player1.setAlignmentX(addPlayer.CENTER_ALIGNMENT);
		t_player1 = new JTextField(30);
		
		JLabel l_player2 = new JLabel("2-es játékos:");
		l_player2.setAlignmentX(addPlayer.CENTER_ALIGNMENT);
		t_player2 = new JTextField(30);
		
		JLabel l_player3 = new JLabel("3-es játékos:");
		l_player3.setAlignmentX(addPlayer.CENTER_ALIGNMENT);
		t_player3 = new JTextField(30);
		
		JLabel l_player4 = new JLabel("4-es játékos:");
		l_player4.setAlignmentX(addPlayer.CENTER_ALIGNMENT);
		t_player4 = new JTextField(30);
		
		JButton ok_gomb = new JButton("OK_GAME");
		ok_gomb.setAlignmentX(addPlayer.CENTER_ALIGNMENT);
		ok_gomb.setText("OK");
		ok_gomb.addActionListener(this);
		
		box2 = new BoxLayout(addPlayer, BoxLayout.Y_AXIS);
		addPlayer.setLayout(box2);
		
		
		minSize = new Dimension(5, 150);
		prefSize = new Dimension(5, 150);
		maxSize = new Dimension(Short.MAX_VALUE, 150);
		
		addPlayer.add(new Box.Filler(minSize, prefSize, maxSize));
		addPlayer.add(l_player1);
		addPlayer.add(t_player1);
		addPlayer.add(l_player2);
		addPlayer.add(t_player2);
		addPlayer.add(l_player3);
		addPlayer.add(t_player3);
		addPlayer.add(l_player4);
		addPlayer.add(t_player4);
		
		minSize = new Dimension(5, 30);
		prefSize = new Dimension(5, 30);
		maxSize = new Dimension(Short.MAX_VALUE, 30);
		
		addPlayer.add(new Box.Filler(minSize, prefSize, maxSize));
		addPlayer.add(ok_gomb);
		
		
		//////////////////////// Pálya választása
		
		JComboBox jbox = new JComboBox();
		box = new BoxLayout(changeMap, BoxLayout.Y_AXIS);
		changeMap.setLayout(box);
		jbox.addItem("prebuilt1");
		jbox.setAlignmentX(changeMap.CENTER_ALIGNMENT);
		JButton ok_gomb2 = new JButton("Mentés");
		ok_gomb2.setText("Mentés");
		ok_gomb2.setAlignmentX(changeMap.CENTER_ALIGNMENT);
		ok_gomb2.addActionListener(this);
		
		minSize = new Dimension(5, 150);
		prefSize = new Dimension(5, 150);
		maxSize = new Dimension(Short.MAX_VALUE, 150);
		
		changeMap.add(new Box.Filler(minSize, prefSize, maxSize));
		changeMap.add(jbox);
		//////////////////////////////////////////////////////////////////////////////////
		minSize = new Dimension(5, 30);
		prefSize = new Dimension(5, 30);
		maxSize = new Dimension(Short.MAX_VALUE, 30);
		/////////////////////////////////////////////////////////////////////////////////
		changeMap.add(new Box.Filler(minSize, prefSize, maxSize));
		changeMap.add(ok_gomb2);
		
		this.add(mainMenu);
		

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String gomb = e.getActionCommand();
		
		switch(gomb) {
		case "A játék indítása":
			this.removeAll();
			this.invalidate();
			this.add(addPlayer);
			this.validate();
			this.repaint();
			break;
			
		case "Pálya módosítása":
			this.removeAll();
			this.invalidate();
			this.add(changeMap);
			this.validate();
			this.repaint();
			break;
			
		case "Mentés":
			this.removeAll();
			this.invalidate();
			this.add(mainMenu);
			this.validate();
			this.repaint();
			break;
			
		case "OK":
///start game function:
			String splayer1 = t_player1.getText();
			String splayer2 = t_player2.getText();
			String splayer3 = t_player3.getText();
			String splayer4 = t_player4.getText();
			
			
			Beolvas b = new Beolvas("prebuilt1.xml");
			
			ArrayList<String> jatekos = new ArrayList<String>();
			
			jatekos.add(splayer1);
			if (splayer2 != "")
				jatekos.add(splayer2);
			if (splayer3 != "")
				jatekos.add(splayer3);
			if (splayer4 != "")
				jatekos.add(splayer4);
			
			Jatek j = new Jatek(b.Beolvasas(), jatekos);
			j.Kor();
			
			break;
			
		case "Kilépés": 
			System.exit(0);
			break;
			
		default:
			break;
		}
		
	}
}
