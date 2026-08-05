import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;




public class p6_practiceProgram 
{
    public static void main(String[] args) 
    {
        // question 1 
        Consumer<String> consume = name -> System.out.println("Welcome " + name);
        consume.accept("Rahul");        
        consume.accept("Amit");
        consume.accept("Neha");

        System.out.println();


        // question 2 
        Supplier<Integer> sp = () -> 100;
        System.out.println(sp.get());  
        System.out.println(sp.get());  
        System.out.println(sp.get());  

        System.out.println();


        // question 3 -> return boolean 
        Predicate<Integer> pre = (num) -> (num > 0);
        System.out.println(pre.test(10));
        System.out.println(pre.test(-5));
        System.out.println(pre.test(0));

        System.out.println();


        // question 4
        Function<String,Integer> func = (str) -> str.length();
        System.out.println(func.apply("Java"));
        System.out.println(func.apply("Collection"));

        System.out.println();


        // question 5
        Function<Integer, Integer> cube = (num) -> (num*num*num);
        System.out.println(cube.apply(3));
        System.out.println(cube.apply(5));

        System.out.println();

        // question 6
        Function<String, String> putName = n -> n.toUpperCase(); 
        Consumer<String> c = n -> System.out.println(putName.apply(n));
        c.accept("rahul");
        c.accept("amit");

        System.out.println();


        // question 7: 
        List<String> names = Arrays.asList("Rahul","Amit","Neha","Ankit");
        Predicate<String> p = name -> name.startsWith("A");
        for(String name : names)
             System.out.println(name + " : " + p.test(name));

    }    
}
