package com.jdes.darts;

import java.util.Scanner;
import java.lang.System;

public class DmInstruc {
	// if this only get's called when DmInstruc gets called then this is useless 
	// I may need to move this to...
	private static long t0 = System.currentTimeMillis();

	public static void main(String[] args) {
		
		// How do I instantiate a class within the main function in java?
		
		start();
		

	}
	
	public static void instructions() {
	      String greeting = "Welcome to Dart Math!\n"
	      + "This program is designed to let you practice your mental\n"
	      + "addition/subtraction so you don't make a fool\n"
	      + "out of yourself come game time!\n"
	      + "\n"
	      + "Here are the accepted commands from the main prompt:\n\n"
	      + "help - provides instructions for the game.\n"
	      + "start - initiates the game play.\n"
	      + "high score - allows you to view your previously acheived high scores. Scores are \n"
	      + "how long it took you to complete the program (i.e. get your score to 0)\n"
	      + "clear - allows you to clear the high score list.\n"
	      + "quit - allows you to quit the program without altering the high score list.\n\n";
	      String breakup = "-";
	      String breakupRep = new String(new char[50]).replace("\0", breakup);

	      System.out.println(greeting + breakupRep + "\n\n");
	      start();
	      

	    };
	 
	public static void start() {
		Scanner scan = new Scanner(System.in);
		
		String optionz = "Welcome to Darts Math! What would you like to do? \n" 
				+ "1. Instructions \n"
				+ "2. Play \n"
				+ "3. See High Scores\n"
				+ "4. Skip \n"
				+ "5. Clear High Scores \n"
				+ "6. Quit \n";
				
		
		System.out.println(optionz);
		
		String usrinp = scan.nextLine().toLowerCase();
		
		if ( usrinp.matches(".*1.*") || usrinp.matches(".*instruc.*") ) {
			instructions();}
		
		else if ( usrinp.matches(".*2.*") || usrinp.matches(".*play.*") ) {
			Play.throwDarts(); }
		else if ( usrinp.matches(".*3.*") || usrinp.matches(".*see high scores.*") ) {
			HighScore.ifFileExists();
			HighScore.makeJSON();
			HighScore.writeJSON();
			HighScore.printHS(); }
		else if ( usrinp.matches(".*4.*") || usrinp.matches(".*skip.*") ) {
			endd();}
		
		else if ( usrinp.matches(".*5.*") || usrinp.matches(".*clear.*") ) {
			HighScore.resetHS();
		}
		else if ( usrinp.matches(".*6.*") || usrinp.matches(".*quit.*") ) {
			endd();
		}	
		scan.close();
			
		
	}
	
	public static void endd() {
		
		
		String endOut = "\n"  
				+ "You've gotten to 0! ... or a bit past that, but that's ok this isn't"
				+ "real darts anyways!"
				+ "\n";
		
		System.out.println(endOut);
		
		HighScore.ifFileExists();
		HighScore.makeJSON();
		HighScore.writeJSON();
		
		// how do I get from long to int?
		long t1 = System.currentTimeMillis();
		long totalTimez = (t0 - t1) / 1000 ;
		// long to int conversion 
		int totalTime = (int) totalTimez;
		HighScore.putInList(totalTime);
		HighScore.makeJSON();
		HighScore.writeJSON();
		HighScore.loadJSON();
		
		System.exit(0);
		

	}
	
	public static void continu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like to continue?");
		
		String usrinp = scan.nextLine().toLowerCase();
		
		if ( usrinp.matches(".*yes.*") ) {
			Play.throwDarts();
		} else {
			System.out.println("Bye Bye!");
			endd();
		}
		scan.close();
			
//	    cont = input('''
//
//	    	    Would you like to continue?\n>''')
//	    	    if cont.lower() in ['yes','y','yeah','mhm','yez']:
//	    	        p1.throw_dart()
//	    	    else:
//	    	        print("BYE BYE!")
//	    	        quit(0)
		
	}
	
}
