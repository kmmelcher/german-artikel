

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;


public class Plural extends JFrame {
	
	public JTextArea wort;
	public JTextArea richtig;
	public JTextArea falsch;
	public JTextField answer;
	public JLabel text;
	public JLabel text2;
	
	private Font font;
	private Color yellow;
	
	//File Object
	FileClass file = new FileClass();
	
	//Artikel object
	Artikel a = new Artikel();
	
	
	//richtig points
	int right = 0;
			
	//falsch points
	int wrong = 0;
	
	List<Integer> NumbersList2 = new ArrayList<Integer>();
			
	
	public Plural() {
		
		//font
		font = new Font("Calibri", Font.PLAIN, 30);
		
		//colors
		yellow = new Color(232, 224, 4);
		
		//text2
		text2 = new JLabel("Wort:");
		text2.setVisible(false);
		text2.setFont(new Font("Calibri", Font.PLAIN, 28));
		text2.setForeground(Color.white);
		text2.setBounds(100,25,100,40);
		
		for(int p=0; p<file.listLines(); p++) {
			NumbersList2.add(p);
		}
	 
		Collections.shuffle(NumbersList2);
		
		//wort
		wort = new JTextArea(file.getWort(NumbersList2.get(0)));
		wort.setFont(new Font("Calibri", Font.ITALIC, 50));
		wort.setBounds(100,60,400,55);
		wort.setForeground(yellow);
		wort.setBackground(null);
		wort.setEditable(false);
		wort.setVisible(false);
		
		//Plural eingeben
		text = new JLabel("Plural eingeben:");
		text.setVisible(false);
		text.setFont(new Font("Calibri", Font.PLAIN, 28));
		text.setForeground(Color.white);
		text.setBounds(100,125,250,40);
		
		//answer
		answer = new JTextField();
		answer.setVisible(false);
		answer.setFont(font);
		answer.setForeground(Color.black);
		answer.setBounds(100,180,400,50);
		
		//richtig
		richtig = new JTextArea("richtig: 0");
		richtig.setFont(font);
		richtig.setBounds(80,300,180,40);
		richtig.setBackground(null);
		richtig.setForeground(Color.white);
		richtig.setEditable(false);
		richtig.setVisible(false);
		
		
		//falsch
		falsch = new JTextArea("falsch: 0");
		falsch.setFont(font);
		falsch.setBounds(370,300,180,40);
		falsch.setBackground(null);
		falsch.setForeground(Color.white);
		falsch.setEditable(false);
		falsch.setVisible(false);
		
	}
	
	
	
}
