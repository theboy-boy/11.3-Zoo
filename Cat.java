import java.util.*;
import java.awt.*;

public class Cat extends Animal{
    private int lives;
    public Cat(String name, int x, int y, int hunger, boolean isSick){
        super("animal", 0, 0, 0, false);
        this.lives = 9;
        this.x=x;
        this.y=y;
        this.name=name;
    }


    // TODO: override the tick method
    public void tick(Zoo zoo){
        if (age == 0){
            System.out.println(name+" was born");
        }
        age++;
        int chance = (int)Math.random()*101;
        if (chance>=1){
            lives--;
            hunger=100;
        }else if(chance >=10 && isSick== true){
            lives--;
        }
        if (lives <=0){
            alive = false;
            System.out.println("Cat "+name+" died of death");
        }
        if (hunger<=0){
            lives--;
            if (lives <= 0){
                System.out.println("Cat "+name+" died of hunger. age:"+age);
                alive = false;
            }
            hunger=100;
        }
        hunger--;
        this.move(zoo);
        

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐈", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);

    }

    // TODO: override the eat method
    public void eat(Food food){
        if (hunger > 25){
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
        boolean movedAway=false;
        ArrayList<Entity> nearEntities = this.getNeighbors(zoo);
        movedAway=false;
            for (Entity e: nearEntities){
                if (e instanceof Food){
                    this.x=e.getX();
                    this.y=e.getY();
                    if (hunger>=25&&Math.random()*101>1){                   
                        this.eat((Food)e);
                    }
                }
                if (e instanceof Animal){
                    this.x+=(this.x-e.getX());
                    this.y+=(this.y-e.getY());
                    movedAway=true;
                    break;
                }
            }
            if(movedAway==false){
            directionX=0;
            directionY=0;
            directionX+=randomX;
            directionY+=randomY;
            if (x<=0){
                directionX++;
            }
            if (y<=0){
                directionY++;
            }
            if (x>=60){
                directionX--;
            }
            if (y>=30){
                directionY--;
            }
            if (directionX<0){
                x--;
            }else if (directionX>0){
                x++;
            }
            if (directionY<0){
                y--;
            }else if (directionY>0){
                y++;
            }
        }

            
                










         

            
        
       
    }

}