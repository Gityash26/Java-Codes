
import java.util.Scanner;


class Account
{
    int balance;

    Account(int bal)
    {
        balance = bal;
    }

    boolean IsSufficient(int amount)
    {
        if(balance >= amount)
            return true;
        else 
            return false;
    }

    public void Withdraw(int amount)
    {
        if(IsSufficient(amount))
        {
            balance -= amount;
            System.out.println("Withdraw Successful of amount " + amount);
            System.out.println("Current balance is : " + balance);
        }
    }
}

class Customer implements Runnable
{
    Account acc;
    String name;

    Customer(String n, Account a)
    {
        acc = a;
        name = n;
    }

    public void run()
    {
        
        synchronized(acc)
        {
            Scanner sc = new Scanner(System.in);

            System.out.print("\n" + name + " Enter amount to withdraw : ");
            int amount = sc.nextInt();

            
            if(acc.IsSufficient(amount))
            {
                acc.Withdraw(amount);
            }
            
            else 
            {
                System.out.println("! Sorry Insufficient Balance " + name);
            }
            
        }
        
    }
}


public class p3_AccountMutual 
{
    public static void main(String[] args) 
    {
        Account acc = new Account(5000);    

        Customer c1 = new Customer("Sipika", acc);
        Customer c2 = new Customer("Anjali", acc);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();

    }    
}
