package com.jdes.darts;

import java.util.ArrayList;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Collections;

import java.io.*;
import java.lang.reflect.Type;


public class HighScore {
	
	static Gson gson = new Gson();
	
	
	private static List<Integer> highScores = new ArrayList<Integer>();
	private static String jsonList = gson.toJson(highScores);
	private static List<Integer> blankList = new ArrayList<Integer>();
	private static String jsonBlankList = gson.toJson(blankList);
	
	public static void putInList(int newScore) {
		highScores.add(newScore);
		Collections.sort(highScores);
	}
	
	public static void makeJSON() {
		 jsonList = gson.toJson(highScores);
		
	}
	
	public static void writeJSON() {
		File myDartsHS = new File("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores", "dartsmath.txt");
		if (myDartsHS.exists()) {
			try {
				FileWriter fileWriter = new FileWriter("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores/dartsmath.txt");
				fileWriter.append(jsonList);
				fileWriter.close();
				
			} catch (IOException e) {
		// What is printStackTrace?
				e.printStackTrace(); }
			
		}
		else {
			try {
				myDartsHS.createNewFile();
				FileWriter fileWriter = new FileWriter("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores/dartsmath.txt");
				fileWriter.write(jsonList);
				fileWriter.close();
				
			}
			catch (IOException e) { 
				e.printStackTrace();
			}
		}	
				
			}
	public static void loadJSON() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores/dartsmath.txt"));
			// should GsonPrac be Integer???
			Type listType = new TypeToken<ArrayList<Integer>>(){}.getType();
			List<Integer> highScorez = new Gson().fromJson(br, listType);
			highScores.clear();
			highScores.addAll(highScorez);
			
			
			}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void printList() {
		for (int i=0;i < highScores.size(); i++) {
			System.out.println(highScores.get(i));
			
	}
	}
	
	public static void ifFileExists() {
		File myDartsHS = new File("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores", "dartsmath.txt");
		if (myDartsHS.exists()) {
			HighScore.loadJSON();
		}
		else {
			HighScore.writeJSON();
		}
		}
	
	public static void resetHS() {
		// i'm not sure if this replicates what I did in python
		// revist json.dump(self.blank_list, outfile) if needed...
	try {	
		FileWriter fileWriter = new FileWriter("/Users/HomeFolder/Desktop/DevPortfolio/Java/HighScores/dartsmath.txt");
		fileWriter.write(jsonBlankList);
		fileWriter.close();
		DmInstruc.start();
		
	}
	catch (IOException e) { 
		e.printStackTrace();
	}
	DmInstruc.start();
	}
		
		

	
	public static void printHS() {
		System.out.println("These are the TOP 10 high scores!");
		Collections.sort(highScores);
		// This saves teh top 10 high scores to a list... 
		
//		ArrayList<Integer> subLi = new ArrayList<Integer>(highScores.subList(0,10));
		
		for(int i=0;i < highScores.size(); i++) {
			int grower = i+1;
			System.out.println(grower + ": " + highScores.get(i));
			if ( grower == 10 ) {
				DmInstruc.start(); }
		}
		DmInstruc.start();
		
		
				
	}
	}
	


