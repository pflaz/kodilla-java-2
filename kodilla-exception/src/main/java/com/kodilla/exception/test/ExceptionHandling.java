package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        String result = "";
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            result = secondChallenge.probablyWillThrowException(2.0, 3.0);
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
        finally {
            System.out.println(result);
        }
    }
}
