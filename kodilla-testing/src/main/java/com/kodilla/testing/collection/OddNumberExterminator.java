package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumberExterminator {

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int theNumber :numbers) {
            if (theNumber % 2 == 0) {
                result.add(theNumber);
            }
        }
        return result;
    }


}
