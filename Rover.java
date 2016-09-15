
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rover
{
    // fields
    private String name;
    private int x;
    private int y;
    private int dir; // 0=North, 1=NorthEast, 2=East, 3=SouthEast, 4=South, 5=SouthWest, 6=West, 7=NorthWest,
    private boolean isAlive = true;
    private int charge = 75; // percent/100
    private int numPics = 0; //up to 10

    // constructor(s)
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
    }
    
    
    // helper functions
    private void die()
    {
        isAlive = false;
        if (charge < 1 && charge ) {
            System.out.println(name + " ran out of charge!");
        }
        else {
           
        System.out.println(name + " goes 'aaaaaakkkkk!' and dies.");
       }
    }
    
    public int battery(int charge)
    {
        if (charge < 1)
        {
            this.die();
        }
        if (charge < 0)
        {
            charge = 0;
        }
        return charge;
    }
    
    // methods - stuff the Rover can do
    private String getDirectionName(int d)
    {
        if (d == 0)
        {
            return "north";
        }
        else if (d == 1)
        {
            return "northeast";
        }
        else if (d == 2)
        {
            return "east";
        }
        else if (d == 3)
        {
            return "southeast";
        }
        else if (d == 4)
        {
            return "south";
        }
        else if (d == 5)
        {
            return "southwest";
        }
        else if (d == 6)
        {
            return "west";
        }
        else
        {
        
            return "northwest";
        }
        
    }
    
    public void move(int dist)
    {
        if (isAlive) 
        {
            if (dir == 0)
            {
                y += dist;
            }
            else if (dir == 1)
            {
                x += dist;
                y += dist;
            }
            else if (dir == 2)
            {
                x += dist;
            }
             else if (dir == 3)
            {
                x += dist;
                y -= dist;
            }
            else if (dir == 4)
            {
                y -= dist;
            }
             else if (dir == 5)
            {
                x -= dist;
                y -= dist;
            }
            else if (dir == 6)
            {
                x -= dist;
            }
            else
            {
                x -= dist;
                y += dist;
            }
            
            System.out.println(name + " moved in direction " + getDirectionName(dir));
            if (dist < 0) {
                charge += dist;
            }
            else {
                charge -= dist;
            }
        }
        else 
        {
            System.out.println(name + " can't move. It's dead!");
        }
        
    }
    
    public void rotate(int d) 
    {
        if (isAlive)
        {
           if (d < 0)
           {
            dir += d;
        
            if (dir < 0)
            {
                dir = 3;
            }
            else if (dir > 7)
            {
                dir = 0;
            }   
        
        
            System.out.println(name + " turned to the left");       
            charge += d;
             }
              else
              {
            dir += d;
        
            if (dir < 0)
            {
                dir = 3;
            }
            else if (dir > 3)
            {
                dir = 0;
            }   
        
        
            System.out.println(name + " turned to the right");    
            charge -= d;
           }
       }
   
        else
        {
         System.out.println(name + " can't rotate. It's dead!");
        }
    }
    
   
    
    public void teleport() {
    
        if (x == 0 && y == 13) {
            
            x = 0;
            y = 26;
            
        }
        
    }
    
    public void kill(Rover other)
    {
        if (isAlive && charge > 0)
        {
            if (other.isAlive)
            {
               
                    double r = Math.random(); // [0, 1)
             
        
               if (r < 0.8) {
                   System.out.println(this.name + " kills " + other.name + " with his space lasers.");
                   other.die();
                   charge -= 25;
                 }
                  else {
                   System.out.println(this.name + " missed");
                   charge -= 25;
                 }
                 
             
                
                
            }
            else
            {
                System.out.println(other.name + " can't be killed. It's dead!");
                charge -= 25;
            }
        }
        
        else
        {
            System.out.println(this.name + " can't shoot its space laser. It's dead!");
        }
        
   }

   public void selfDestruct()
   {
       if (isAlive && charge > 0) 
       {
            System.out.println(this.name + " exploded in a ball of flames!");
   
                this.die();
        }
        else
        {
            System.out.println(this.name + " can't self destruct. It's dead!");
        }
   }
    
  
    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + 
               ", y=" + y + ", dir=" + getDirectionName(dir) + ", isAlive=" + isAlive + " charge=" + battery(charge) + "]";
               
               
    }
}
