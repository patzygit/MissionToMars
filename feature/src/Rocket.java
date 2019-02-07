public class Rocket implements SpaceShip{
    @Override
    public boolean launch(){
        return true;
    }

    @Override
    public boolean land(){
        return true;
    }

    @Override
    public boolean canCarry(Item item){
        return true;
    }

    @Override
    public boolean carry(Item item){
        return true;
    }
}
