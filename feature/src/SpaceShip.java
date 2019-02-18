public interface SpaceShip {
    //launch: a method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
    boolean launch();

    //land: a method that also returns either true or false based on the success of the landing.
    boolean land();

    //canCarry: a method that takes an Item as an argument and returns true if the rocket can carry such item or false if it will exceed the weight limit.
    boolean canCarry(Item item);

    //carry: a method that also takes an Item object and updates the current weight of the rocket.
    void carry(Item item);
}
