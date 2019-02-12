import java.util.Random;

public class U1 extends Rocket{
    /*
    Rocket cost = $100 Million
    Rocket weight = 10 Tonnes
    Max weight (with cargo) = 18 Tonnes
    Chance of launch explosion = 5% * (cargo carried / cargo limit)
    Chance of landing crash = 1% * (cargo carried / cargo limit)
    * */
    private int u1cost;
    private int u1Capacity;
    private int u1Weigt;


    public U1(int u1cost, int u1Capacity, int u1Weigt){
        super(u1cost, u1Capacity, u1Weigt);
    }

    @Override
    //Chance of landing crash = 1% * (cargo carried / cargo limit)
    public boolean land(){
        double chanceCrash =  0.01*(getRocketWeight() / getU1Capacity());
        if (generateRandom() >= chanceCrash){
            return false;
        }
        else return true;
    }

    @Override
    //Chance of launch explosion = 5% * (cargo carried / cargo limit)
    public boolean launch(){
        double chanceExplosion = 0.05*(getRocketWeight() / getU1Capacity());
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

    public int getU1Capacity() {
        return u1Capacity;
    }

    public int getU1Weigt(){
        return u1Weigt;
    }
}
