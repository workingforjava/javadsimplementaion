package com.jaykey.ds.arrays;
import java.util.Arrays;
import java.util.stream.Stream;


public class TwoDimensionalArray {
    public static void main(String[] args) {
        TwoDimensionalArray tda = new TwoDimensionalArray();

        String[][] A = {{"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}};

        tda.traverseArray(A);
    }

    private void traverseArray(String[][] A) {

        Stream.of(A).flatMap(Stream::of).forEach(System.out::print);
        Arrays.stream(A).
                map( a -> String.join(" ", a))
                .forEach(System.out::println);
    }
}
