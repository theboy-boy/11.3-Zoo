import java.util.Random;
import java.util.*;
import java.awt.*;

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
    public void eat(Food food){
        if (hunger > 25 && food.isVegtable){
            if (Math.random()*101 > 99){
                food.beEaten(this);
                System.out.println(name+" the cat ate "+food.name+"getting "+food.nutrition+"nutrition points");
            }
        }
    }
    // TODO: override the move method
    public boolean inBound(ArrayList<ArrayList<Entity>> grid, int x, int y){

    }
    public int[] check(Zoo zoo){
    for(int a = this.y-1; a>this.y+1; a++){
            for(int b = this.x-1; b>this.x+1; b++){
                if ()
            }
        }
    }
    public void move(){
        double direction=0.0;
        if(){}
        

        }else{
            direction=Math.random()*4;
            if (direction<1){
                y++;
            }else if(direction<2){
                x++;
            }else if(direction<3&&y!=0){
                y--;
            }else if(direction<4&&x!=0){
                x--;
            }
        }
    }

}
