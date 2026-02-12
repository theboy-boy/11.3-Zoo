import java.awt.Graphics;

public abstract class Entity {
    // optional code to assign a sequencial entity ID
    private static int lastID = 0;
    protected int id;
    protected boolean alive = true;
    protected int x;
    protected int y;
    protected String name;
    

    // TODO: add the Entity instance variables

    public Entity(String name, int x, int y) {
        this.id = lastID;
        this.lastID = lastID + 1;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public abstract void tick(Zoo z);
    public abstract void draw(Graphics g);


    public boolean isAlive(){
        return alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
