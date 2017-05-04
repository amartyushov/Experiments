package io.mart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr Martiushov
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.stream().forEach((string) -> System.out.println(string));
    }
}
