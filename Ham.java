import java.util.*;
import java.awt.*;
public class Ham extends Food {
    public Ham(String name, int x, int y, boolean isAnimal, int age, boolean isVegtable, boolean rot){
        super("Edible", 0, 0, false, 0, false, false);
        this.rot = false;
        this.x=x;
        this.y=y;
        this.isAnimal=false;
        this.name=name;
    }
    public void tick(Zoo zoo){
        age++;
        if (age>=200){
            if (Math.random()*101<2){
                rot = true;
            }
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🍖", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
    }
    public void beEaten(Animal animal){
        animal.hunger+=15;
        this.alive=false;
        if (rot==true){
            animal.isSick=true;
        }
    }
}
  
