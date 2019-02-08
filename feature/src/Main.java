import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //load items phase 1 and phase 2
        Simulation simulation = new Simulation();
        try{
            ArrayList<Item> phase1Values = simulation.loadItems("feature\\src\\data\\Phase1.txt");
            ArrayList<Item> phase2Values = simulation.loadItems("feature\\src\\data\\Phase2.txt");
            System.out.println("Phase 1 and Phase 2 values loaded");
        }
        catch (FileNotFoundException exception){
            exception.printStackTrace();
        }

        //load a fleet of U1 rockets for phase 1

        //load a fleet of U1 rockets for phase 2

        //run the simulation using the fleet of U1 rockets and display the total budget required

        //repeat for U2

    }
}
