public class U1 extends Rocket{
    /*
    Rocket cost = $100 Million
    Rocket weight = 10 Tonnes
    Max weight (with cargo) = 18 Tonnes
    Chance of launch explosion = 5% * (cargo carried / cargo limit)
    Chance of landing crash = 1% * (cargo carried / cargo limit)
    * */
    @Override
    public boolean land(){
        return true;
    }

    @Override
    public boolean launch(){
        return true;
    }
}
