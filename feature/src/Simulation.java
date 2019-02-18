import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class Simulation {
    private ArrayList<Rocket> fleetU1;
    private ArrayList<Rocket> fleetU2;

    public Simulation(){

    }

    //this method loads all items from a text file and returns an ArrayList of Items
    public ArrayList<Item> loadItems(String path) throws FileNotFoundException {
        ArrayList<Item> listItems = new ArrayList<>();
        try {
            File filePath = new File(path);
            Scanner scanner = new Scanner(filePath);
            while (scanner.hasNextLine()){
                String itemString = scanner.nextLine();
                Item item = loadItemObject(itemString);
                listItems.add(item);
            }
            return listItems;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return listItems;
    }

    //This method create the Item object
    public Item loadItemObject(String fullNameTxt){
        String [] values = fullNameTxt.split("=");
        int weight = Integer.parseInt(values[1]);
        Item item = new Item(values[0], weight);
        return item;
    }

    /*
    * this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
    * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object
     * and filling that one until all items are loaded.
     * The method then returns the ArrayList of those U1 rockets that are fully loaded.*/
    public ArrayList<Rocket> loadU1(ArrayList<Item> items){
    	fleetU1 = new ArrayList<Rocket>();
        fleetU1.add(new U1());
        int r = 0;
        for(int i =0; i < items.size(); i++ ) {
        	if(loadRocket(fleetU1.get(r),items.get(i))) {
        		fleetU1.add(new U1());
        		r++;
        		loadRocket(fleetU1.get(r),items.get(i));
        	}
        }
        return fleetU1;
    }

    /*this method also takes the ArrayList of Items and starts creating U2 rockets
     and filling them with those items the same way as with U1 until all items are loaded.
     The method then returns the ArrayList of those U2 rockets that are fully loaded.*/
    public ArrayList<Rocket> loadU2(ArrayList<Item> items){
        fleetU2 = new ArrayList<Rocket>();
        fleetU2.add(new U2());
        int r = 0;
        for(int i =0; i < items.size(); i++ ) {
        	if(loadRocket(fleetU2.get(r),items.get(i))) {
        		fleetU2.add(new U2());
        		r++;
        		loadRocket(fleetU2.get(r),items.get(i));
        	}
        }
        return fleetU2;
    }
    
    public boolean loadRocket(Rocket rocket, Item item) {
    	boolean isFull = false;
    		if(rocket.canCarry(item)) {
    			rocket.addItem(item);
    		} else {
    			isFull = true;
    		}
    	return isFull;
    }

    /*this method takes an ArrayList of Rockets and calls launch and land methods
    for each of the rockets in the ArrayList.
    Every time a rocket explodes or crashes (i.e if launch or land return false)
    it will have to send that rocket again.
    All while keeping track of the total budget required to send each rocket safely to Mars.
    runSimulation then returns the total budget required to send all rockets (including the crashed ones).*/
    public void runSimulation(){
    	try{
            ArrayList<Item> phase1Values = loadItems("feature\\src\\data\\Phase1.txt");
            ArrayList<Item> phase2Values = loadItems("feature\\src\\data\\Phase2.txt");
            System.out.println("Phase 1 and Phase 2 values loaded");

            //load U1s,U2s -> load a fleet of U1 rockets for phase 1
            Collections.sort(phase1Values, comparing(Item::getWeight));
            fleetU1 = loadU1(phase1Values);
            fleetU2 = loadU2(phase1Values);
            System.out.println("Number of Rocket phase 1 - u1: " + fleetU1.size());
            System.out.println("Number of Rocket phase 1 - u2: " + fleetU2.size());
            System.out.println("Simulating U1s phase 1");
            System.out.println("Total budget is: " + budgetByFleet(fleetU1) + " Millions");
            System.out.println("Simulating U2s phase 1");
            System.out.println("Total budget is: " + budgetByFleet(fleetU2) + " Millions");
            System.out.println("finish");
            
          //load U1s,U2s -> load a fleet of U1 rockets for phase 2
            Collections.sort(phase2Values, comparing(Item::getWeight));
            fleetU1 = loadU1(phase2Values);
            fleetU2 = loadU2(phase2Values);
            System.out.println("Number of Rocket phase2 - u1: " + fleetU1.size());
            System.out.println("Number of Rocket phase2 - u2: " + fleetU2.size());
            System.out.println("Simulating U1s phase 2");
            System.out.println("Total budget is: " + budgetByFleet(fleetU1) + " Millions");
            System.out.println("Simulating U2s phase 2");
            System.out.println("Total budget is: " + budgetByFleet(fleetU2) + " Millions");
            System.out.println("finish");
        }
        catch (FileNotFoundException exception){
            exception.printStackTrace();
        }   	
    	
    }
    
    public int budgetByFleet(ArrayList<Rocket> fleet) {
    	int aux = 0;
        for(int i =0; i<fleet.size();i++) {
        	while (fleet.get(i).launch()) {
        		System.out.println("Crashed");
        		aux ++;
        	}
        	while (fleet.get(i).land()) {
        		System.out.println("Exploded");
        		aux ++;
        	}
        	System.out.println("rocket landed");
        }
        int totalBudget = (fleet.size() + aux) * fleet.get(1).getRocketCost();
        return totalBudget;
    }
}
