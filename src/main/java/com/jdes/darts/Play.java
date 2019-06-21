package com.jdes.darts;

import java.util.Scanner;


public class Play {
	
	

	
	public static void throwDarts() {
		int currScore = Score.currentScore();
		
		System.out.println("Your current total is: " + currScore);
		System.out.println("You throw three darts");
		
		int dart1 = (int)(Math.random()*60 + 1);
		System.out.println(dart1);
		
		int dart2 = (int)(Math.random()*60 +1);
		System.out.println(dart2);
		
		int dart3 = (int)(Math.random()*60 +1);
		System.out.println(dart3+"\n");
		
		int SumScore = dart1 + dart2 + dart3;
		
		int guessSum = 0;
		boolean sauce = true;
		while ( sauce == true ) {
			Scanner scan = new Scanner(System.in);
			System.out.println("What is the sum of these three integers? ");
			// user's guess
			try {
				
				guessSum = scan.nextInt();
				
				sauce = false;
			}
			catch (Exception e) {
				System.out.println("That's not a number, mi friend!");
			}
		
		while ( guessSum != SumScore ) {
			System.out.println("Please try again!");
			guessSum = scan.nextInt();
		}
		if ( guessSum == SumScore )
			System.out.println("Correct!");
			Score.subFromTotal(SumScore);
			
			
		scan.close();
						
		}
	}

}
