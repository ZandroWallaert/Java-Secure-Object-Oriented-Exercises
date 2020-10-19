package be.howest.ti.design.patterns.builder.address;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AddressBuilder2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3);

        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}