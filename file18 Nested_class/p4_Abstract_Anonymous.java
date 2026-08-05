abstract class Car
{
    public abstract void Drive();

    public void playMusic()
    {
        System.out.println("\nPlaying Music...");
    }
}


public class p4_Abstract_Anonymous {
    public static void main(String[] args) {
        Car c = new Car()
        {
            public void Drive()
            {
                System.out.println("\nDrivig Car...");
            }
        };

        c.Drive();
        c.playMusic();
    }
}
 