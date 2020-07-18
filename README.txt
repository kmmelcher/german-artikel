This program is intend to help people learn the German language, by practicing
one of the major problems students have in grammatics: articles and plural.

Install on Linux

- Install or update java: 
	sudo apt install default-jre

- Verify installation:
	java -version

- Clone repo:
	git clone https://github.com/kmmelcher/German_articles_practice

- move to directory: cd German_articles_practice/linux-version/

- Give .jar file permission to execute (if it's not already set): chmod +x Main.jar

- either double-click to oper or type: java -jar Main.jar


How to use it

 Click on Artikel to practice the article of each word by choosing between der, die or das. 
If you press the correct answer you will get a point in richtig, otherwise you're going to get
a point on falsh. If you go back to the Menu, your score will not be erased, only if you close 
the application.

 Click on Plural to practice the plural of each word. You must type the answer. Press enter when 
you're done and you will get your points just as in the artikel:

 Click on Wöerter to add new words. Enter the article, the word and the plural of the given word.
Press Hinzufügen to add it. By selecting a word on the list you can delete it using the button
löschen. You can also search for a word in the navigation bar.

 An alternative way of adding words is to enter the article, word and plural at the .txt file on the
bibliothek directory. You must follow this model: die Frau Frauen


Updates comming:
- Read words from multiple .txt files
