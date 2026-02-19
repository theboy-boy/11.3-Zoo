
// TODO: make Food abstract
// TODO: extend Entity
public abstract class Food extends Entity{
    protected int nutrition;
    protected boolean isAnimal;
    protected boolean isVegtable;
    public Food(String name, int x, int y, boolean isAnimal, boolean isVegtable, int nutrition){
        super("Edible", 0, 0);
        this.nutrition = nutrition;
        
    }
    abstract void beEaten(Animal animal);
    // TODO: add instance variables

    // TODO: add constructor

    // TODO: add abstract method beEaten(Animal eater)

    // TODO: add non-abstract methods as needed

}