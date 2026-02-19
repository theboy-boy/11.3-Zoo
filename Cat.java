import java.util.Random;
import java.util.*;
import java.awt.*;

// TODO: extend Animal
public class Cat extends Animal{
    private int lives;
    public Cat(String name, int x, int y, int hunger, boolean isSick){
        super("animal", 0, 0, 0, false);
        this.lives = 9;
    }


    // TODO: override the tick method
    public void tick(Zoo zoo){
        age++;
        int chance = (int)Math.random()*101;
        if (chance<=1){
            lives--;
        }else if(chance <=10 && isSick== true){
            lives--;
        }
        if (lives <=0){
            alive = false;
            System.out.println("Cat "+name+"died of death");
        }

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐈", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);

    }

    // TODO: override the eat method
    public void eat(Animal animal){
        
    }
    // TODO: override the move method


}
