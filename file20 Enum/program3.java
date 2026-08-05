/*
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-------------- Object, Constructor, Getter, Setter ----------
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

*/

enum Laptop 
{
    Macbook(5300), Surface(4500), LenovoYoga, Thinkpad(3400);
    
    int price;

    // default constructor 
    private Laptop()
    {
        price=500; // default price
    }

    // parameterized constructor 
    Laptop(int price)
    {
        this.price=price; 
    }

    // Setter for price
    public void SetPrice(int price)
    {
        this.price=price;
    }

    // Getter for price 
    public int GetPrice()
    {
        return price;
    }
}

public class program3
{
    public static void main(String[] args) {

        for(Laptop lap : Laptop.values())
        {
            System.out.println("\nLaptop name : " + lap + " \n=> Price : " + lap.price);
        }
        
    }
}