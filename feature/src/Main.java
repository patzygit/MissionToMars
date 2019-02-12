import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args){
        //load items phase 1 and phase 2
        Simulation simulation = new Simulation();
        try{
            ArrayList<Item> phase1Values = simulation.loadItems("feature\\src\\data\\Phase1.txt");
            ArrayList<Item> phase2Values = simulation.loadItems("feature\\src\\data\\Phase2.txt");
            System.out.println("Phase 1 and Phase 2 values loaded");

            //load U1s -> load a fleet of U1 rockets for phase 1
            Collections.sort(phase1Values, comparing(Item::getWeight).reversed());
            ArrayList<Rocket> fleetU1 = simulation.loadU1(phase1Values);
            System.out.println("numero de naves" + fleetU1.size());

        }
        catch (FileNotFoundException exception){
            exception.printStackTrace();
        }



        //load a fleet of U1 rockets for phase 2

        //run the simulation using the fleet of U1 rockets and display the total budget required

        //repeat for U2

    }
}
