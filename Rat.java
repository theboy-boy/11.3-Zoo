import java.util.*;
import java.awt.*;
public class Rat extends Animal{
    private int hunger = 100;
    private int preferedDirection;
    public Rat(String name, int x, int y, int hunger, boolean isSick){
        super("animal", 0, 0, 100, false);
        this.x=x;
        this.y=y;
        this.name=name;
        this.preferedDirection=(int)(Math.random()*4);
    }
    public void tick(Zoo zoo){
        age++;
        if (age>=500){
            if (Math.random()*101<2){
                alive=false;
            }
        }
        if (age>=50){
            preferedDirection=(int)(Math.random()*4);
        }
        if (hunger>20){
            hunger--;
        }
        if (age%2==1){
            this.move(zoo);
        }
    }
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐀", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);
    }
    public void beEaten(Animal animal){
        animal.hunger+=15;
        this.alive=false;
    }
    public void move(Zoo zoo){
        int randomDirect = (int) (Math.random()*6);
        boolean movedAway=false;
        ArrayList<Entity> nearEntities = this.getNeighbors(zoo);
            for (Entity e: nearEntities){
                if (e instanceof Cheese){
                    this.x=e.getX();
                    this.y=e.getY();              
                    this.eat((Food)e);
                }
                if (e instanceof Ham){    
                    if (hunger<=50&&Math.random()*101>1){
                        this.x=e.getX();
                        this.y=e.getY();              
                        this.eat((Food)e);
                    }
                }
            }

            int directionX=0;
            int directionY=0;
            
            if (movedAway==false){
                if (randomDirect<3){
                    if (randomDirect<1){
                        directionX=1;
                    }if (randomDirect<2){
                        directionX=-1;
                    }else{
                        directionX=0;
                    }
                }else{
                    if (randomDirect<4){
                        directionY=1;
                    }if (randomDirect<5){
                        directionY=-1;
                    }else{
                        directionY=0;
                    }
                }
                
                if ((Math.random()*4)<1){
                    if (x<=0){
                        directionX=1;
                        preferedDirection=3;
                    }
                    if (y<=0){
                        directionY=1;
                        preferedDirection=1;
                    }
                    if (x>=50){
                        directionX=-1;
                        preferedDirection=0;
                    }
                    if (y>=30){
                        directionY=-1;
                        preferedDirection=2;
                    }
                    x+=directionX;
                    y+=directionY;
                }else{
                    if (this.preferedDirection<1){
                        x--;    
                    }else if(this.preferedDirection<2){
                        y++;
                    }else if(this.preferedDirection<3){
                        y--;
                    }else{
                        x++;
                    }
                }
            }
    }
    public void eat(Food food){
        if (hunger > 25){
            if (Math.random()*101 > 99){
                food.beEaten(this);
                System.out.println(name+" the dog ate "+food.name+"getting "+food.nutrition+"nutrition points");
            }
        }
    }
    
}
