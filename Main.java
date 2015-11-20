package z_comments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(new File("input.java"));//Creates scanner
		String test = "";
		scan.useDelimiter(System.getProperty("line.separator"));//Seperator for lines is delimiter
		while(scan.hasNextLine()){//Iterates through Java File		
				String comment = scan.findInLine("//");//Finds the next //
				test = scan.next();//Grabs the next WORD
				if(comment != null){
					//When comment found, prints it
					System.out.println(test);
				}
			// Continues process
			if(scan.hasNextLine()==false){
				break;
			}else{
				scan.nextLine();
			}
		}
		// close the scanner object;		
		scan.close();	
		System.out.println("I LIKE WHAT YOU GOT");
	}

}
