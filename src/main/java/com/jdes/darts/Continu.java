package com.jdes.darts;

import java.util.Scanner;
import java.lang.System;

public class Continu {
	
	public static void continu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like to continue?\n>");
		// get usr input 
		String usrinp = scan.nextLine();
		// close scan so it doesn't leak...
		scan.close();
		 
		// I prefer nextLine() as opposed to next(). 
		
		if ( usrinp.matches(".*y.*") || usrinp.matches(".*Y.*") )
			Play.throwDarts();
		else 
			System.out.println("Bye!");
			System.exit(0);
			
		
		
		
		
		
	}

}
