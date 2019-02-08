import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

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
    public void loadU1(ArrayList<Item> items){
        U1 rocketU1 = new U1();
        //load all U1 rockets that we can
    }

    /*this method also takes the ArrayList of Items and starts creating U2 rockets
     and filling them with those items the same way as with U1 until all items are loaded.
     The method then returns the ArrayList of those U2 rockets that are fully loaded.*/
    public void loadU2(ArrayList<Item> items){
        U2 rocketU2 = new U2();
        //load all U1 rockets that we can
    }

    /*this method takes an ArrayList of Rockets and calls launch and land methods
    for each of the rockets in the ArrayList.
    Every time a rocket explodes or crashes (i.e if launch or land return false)
    it will have to send that rocket again.
    All while keeping track of the total budget required to send each rocket safely to Mars.
    runSimulation then returns the total budget required to send all rockets (including the crashed ones).*/
    public void runSimulation(ArrayList<Rocket> rockets){

    }

/*
    public static void main(String[] args){
      Simulation simulation = new Simulation();
      try {
          ArrayList items = simulation.loadItems("feature\\src\\data\\Phase1.txt");
      }
      catch (FileNotFoundException e){
          e.printStackTrace();
      }
    }*/
}
