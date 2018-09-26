package de;

import java.awt.*;


import javax.swing.*;

public class Wörter extends JFrame {
	
		//File object
		FileClass file = new FileClass();
		
		//wörter interface
		public JList<String> list;
		public JButton add;
		public JButton delete;
		public JTextField search;
		public JTextField addWort;
		public JTextField addPlural;
		public JScrollPane scroll;
		public JRadioButton der;
		public JRadioButton die;
		public JRadioButton das;
		public ButtonGroup group;
		private Color buttons;
		
		
		DefaultListModel dm = new DefaultListModel();
		
		
		
		public Wörter() {
			
	
			
			//color
			buttons = new Color(127,215,122);
			
			//Search field
			search = new JTextField("suchen...");
			search.setVisible(false);
			search.setBounds(100, 20, 200, 40);
			
			
			//list
			list = new JList<String>();
			list.setModel(dm);
			
			for(int a=0; a<file.listLines(); a++) {
				dm.addElement(file.getLine(a));
			}
			
			list.setFixedCellWidth(100);
			list.setFixedCellHeight(50);
			list.setVisibleRowCount(6);
			list.setForeground(Color.black);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			//scroll bar
			scroll = new JScrollPane();
			scroll.setViewportView(list);
			scroll.setVisible(false);
			scroll.setBounds(100,70, 200, 300);
			
			
			//add
			add = new JButton("Hinzufügen");
			add.setFont(new Font("Calibri", Font.PLAIN, 20));
			add.setBounds(370, 180, 150,30);
			add.setBackground(buttons);
			add.setForeground(Color.white);
			add.setVisible(false);
			
			
			//delete
			delete = new JButton("löschen");
			delete.setFont(new Font("Calibri", Font.PLAIN, 20));
			delete.setBounds(375, 225, 140,30);
			delete.setBackground(Color.red);
			delete.setForeground(Color.white);
			delete.setVisible(false);
			
			
			//radio buttons
			der = new JRadioButton("der", false);
			die = new JRadioButton("die", false);
			das = new JRadioButton("das", false);
			der.setVisible(false);
			die.setVisible(false);
			das.setVisible(false);
			der.setBackground(null);
			die.setBackground(null);
			das.setBackground(null);
			der.setForeground(Color.white);
			die.setForeground(Color.white);
			das.setForeground(Color.white);
			der.setBounds(350,50,50,40);
			die.setBounds(420,50,50,40);
			das.setBounds(480,50,52,40);
			
			//wort field
			addWort = new JTextField("Wort eingeben");
			addWort.setVisible(false);
			addWort.setBounds(350, 90, 200, 30);
			
			//plural field
			addPlural = new JTextField("Plural eingeben");
			addPlural.setVisible(false);
			addPlural.setBounds(350,130,200,30);
			
			//buttons group so that only one button at a time can be selected
			group = new ButtonGroup();
			group.add(der);
			group.add(das);
			group.add(die);
			
			
		}
		
}
