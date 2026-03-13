import java.util.*;
import java.awt.*;
public class Cheese extends Food {
    public Cheese(String name, int x, int y, boolean isAnimal, int age, boolean rot){
        super("Edible", 0, 0, false, 10, false);
        this.nutrition = nutrition;
        this.rot = false;
        this.name=name;
        this.x=x; 
        this.y=y; 
        this.isAnimal=isAnimal;
        this.age=age;
        this.rot=rot;
        
    }
    public void tick(Zoo zoo){
        age++;
        if (age>=400){
            if (Math.random()*101<2){
                rot = true;
            }
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🧀", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
    }
    public void beEaten(Animal animal){
        if (nutrition == 10){
            animal.hunger+=10;
            this.nutrition=7;
        }else if (nutrition == 7){
            animal.hunger+=7;
            this.nutrition=5;
        }else if (nutrition == 5){
            animal.hunger+=5;
            this.alive=false;
        }
        if (rot==true){
            animal.isSick=true;
        }
    }
}
  
