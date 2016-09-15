
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoverRunner
{
    public static void main(String[] arrrggggggs)
    {
        Rover r1 = new Rover("Io");
        Rover r2 = new Rover("Europa");
        Rover r3 = new Rover ("Ganymede");
        Rover r4 = new Rover ("Callisto");
        
        
        System.out.println(r1);
        
        r1.move(2);
        System.out.println(r1);

        r1.rotate(100);
        System.out.println(r1);
        
        r2.rotate(-12);
        System.out.println(r2);
        
        r2.move(7);
        System.out.println(r2);
        
        r1.move(7);
        System.out.println(r1);
        
        r1.kill(r2);
        System.out.println(r2);
        
        r2.move(16);
        System.out.println(r2);
        
        r1.kill(r2);
        System.out.println(r2);
        
        r1.kill(r2);
        System.out.println(r2);
        
        r1.move(4);
        System.out.println(r1);
        
        r1.selfDestruct();
        System.out.println(r1);
        
            }
}
