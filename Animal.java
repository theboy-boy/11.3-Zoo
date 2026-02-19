public abstract class Animal extends Entity{

    protected int hunger;
    protected boolean isSick;
    public Animal(String name, int x, int y, int hunger, boolean isSick){
        super("animal", 0, 0);
        this.hunger = hunger;
        this.isSick = isSick;
    }

    // TODO: instance variables

    // TODO: add constructor

    abstract void eat(Food food);
    abstract void move(Zoo zoo);
    
    // TODO: add non-abstact methods as necessary
}
