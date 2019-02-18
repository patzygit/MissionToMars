import java.util.Random;

public class U2 extends Rocket{
    /*
    Rocket cost = $120 Million
    Rocket weight = 18 Tonnes
    Max weight (with cargo) = 29 Tonnes
    Chance of launch explosion = 4% * (cargo carried / cargo limit)
    Chance of landing crash = 8% * (cargo carried / cargo limit)
    * */

    public U2(){
        super(120, 29000, 18000);
    }

    @Override
    //Chance of landing crash = 8% * (cargo carried / cargo limit)
    public boolean land(){
    	double chanceCrash =  0.08*((double)getRocketCurrentWeight() / (double)getRocketCapacity());  
    	 if (generateRandom() >= chanceCrash){
             return false;
         }
         else return true;
    }

    @Override
    //Chance of launch explosion = 4% * (cargo carried / cargo limit)
    public boolean launch(){
    	double chanceExplosion = (0.04*(double)getRocketCurrentWeight() / (double)getRocketCapacity());
        if (generateRandom() >= chanceExplosion){
            return false;
        }
        else return true;
    }


    //Generate a random number
    public double generateRandom(){
        Random random = new Random();
        double randomValue = 0 + (1 - 0) * random.nextDouble();
        return randomValue;
    }
	
}
