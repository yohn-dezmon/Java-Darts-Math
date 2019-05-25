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
		
		System.out.println("Now what is your new total?");
		// user's guess at total 
		int newTotal = scan.nextInt();
		
		while ( newTotal != currentScore() ) {
			System.out.println("Try again!");
		}
		
		if ( newTotal == currentScore() )
			System.out.println("Correct! Your new total is: \n"+currentScore());
			total.set(0, currentScore());
			if ( total.get(0) <= 0 ) {
				DmInstruc.endd(); 
			}else {
				String ah = "When asked for your total at the end of the next round,\n";
				String beh = "subtract from ";
				System.out.println(ah + beh + total.get(0));
			}
			DmInstruc.continu();
				
	}

}



