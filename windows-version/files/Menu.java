import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Menu extends JFrame {
	
	public JButton artikel;
	public JButton plural;
	public JButton exit;
	public JTextArea text;
	private Font font;
	private Color buttons;
	private Color letters;
	
	public Menu() {
		
		//font
		font = new Font("Calibri", Font.PLAIN, 30);
				
		//colors
		buttons = new Color(127,215,122);
		letters = new Color(56,58,62);
		
		//title
		text =  new JTextArea("Cyber Deutsch");
		text.setBackground(null);
		text.setFont(font);
		text.setEditable(false);
		text.setForeground(new Color(204,204,205));
		text.setBounds(185,50, 230,70);
		
		
		//Artikel button
		artikel = new JButton("Artikel");
		artikel.setFont(font);
		artikel.setBackground(buttons);
		artikel.setForeground(letters);
		artikel.setBounds(125,130,350,60);
		
		
		//Plural
		plural = new JButton("Plural");
		plural.setFont(font);
		plural.setBackground(buttons);
		plural.setForeground(letters);
		plural.setBounds(125,210,350,60);

		//exit
		exit = new JButton("exit");
		exit.setFont(font);
		exit.setBackground(Color.red);
		exit.setForeground(Color.white);
		exit.setBounds(225,390,150,60);
		
	}
	
}
