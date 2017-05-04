package io.mart.javaEight;

import java.util.*;
import java.util.stream.Collectors;

/**
 * They allow us to treat functionality as a method argument (passing functions around), or treat a code as data
 * @author Alexander Martyushov
 */
public class Lambdas {

    public static void main(String[] args) {
        // 1
        //Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );

        // 2
        // explicitly specify type of parameter
        //Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );

        // 3
        // In case lambda’s body is more complex, it may be wrapped into square brackets, as the usual function definition in Java.
/*        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
            System.out.print( e );
        } );*/

        // 4
/*        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );*/

        // 5
        //Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
        // equal to
/*
        Arrays.asList( "a", "a", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            return result;
        } );
*/


        // examples
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 15, 20, 40, 54, 24));
        Set<Integer> set = new HashSet<>(list);

        //list.stream().filter(p -> p > 15).forEach(System.out::println);
        //List<Integer> list1 = list.stream().filter(p -> p > 15).collect(Collectors.toList());
        //Set<Integer> set1 = set.stream().filter(p -> p > 20).collect(Collectors.toSet());
        //set1.forEach(System.out::println);

        PersonFactory<Person> factory = Person::new;
        Person p = factory.create("Alex", "Mart");
        System.out.println(p.toString());

        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        System.out.println(stringConverter.convert(2));
        System.out.println(num);
    }

}
