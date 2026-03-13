import java.util.*;
import java.awt.*;

public class Dog extends Animal{
    private int lives;
    private int preferedDirection;
    public Dog(String name, int x, int y, int hunger, boolean isSick){
        super("animal", 0, 0, 0, false);
        this.lives = 1;
        this.x=x;
        this.y=y;
        this.name=name;
        this.hunger=1000;
        this.preferedDirection=(int)(Math.random()*4);
    }

    public void beEaten(Animal animal){
        
    }
    public int getPreferedDirection() {
        return preferedDirection;
    }


    public void setPreferedDirection(int preferedDirection) {
        this.preferedDirection = preferedDirection;
    }

    // TODO: override the tick method
    public void tick(Zoo zoo){
        if (age == 0){
            System.out.println(name+" was born");
        }
        age++;
        int chance = (int)Math.random()*101;
        if(chance >=10 && isSick== true){
            lives--;
        }
        if (lives <=0){
            alive = false;
            System.out.println("Dog "+name+" died of death");
        }
        if (hunger<=0){
            lives--;
            if (lives <= 0){
                System.out.println("Dog "+name+" died of hunger. age:"+age);
                alive = false;
            }
        }
        hunger--;
        if (age%2==0){
        this.move(zoo);
        }
        

    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐕", Zoo.wrap(x,Zoo.ZOO_COLS)*Zoo.SCALE, Zoo.wrap(y,Zoo.ZOO_ROWS)*Zoo.SCALE+25);

    }

    // TODO: override the eat method
    public void eat(Food food){
        if (hunger > 25){
            if (Math.random()*101 > 99){
                food.beEaten(this);
                System.out.println(name+" the dog ate "+food.name+"getting "+food.nutrition+"nutrition points");
            }
        }
    }
    // TODO: override the move method
    // public boolean inBound(ArrayList<ArrayList<Entity>> grid, int x, int y){

    // }
    
    public void move(Zoo zoo){
        int randomDirect = (int) (Math.random()*6);
        boolean movedAway=false;
        ArrayList<Entity> nearEntities = this.getNeighbors(zoo);
            for (Entity e: nearEntities){
                if (e instanceof Food){
                    if (hunger<=25&&Math.random()*101>1){
                        this.x=e.getX();
                        this.y=e.getY();              
                        this.eat((Food)e);
                    }
                }
                if (e instanceof Animal){
                    this.x+=(this.x-e.getX());
                    this.y+=(this.y-e.getY());
                    movedAway=true;
                    break;
                }
                if(e instanceof Dog){
                    int temp=this.preferedDirection;
                    this.preferedDirection=((Dog)e).getPreferedDirection();
                    ((Dog)e).setPreferedDirection(temp);            
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

}