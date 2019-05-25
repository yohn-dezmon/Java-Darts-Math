package com.jdes.darts;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;



import com.google.gson.Gson;

public class GsonPrac {
	
	static Gson gson = new Gson();
	private static List<Integer> highScores = new ArrayList<Integer>();
	private static String jsonList = gson.toJson(highScores);

	
	
	
	
	public static void main(String[] args) {
		highScores.add(21); // 0 
		highScores.add(55); // 1
		highScores.add(55); // 2
		highScores.add(59); // 3
		highScores.add(53); // 4
		highScores.add(50); // 5
		// How do I instantiate a class within the main function in java?
//		Play p1 = new Play();
//		Score player1 = new Score();
		System.out.println("GOGOGO");
		
		String jsonList = gson.toJson(highScores);
		
		// this outputs strings to a file... 

		File myDartsHS;
		try {
			myDartsHS = new File("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores", "dartsmath.txt");
			myDartsHS.createNewFile();
			boolean dosit = myDartsHS.exists();
			System.out.println(dosit);
			
			if (myDartsHS.exists()) {
				try {
					FileWriter fileWriter = new FileWriter("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores/dartsmath.txt");
					fileWriter.append(jsonList);
					fileWriter.close();
					
				} catch (IOException e) {
			// What is printStackTrace?
					e.printStackTrace(); }
			}
			try {
				BufferedReader br = new BufferedReader(new FileReader("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores/dartsmath.txt"));
				// should GsonPrac be Integer???
				Type listType = new TypeToken<ArrayList<Integer>>(){}.getType();
				List<Integer> highScores = new Gson().fromJson(br, listType);
//				GsonPrac instantiaton = gson.fromJson(br, GsonPrac.class);
				System.out.println(highScores);
				
//				System.out.println(highScores);
				
				}
			catch (IOException e) {
				e.printStackTrace();
			}
			

		}
		catch (Exception e) {
			System.err.println(e);
		}
		subArrayTest();
		

	}
	
	public static void subArrayTest() {
		System.out.println(highScores);
		// for the subList, the second parameter (toIndex) is EXCLUSIVE! i.e. if you put 5, it will go to index 4 :D 
		ArrayList<Integer> subLi = new ArrayList<Integer>(highScores.subList(0,5));
		for(int i=0;i < subLi.size(); i++) {
			int grower = i+1;
			System.out.println(grower + ": " + subLi.get(i));
			
		
	};
	
}}
	
