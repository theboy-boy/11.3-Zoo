import java.util.ArrayList;

public abstract class Animal extends Entity{

    protected int hunger;
    protected boolean isSick;
    protected int nutrition;
    public Animal(String name, int x, int y, int hunger, boolean isSick){
        super("animal", 0, 0);
        this.hunger = hunger;
        this.isSick = isSick;
    }

    // TODO: instance variables

    // TODO: add constructor

    abstract void eat(Food food);
    abstract void move(Zoo zoo);
    abstract void beEaten(Animal animal);

    public ArrayList<Entity>getNeighbors(Zoo zoo){
        ArrayList<Entity> entities = new ArrayList<Entity>();
        for (int a = -1; a<2; a++){
            for (int b = -1; b<2; b++){
                if (!(x==0&&a==-1||y==0&&b==-1||x==zoo.getWidth()&&a==1||y==zoo.getHeight()&&b==1||x==0&&y==0 && (a==0&&b==0))){
                    entities.addAll(zoo.at(x+a, y+b));
                }
            }
        }
        return entities;
    }

    // TODO: add non-abstact methods as necessary
}
