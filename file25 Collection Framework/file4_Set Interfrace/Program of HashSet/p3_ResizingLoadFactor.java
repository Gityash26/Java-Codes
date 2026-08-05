
/* 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=================== Demonstrate Resizing in HashSet =================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-> So, we alread know that load factor is a floating value that is used to derive a Threshold value.
   And whenever no. of elements in the HashSet reach the Threshold value then the HashSet resize its 
   size with double.

--------------------------------------------
    Threshold = capacity * Loadfactor 
--------------------------------------------




*/
import java.util.HashSet;
import java.util.Scanner;

class BasicHashSetOperation 
{
    private int capacity;
    private float loadFactor;
    private HashSet<String> set;
    private Scanner sc;

    // Constructor
    public BasicHashSetOperation(int capacity, float loadFactor) 
    {
        this.capacity = Math.max(capacity, 1); // Ensure capacity is at least 1
        this.loadFactor = Math.max(Math.min(loadFactor, 1.0f), 0.1f); // Clamp load factor to a valid range
        this.set = new HashSet<>(this.capacity, this.loadFactor);
        this.sc = new Scanner(System.in);
    }

    // Method to add an element
    public void addElement() 
    {
        System.out.print("\nEnter element to insert: ");
        sc.nextLine(); // Consume leftover newline
        String value = sc.nextLine();
        boolean result = set.add(value);
        if (result)
            System.out.println("-> " + value + " inserted into the HashSet.");
        else
            System.out.println("-> " + value + " already exists in the HashSet.");
    }

    // Method to remove an element
    public void removeElement() 
    {
        System.out.print("\nEnter element to remove: ");
        sc.nextLine(); // Consume leftover newline
        String value = sc.nextLine();
        boolean result = set.remove(value);
        if (result)
            System.out.println("-> " + value + " removed from the HashSet.");
        else
            System.out.println("-> " + value + " does not exist in the HashSet.");
    }

    // Method to search for an element
    public void searchElement() 
    {
        System.out.print("\nEnter element to search: ");
        sc.nextLine(); // Consume leftover newline
        String value = sc.nextLine();
        boolean result = set.contains(value);
        
        if (result)
            System.out.println("-> " + value + " found in the HashSet.");
        else
            System.out.println("-> " + value + " not found in the HashSet.");
    }

    // Method to display HashSet details
    public void getDetails() 
    {
        int size = set.size();
        int effectiveCapacity = capacity;
        while (effectiveCapacity * loadFactor < size) 
        {
            effectiveCapacity *= 2;
        }

        System.out.println("\n------------ HashSet Details ------------");
        System.out.println("=> Current Size: " + size);
        System.out.println("=> Effective Capacity: " + effectiveCapacity);
        System.out.println("=> Load Factor: " + loadFactor);
        System.out.println("=> Threshold (Capacity * Load Factor): " + (int) (effectiveCapacity * loadFactor));
    }

    // Method to display all elements
    public void display() 
    {
        System.out.println("\nHashSet elements: " + set);
    }

    // Main operation loop
    public void startOperation() 
    {
        while (true) 
        {
            System.out.print("\n(1) Add Element \n(2) Remove Element \n(3) Search Element \n(4) Get Details \n(5) Display Elements \n(6) Quit\n");
            System.out.print("\n  Enter your choice ---------------> ");
            
            int choice;
            try 
            {
                choice = sc.nextInt();
            } 
            catch (Exception e) 
            {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) 
            {
                case 1 -> addElement();
                
                case 2 -> 
                {
                    if (set.isEmpty()) 
                        System.out.println("-> The HashSet is empty.");
                    else 
                        removeElement();
                }

                case 3 -> 
                {
                    if (set.isEmpty())
                        System.out.println("-> The HashSet is empty.");
                    else 
                        searchElement();
                }

                case 4 -> getDetails();
                
                case 5 -> 
                {
                    if (set.isEmpty())
                        System.out.println("-> The HashSet is empty.");
                    else
                        display();
                }

                case 6 -> 
                {
                    System.out.println("-> Exiting the program. Goodbye!");
                    return;
                }

                default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}

public class p3_ResizingLoadFactor 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter initial capacity (default 16): ");
        int initCapacity = sc.nextInt();

        System.out.print("Enter load factor (default 0.75): ");
        float loadFact = sc.nextFloat();

        BasicHashSetOperation obj = new BasicHashSetOperation(initCapacity, loadFact);
        obj.startOperation();

        sc.close();
    }
}
