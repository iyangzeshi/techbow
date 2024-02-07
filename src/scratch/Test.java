package scratch;

/*
Project: techbow
Package: scratch
ClassName: MinValues
Description:
Author: Jesse Yang
Date: 2023-09-02 星期六 20:06
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
	
	}
	
}

class PlantArrayListExample {
	
	// TODO: Define a printArrayList method that prints an ArrayList of plant (or flower) objects
	public static void printArrayList(ArrayList<Plant> garden) {
		for (int i = 0; i < garden.size(); i++) {
			System.out.println("Plant " + (i + 1) + " Information: ");
			garden.get(i).printInfo();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input;
		// TODO: Declare an ArrayList called myGarden that can hold object of type plant
		ArrayList<Plant> myGarden = new ArrayList<>();
		
		// TODO: Declare variables - plantName, plantCost, flowerName, flowerCost, colorOfFlowers,
		//  isAnnual
		String plantName;
		String plantCost;
		String flowerName;
		String flowerCost;
		String colorOfFlowers;
		boolean isAnnual;
		
		input = scnr.next();
		while (!input.equals("-1")) {
			// TODO: Check if input is a plant or flower
			//       Store as a plant object or flower object
			//       Add to the ArrayList myGarden
			if (input.equals("plant")) {
				Plant tmp = new Plant();
				tmp.setPlantName(scnr.next());
				tmp.setPlantCost(scnr.next());
				myGarden.add(tmp);
			} else {
				Flower tmp = new Flower();
				tmp.setPlantName(scnr.next());
				tmp.setPlantCost(scnr.next());
				tmp.setPlantType(scnr.nextBoolean());
				tmp.setColorOfFlowers(scnr.next());
				myGarden.add(tmp);
			}
			
			input = scnr.next();
		}
		
		// TODO: Call the method printArrayList to print myGarden
		printArrayList(myGarden);
	}
}

class Plant {
	
	protected String plantName;
	protected String plantCost;
	
	public String getPlantName() {
		return plantName;
	}
	
	public void setPlantName(String userPlantName) {
		plantName = userPlantName;
	}
	
	public String getPlantCost() {
		return plantCost;
	}
	
	public void setPlantCost(String userPlantCost) {
		plantCost = userPlantCost;
	}
	
	public void printInfo() {
		System.out.println("   Plant name: " + plantName);
		System.out.println("   Cost: " + plantCost);
	}
}

class Flower extends Plant {
	
	private boolean isAnnual;
	private String colorOfFlowers;
	
	public boolean getPlantType() {
		return isAnnual;
	}
	
	public void setPlantType(boolean userIsAnnual) {
		isAnnual = userIsAnnual;
	}
	
	public String getColorOfFlowers() {
		return colorOfFlowers;
	}
	
	public void setColorOfFlowers(String userColorOfFlowers) {
		colorOfFlowers = userColorOfFlowers;
	}
	
	@Override
	public void printInfo() {
		System.out.println("   Plant name: " + plantName);
		System.out.println("   Cost: " + plantCost);
		System.out.println("   Annual: " + isAnnual);
		System.out.println("   Color of flowers: " + colorOfFlowers);
	}
}






