package de;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.border.*;


public class Deutsch extends JFrame {

	//Menu object
	Menu m = new Menu();
	
	//Artikel object
	Artikel a = new Artikel();
	
	//Wörter object
	Wörter w = new Wörter();
	
	//Plural object
	Plural p = new Plural();
	
	//interface items
	private JButton backToMenu;
	private JPanel panel;
	private Color background;
	private Color letters;


	//borders
	Border redLine = BorderFactory.createLineBorder(Color.red, 3);
	Border greenLine = BorderFactory.createLineBorder(Color.green, 3);
	Border black3D = BorderFactory.createMatteBorder(0, 0, 5, 5, Color.black);
	

	public Deutsch(){
		
		//title
		super("Cyber Learning");
		
		
		//setting the panel
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		
		//colors
		background = new Color(39,37,128);
		letters = new Color(56,58,62);
				
		
		
		//-------------- M E N U -----------------//
		
		panel.add(m.text);
		panel.add(m.artikel);
		panel.add(m.plural);
		panel.add(m.wörter);
		panel.add(m.exit);
		
		//back to menu
		backToMenu = new JButton("<--Züruck zum Menü");
		backToMenu.setFont(new Font("Calibri", Font.PLAIN, 17));
		backToMenu.setBackground(Color.gray);
		backToMenu.setForeground(Color.black);
		//backToMenu.setBorder(greenLine);
		backToMenu.setBounds(-10, 405, 230, 50);
		backToMenu.setVisible(false);
		panel.add(backToMenu);
		
		//setting background color
		panel.setBackground(background);
		
		//-------------- A R T I K E L -----------------//
		
		panel.add(a.wort);
		panel.add(a.der);
		panel.add(a.das);
		panel.add(a.die);
		panel.add(a.richtig);
		panel.add(a.falsch);
		
		
		//-------------- W Ö R T E R -----------------//
		
		panel.add(w.scroll);
		panel.add(w.add);
		panel.add(w.delete);
		panel.add(w.der);
		panel.add(w.die);
		panel.add(w.das);
		panel.add(w.search);
		panel.add(w.addWort);
		panel.add(w.addPlural);
		
		
		//-------------- P L U R A L -----------------//
		
		panel.add(p.text2);
		panel.add(p.wort);
		panel.add(p.text);
		panel.add(p.answer);
		panel.add(p.richtig);
		panel.add(p.falsch);
		
		//-------------- H A N D L E R -----------------//
		
		TheHandler handler = new TheHandler();
		m.artikel.addActionListener(handler);
		m.plural.addActionListener(handler);
		m.wörter.addActionListener(handler);
		m.exit.addActionListener(handler);
		backToMenu.addActionListener(handler);
		
		//Listener from Artikel
		a.der.addActionListener(handler);
		a.das.addActionListener(handler);
		a.die.addActionListener(handler);
		
		//Listener from wörter
		w.add.addActionListener(handler);
		w.delete.addActionListener(handler);
		w.der.addActionListener(handler);
		w.die.addActionListener(handler);
		w.das.addActionListener(handler);
		w.search.addActionListener(handler);
		w.addWort.addActionListener(handler);
		w.addPlural.addActionListener(handler);
		
		//Listener from Plural
		p.answer.addActionListener(handler);
	}
	
	
	public void close(){
    	WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	//boolean set;
	
	public void turnMenu(boolean set) {
		if(set) {
			panel.setBackground(background);
		}
		
		m.text.setVisible(set);
		m.artikel.setVisible(set);
		m.plural.setVisible(set);
		m.wörter.setVisible(set);
		m.exit.setVisible(set);
	}
	
		
	public void turnArtikel(boolean set) {
		
		a.wort.setVisible(set);
		a.der.setVisible(set);
		a.das.setVisible(set);
		a.die.setVisible(set);
		a.richtig.setVisible(set);
		a.falsch.setVisible(set);
		backToMenu.setVisible(set);
	}
	
	public void turnWörter(boolean set) {
		
		w.scroll.setVisible(set);
		w.add.setVisible(set);
		w.delete.setVisible(set);
		w.search.setVisible(set);
		w.der.setVisible(set);
		w.die.setVisible(set);
		w.das.setVisible(set);
		w.addWort.setVisible(set);
		w.addPlural.setVisible(set);
		w.search.setText("suchen...");
		w.addWort.setText("Wort eingeben");
		w.addPlural.setText("Plural eingeben");
		backToMenu.setVisible(set);
		
	}
	
	public void turnPlural(boolean set) {
		p.text2.setVisible(set);
		p.wort.setVisible(set);
		p.text.setVisible(set);
		p.answer.setVisible(set);
		p.richtig.setVisible(set);
		p.falsch.setVisible(set);
		backToMenu.setVisible(set);
	}
	

    FileClass file = new FileClass();
	
	private class TheHandler implements ActionListener{
		
	
	
	public void actionPerformed(ActionEvent event) {
		
		
			
			//---------- M E N U -----------//
		
			if(event.getSource()==m.artikel) {
				turnMenu(false);				
				turnArtikel(true);
				panel.setBackground(letters);
			}
			
			if(event.getSource()==m.plural) {
				turnMenu(false);
				turnPlural(true);
				panel.setBackground(letters);
			}
			
			if(event.getSource()==m.wörter) {
				turnMenu(false);
				turnWörter(true);
				panel.setBackground(letters);
			}
			
			if(event.getSource()==backToMenu) {
				turnArtikel(false);
				turnWörter(false);
				turnPlural(false);
				turnMenu(true);
			}
			
			
			if(event.getSource()==m.exit) {
				close();
			}
			
			
			
			
			//---------- W Ö R T E R ---------//
			
			//add a word to the list and the file
			if(event.getSource()==w.add) {
				
				String art = "";
				
				if(w.der.isSelected()==true) {
					art = "Der";		
				}
				else if(w.die.isSelected()==true) {
					art = "Die";
				}
				else if(w.das.isSelected()==true) {
					art = "Das";
				}
				
				String wo = w.addWort.getText();
				String pl = w.addPlural.getText();
				String t = art + " " + wo + " " + pl;
				file.openFile();
				file.addText(t);
				file.closeFile();
				
				file.SortAll();
				
				w.dm.clear();
				
				for(int a=0; a<file.listLines(); a++) {
					w.dm.addElement(file.getLine(a));
				}
				
				w.der.setSelected(false);
				w.das.setSelected(false);
				w.die.setSelected(false);
				w.addWort.setText("Wort hinzufügen");
				w.addPlural.setText("Plural hinzufügen");
				
				
			}
			
			if(event.getSource()==w.delete) {
				try {
				int index = w.list.getSelectedIndex();
				w.dm.removeElementAt(index);
				file.removeLine(index);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "There is no item selected");
				}
			}
			
			
			if(event.getSource()==w.search) {
				
				file.search(w.search.getText(), w.list);	
				
			}
			
			
			
			
			//---------- A R T I K E L ----------//
			
			if(event.getSource()==a.der) {
				if(file.getArtikel(file.getIndex(a.wort)).equals("Der")) {
					a.right++;
					a.richtig.setText("Richtig: " + a.right);
					a.wort.setText(file.getRandomWort(a.NumbersList));
				}else {
					a.wrong++;
					a.falsch.setText("falsch: " + a.wrong);
				}
			
			}
			
			
			if(event.getSource()==a.das) {
				if(file.getArtikel(file.getIndex(a.wort)).equals("Das")) {
					a.right++;
					a.richtig.setText("Richtig: " + a.right);
					a.wort.setText(file.getRandomWort(a.NumbersList));
				}else {
					a.wrong++;
					a.falsch.setText("falsch: " + a.wrong);
				}
			
			}
			
			if(event.getSource()==a.die) {
				if(file.getArtikel(file.getIndex(a.wort)).equals("Die")) {
					a.right++;
					a.richtig.setText("Richtig: " + a.right);
					a.wort.setText(file.getRandomWort(a.NumbersList));
				}else {
					a.wrong++;
					a.falsch.setText("falsch: " + a.wrong);
				}
			
			}
			
			
			
			//---------- P L U R A L -----------//
			
			if(event.getSource()==p.answer) {
				
				//that means if what you typed is equal to the plural of that word 
				if(file.getPlural(file.getIndex(p.wort)).equalsIgnoreCase(p.answer.getText())) {
					p.right++;
					p.richtig.setText("Richtig: " + p.right);
					p.wort.setText(file.getRandomWort(p.NumbersList2));
					p.answer.setText("");
				}else {
					p.wrong++;
					p.falsch.setText("falsch: " + p.wrong);
				}
			}
			
			
			
		}
	
	
	
	}
	
	
	

}
