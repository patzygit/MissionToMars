import java.util.Random;

public class U1 extends Rocket{
    /*
    Rocket cost = $100 Million
    Rocket weight = 10 Tonnes
    Max weight (with cargo) = 18 Tonnes
    Chance of launch explosion = 5% * (cargo carried / cargo limit)
    Chance of landing crash = 1% * (cargo carried / cargo limit)
    * */


    public U1(){
        super(100, 18000, 10000);
    }

    @Override
    //Chance of landing crash = 1% * (cargo carried / cargo limit)
    public boolean land(){
        double chanceCrash =  0.01*((double)getRocketCurrentWeight() / (double)getRocketCapacity());        
        if (generateRandom() >= chanceCrash){
            return false;
        }
        else return true;
    }

    @Override
    //Chance of launch explosion = 5% * (cargo carried / cargo limit)
    public boolean launch(){
        double chanceExplosion = 0.05*((double)getRocketCurrentWeight() / (double)getRocketCapacity());
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
