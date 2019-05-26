package com.jdes.darts;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Score {
	
	// adding static here allows this Scanner to be accessed throughout the methods
	// in this class 
	private static Scanner scan = new Scanner(System.in);
	private static List<Integer> total = new ArrayList<Integer>() {{
		add(300);
	}};
	
	

	public static int totalScore() {
		return total.get(0);
	}
	
	public static int currentScore() {
//		int currScore = total.get(total.size() - 1);
		
		return total.get(total.size() - 1);
	}
	
	public static void subFromTotal(int SumScore) {
		// before continuing, make sure you understand how to define a list! 
		total.add(totalScore() - SumScore);
		int prevTotal = total.get(total.size() -2);
		System.out.println("Now what is your new total?\n (hint: subtract from "+ prevTotal+")");
		// user's guess at total 
		int newTotal = scan.nextInt();
		
		while ( newTotal != currentScore() ) {
			System.out.println("Try again!");
			newTotal = scan.nextInt();
		}
		
		if ( newTotal == currentScore() )
			System.out.println("Correct!");
			total.set(0, currentScore());
			if ( total.get(0) <= 0 ) {
				DmInstruc.endd(); 
			}else {
				DmInstruc.continu();
			}
			
				
	}

}



