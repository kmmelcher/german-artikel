

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class Artikel extends JFrame {
		//artikel items
		public JTextArea wort;
		public JTextArea richtig;
		public JTextArea falsch;
		public JButton der;
		public JButton die;
		public JButton das;
		
		private Font font;
		private Border black3D;
		private Color letters;
		private Color buttons;
		private Color green;
		private Color red;
		
		FileClass file = new FileClass();
		List<Integer> NumbersList = new ArrayList<Integer>();
			
		
		//richtig points
		int right = 0;
		
		//falsch points
		int wrong = 0;
	
		public Artikel(){
			
			//font
			font = new Font("Calibri", Font.PLAIN, 30);
			
			//border
			black3D = BorderFactory.createMatteBorder(0, 0, 5, 5, Color.black);
			
			//colors
			letters =  new Color(56,58,62);
			buttons = new Color(127,215,122);
			green = new Color(35,150,0);
			red = new Color(180,1,1);
			
			
			
			//List to make the words random but not repetitive
			for(int p=0; p<file.listLines(); p++) {
					NumbersList.add(p);
			}
			 
			Collections.shuffle(NumbersList);
			
			//wort
			wort = new JTextArea(file.getWort(NumbersList.get(0)));
			wort.setFont(font);
			wort.setBounds(100,60,400,40);
			wort.setForeground(letters);
			wort.setBackground(buttons);
			wort.setEditable(false);
			wort.setVisible(false);
			
			
			//der
			der = new JButton("Der");
			der.setFont(new Font("Calibri", Font.PLAIN, 50));
			der.setBounds(60, 140, 140, 140);
			der.setBorder(black3D);
			der.setForeground(Color.white);
			der.setBackground(new Color(0,97,255));
			der.setVisible(false);
			
			
			//das
			das = new JButton("Das");
			das.setFont(new Font("Calibri", Font.PLAIN, 50));
			das.setBounds(230, 140, 140, 140);
			das.setBorder(black3D);
			das.setForeground(Color.white);
			das.setBackground(green);
			das.setVisible(false);
			
			
			//die
			die = new JButton("Die");
			die.setFont(new Font("Calibri", Font.PLAIN, 50));
			die.setBounds(400, 140, 140, 140);
			die.setBorder(black3D);
			die.setForeground(Color.white);
			die.setBackground(red);
			die.setVisible(false);
			
			
			//richtig
			richtig = new JTextArea("richtig: 0");
			richtig.setFont(font);
			richtig.setBounds(80,330,180,40);
			richtig.setBackground(null);
			richtig.setForeground(Color.black);
			richtig.setEditable(false);
			richtig.setVisible(false);
			
			
			//falsch
			falsch = new JTextArea("falsch: 0");
			falsch.setFont(font);
			falsch.setBounds(370,330,180,40);
			falsch.setBackground(null);
			falsch.setForeground(Color.black);
			falsch.setEditable(false);
			falsch.setVisible(false);
			
		}
		
}
