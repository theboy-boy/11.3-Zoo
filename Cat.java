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
    // public boolean inBound(ArrayList<ArrayList<Entity>> grid, int x, int y){

    // }
    
    public void move(Zoo zoo){
        int randomX = (int) (Math.random()*3)-1;
        int randomY = (int) (Math.random()*3)-1;
        double directionX = 0.0;
        double directionY = 0.0;
        boolean animalNear = false;
        if (age%10==0){
            directionX+=randomX;
            directionY+=randomY;
            if (x==0){
                directionY++;
            }
            if (y==0){
                directionX++;
            }
            if (x==800){
                directionY--;
            }
            if (y==600){
                directionX--;
            }

            for (Entity e : zoo.at(x+(int)directionX, y+(int)directionY)){
                if (e instanceof Animal){
                    animalNear=true;
                    if (e instanceof Cat){
                        if (Math.random()<.89){
                            for ()
                            Cat cat = new Cat("baby cat", )
                        }
                    }
                }
            }
            if (animalNear){

            }
        }
       
    }

}
