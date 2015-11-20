
//********************************************************************
//HW01.java       Student: Sean Stinehour
//CS280-Data Structures and Algorithms: HW01
//Represents a single game to be used in the collection
//********************************************************************


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;


public class hw01 {

	
		public static void main (String[] args)throws IOException {
			   //----------------------------------------------------------------
			   //  Creates a writer and frames
			   //----------------------------------------------------------------
			//Starts frame
			JFrame frame = new JFrame ("Display File");
		    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		    
		    //Sets up left and right panels. Sets color.
		    JPanel LeftPanel = new JPanel(new BorderLayout());
		    LeftPanel.setBackground(Color.green);
		    JPanel RightPanel = new JPanel(new BorderLayout());
			RightPanel.setBackground(Color.cyan);
			
			//Renaming panels and creating primary panel
		    JPanel panel1 = LeftPanel;
		    JPanel panel2 = RightPanel;
		    JPanel primary = new JPanel();
			
		    //Creating the Text area and background colors
		    JTextArea ta1 = new JTextArea (20, 50);
			JTextArea ta2 = new JTextArea (20, 50);     
			ta1.setBackground(Color.white);
		    ta2.setBackground(Color.orange);

//----------------------------------------------------------------
//  Initializes variables and creates linkedlist/arraylist
//----------------------------------------------------------------
String title, developer, genre, result = "";
double Price, Rating;

ArrayList gameArrayList = new ArrayList();
GameLinkedList gameLinkedList = new GameLinkedList();
Scanner filescan;
      filescan = new Scanner(new File("input.txt"));
      while (filescan.hasNext()){ 
    	//Snagging the information from the text file.
     	title = filescan.next();
        developer=filescan.next();
        genre = filescan.next();
        Price = filescan.nextDouble();
        Rating= filescan.nextDouble();
        GameElement obj = new GameElement(title, developer, genre, Price, Rating);
        //Sending it to the LinkedList and ArrayList
        gameLinkedList.addbeg(obj);
        gameArrayList.addGame(title, developer, genre, Price, Rating);
      }
//----------------------------------------------------------------
//  Sets up display and panels for displaying info
//----------------------------------------------------------------

//Testing output
System.out.println(gameLinkedList);
System.out.println (gameLinkedList.toString());

//Getting text and setting it.
String info=gameLinkedList.toString(); 
result = gameArrayList.toString();
ta1.setText (result);
ta2.setText (info);

//Creating ScrollPanes and setting them
JScrollPane sp1 = new JScrollPane(ta1);
JScrollPane sp2 = new JScrollPane(ta2);
sp1.setPreferredSize(new Dimension (600,400));
sp2.setPreferredSize(new Dimension (600,400));

//Making sure textareas are not editable
ta1.setEditable(false);
ta2.setEditable(false);

//Setting up Labels
JLabel lab1 = new JLabel("ArrayList");
JLabel lab2 = new JLabel("LinkedList");
panel1.add(lab1, BorderLayout.NORTH);
panel2.add(lab2, BorderLayout.NORTH);

//Setting up panels and showing them.
panel1.add(sp1, BorderLayout.WEST);
panel2.add(sp2, BorderLayout.EAST);
primary.add(panel1);
primary.add(panel2);

//Setting up all the GUI and showing it
frame.getContentPane().add (primary);
frame.pack();
frame.setVisible(true);



       }}

     //done