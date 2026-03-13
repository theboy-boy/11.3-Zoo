
// TODO: make Food abstract
// TODO: extend Entity
public abstract class Food extends Entity{
    protected int nutrition;
    protected boolean isAnimal;
    protected int age;
    protected boolean isVegtable;
    protected boolean rot;
    public Food(String name, int x, int y, boolean isAnimal, int age, boolean isVegtable, boolean rot){
        super("Edible", 0, 0);
        
    }
    abstract void beEaten(Animal animal);
    // TODO: add instance variables
    
    // TODO: add constructor

    // TODO: add abstract method beEaten(Animal eater)

    // TODO: add non-abstract methods as needed

}