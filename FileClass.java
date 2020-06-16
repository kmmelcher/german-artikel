

import java.io.*;
import java.nio.file.*;
import java.util.*;

import javax.swing.*;

class WordComparator implements Comparator<String>{

	public int compare(String s1, String s2) {
		
		String a = s1.substring(4, s1.length());
		String b = s2.substring(4, s2.length());
			
		return a.compareToIgnoreCase(b);
		
}
}



public class FileClass {
	
		
	 private FileWriter file;
	 private PrintWriter write;
	 int repeat=0;
	 
	 public void openFileReverse() {
		 try {
	            file = new FileWriter("bibliothek/woerter.txt", false);
	            write = new PrintWriter(file);
	        }catch(Exception e) {
	            System.out.println(e);
	        }
	 }
	    
	 public void openFile() {
	        try {
	            file = new FileWriter("bibliothek/woerter.txt", true);
	            write = new PrintWriter(file);
	        }catch(Exception e) {
	            System.out.println(e);
	        }
	 }

	 
	 public void addText(String w) {
 		write.print(w);  
 		
	 }
	 
	 public void removeLine(int line) {
		 
		 List <String> content = new ArrayList<String>();
	        
	        try {
				content = Files.readAllLines(Paths.get("bibliothek/woerter.txt"));
			} catch (Exception e) {
				System.out.println("Coudln't read the file");
			}
		 
	        content.remove(line);
	        
	        String text = "";
	        
	        for(String s : content) {
	        	text += s + "\n";
	        }
	        
	        openFileReverse();
	        addText(text); 
	        closeFile();
	 }
	 
	 public void closeFile() {
	       
	        try {
	            file.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	 
	 
	 public String getLine(int line) {
		 String text = "";
	       
	     text += getArtikel(line) + " " + getWort(line) + "\n";
		 	
		 return text;
	 }
	 
	 
	 public int listLines() {
		 int lines = 0;
	        
	        try {
				lines = Files.readAllLines(Paths.get("bibliothek/woerter.txt")).size();
			} catch (Exception e) {
				System.out.println("Coudln't read the file");
			}
	        
	     return lines;
	 }
	 
	 public String SortAll() {
	        
	        
	       	List <String> content = new ArrayList<String>();
	        
	        try {
				content = Files.readAllLines(Paths.get("bibliothek/woerter.txt"));
			} catch (Exception e) {
				System.out.println("Coudln't read the file");
			}
	        
	        Collections.sort(content, new WordComparator());
	        
	       
	       
	        
	        String text = "";
	        
	        for(String s : content) {
	        	text += s + "\n";
	        }
	        
	        openFileReverse();
	        addText(text); 
	        closeFile();
	        
	        
	        return text;
	        
	}
	 
	 public String getPlural(int line) {
		 String plural="";
			
			try {
				plural = Files.readAllLines(Paths.get("bibliothek/woerter.txt")).get(line);
			} catch (Exception e) {
				System.out.println("Couldn't read the file");
			}
			
			String [] words = plural.split(" ");
			plural = words[2];
			return plural;
	 }
	 
	 public String getArtikel(int line) {
		String artk="";
		
		try {
			artk = Files.readAllLines(Paths.get("bibliothek/woerter.txt")).get(line);
		} catch (Exception e) {
			System.out.println("Couldn't read the file");
		}
		
		String [] words = artk.split(" ");
		artk = words[0];
		return artk;
	}
	
	
	 public String getWort(int line) {
		 String wort="";
			
			try {
				wort = Files.readAllLines(Paths.get("bibliothek/woerter.txt")).get(line);
			} catch (Exception e) {
				System.out.println("Couldn't read the file");
			}
			
			String [] words = wort.split(" ");
			wort = words[1];
			return wort;
	 }
   
	 public void search(String s, JList<String> list) {
		 
		 for(int i=0; i< listLines(); i++) {
			 if(getWort(i).contains(s)) {
				 list.setSelectedIndex(i);
				 list.ensureIndexIsVisible(i);
			 }
		 }
		
		
	 }
	 
	 
			
	 
	 public String getRandomWort(List<Integer> list) {
		 
		 if(repeat==0) {
			 repeat++;
			 return getWort(list.get(repeat));
			
		 }
		 
		
		 repeat++;
		 
		 if(repeat==listLines()) {
			 repeat=0;
			 Collections.shuffle(list);
			 
		 }
		 
		 return getWort(list.get(repeat));
		 

	 }	 
	 

	 public int getIndex(JTextArea j) {
		 
		 for(int i=0; i<listLines(); i++) {
			if(j.getText().equals(getWort(i))) {
				return i;
			}
		 }
		 
		 return 0;
		 
	 }
}

