public class Rocket implements SpaceShip{
    /*
    launch and land methods in the Rocket class should always return true.
    When U1 and U2 classes extend the Rocket class they will override these methods
    to return true or false based on the actual probability of each type.
     */
    @Override
    public boolean launch(){
        return true;
    }

    @Override
    public boolean land(){
        return true;
    }

    /*
    carry and canCarry should be implemented here and will not need to be overridden in the U1 and U2 classes
    */
    @Override
    public boolean canCarry(Item item){
        return true;
    }

    @Override
    public boolean carry(Item item){
        return true;
    }
}
