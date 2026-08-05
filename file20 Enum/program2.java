
enum Week_Days {
    Monday, Tuesday, Wednesday, Thrusday, Friday, Saturday, Sunday;
}

public class program2 {
    public static void main(String[] args) 
    {
        Week_Days[] week = Week_Days.values();

        for (Week_Days day : week) 
        {
            switch (day) 
            {
                case Monday:
                    System.out.println("\nDay is " + day);
                    break;

                case Tuesday:
                    System.out.println("\nDay is " + day);
                    break;

                case Wednesday:
                    System.out.println("\nDay is " + day);
                    break;

                case Thrusday:
                    System.out.println("\nDay is " + day);
                    break;

                case Friday:
                    System.out.println("\nDay is " + day);
                    break;

                case Saturday:
                    System.out.println("\nDay is " + day);
                    break;

                case Sunday:
                    System.out.println("\nDay is " + day);
                    break;

                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        }
    }

}
