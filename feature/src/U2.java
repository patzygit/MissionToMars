public class U2 extends Rocket{
    /*
    Rocket cost = $120 Million
    Rocket weight = 18 Tonnes
    Max weight (with cargo) = 29 Tonnes
    Chance of launch explosion = 4% * (cargo carried / cargo limit)
    Chance of landing crash = 8% * (cargo carried / cargo limit)
    * */

    public U2(int u1cost, int u1Capacity, int u1Weigt){
        super(u1cost, u1Capacity, u1Weigt);
    }

    @Override
    public boolean land(){
        return true;
    }

    @Override
    public boolean launch(){
        return true;
    }
}
