public class Rocket implements SpaceShip{
    /*
    launch and land methods in the Rocket class should always return true.
    When U1 and U2 classes extend the Rocket class they will override these methods
    to return true or false based on the actual probability of each type.
     */
    private int rocketCost;
    private int rocketCapacity;
    private int rocketWeight;
    private int cargo;

    public Rocket(int rocketCost, int rocketCapacity, int rocketWeight){
        this.rocketCost = rocketCost;
        this.rocketCapacity = rocketCapacity;
        this.rocketWeight = rocketWeight;
        this.cargo = 0;
    }

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
    /*canCarry: a method that takes an Item as an argument and returns true if the rocket can carry such item
    or false if it will exceed the weight limit.*/
    public boolean canCarry(Item item){
        System.out.println("capacity" + getRocketCapacity());
        System.out.println("weight" + getRocketWeight());
        int maxCargo = getRocketCapacity() - getRocketWeight();
        if ((maxCargo >= getCargo()) && (maxCargo >= item.getWeight())){
            System.out.println("entro");
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void carry(Item item){
        int newValue = getCargo() + item.getWeight();
        setCargo(newValue);
    }

    public int getRocketCost(){
        return rocketCost;
    }

    public int getRocketWeight(){
        return rocketWeight;
    }

    public int getRocketCapacity(){
        return rocketCapacity;
    }

    public int getCargo(){
        return cargo;
    }

    public void setCargo(int cargo){
        System.out.println("setting cargo " + cargo);
        this.cargo = cargo;
    }

}
