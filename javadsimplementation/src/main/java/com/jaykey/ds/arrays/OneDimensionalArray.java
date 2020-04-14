package com.jaykey.ds.arrays;

import java.util.Arrays;

public class OneDimensionalArray {
    public static void main(String[] args) {
        OneDimensionalArray oda = new OneDimensionalArray();
        int[] A= {1,5,3,4,2};
        oda.arrayTraversal(A);
    }

    private  void arrayTraversal(int[] A) {
        Arrays.stream(A).forEachOrdered(System.out::print);
    }

}
