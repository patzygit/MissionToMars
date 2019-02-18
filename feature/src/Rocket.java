import java.util.ArrayList;

public abstract class Rocket implements SpaceShip{
    /*
    launch and land methods in the Rocket class should always return true.
    When U1 and U2 classes extend the Rocket class they will override these methods
    to return true or false based on the actual probability of each type.
     */
    private int rocketCost;
    private int rocketCapacity;
    private int rocketCurrentWeight;
    private ArrayList<Item> itemList;

    public Rocket(int rocketCost, int rocketCapacity, int rocketCurrentWeight){
        this.rocketCost = rocketCost;
        this.rocketCapacity = rocketCapacity;
        this.rocketCurrentWeight = rocketCurrentWeight;
        itemList = new ArrayList<Item>();
    }


    public abstract boolean launch();

    public abstract boolean land();

    /*
    carry and canCarry should be implemented here and will not need to be overridden in the U1 and U2 classes
    */
    @Override
    /*canCarry: a method that takes an Item as an argument and returns true if the rocket can carry such item
    or false if it will exceed the weight limit.*/
    public boolean canCarry(Item item){
        int newRocketWeight = rocketCurrentWeight + item.getWeight();
        boolean hasCapacity= false;
        if (newRocketWeight <= rocketCapacity){
        	hasCapacity = true;
        }

        return hasCapacity;
    }

    @Override
    public void carry(Item item){
        rocketCurrentWeight = rocketCurrentWeight + item.getWeight();
    }

    public int getRocketCurrentWeight(){
        return rocketCurrentWeight;
    }

    public int getRocketCapacity() {
    	return rocketCapacity;
    }

    public int getRocketCost(){
        return rocketCost;
    }

    public void addItem(Item item) {
    	itemList.add(item);
    	carry(item);

    }

}
