package main;

import java.util.Scanner;

public class BongoTest {
    public static void main(String[] args) {
        System.out.println("------------Anagram Checker------------");
        Scanner sc = new Scanner(System.in);

        System.out.println("Input 1: ");
        String s1 = sc.nextLine();
        System.out.println("Input 2: ");
        String s2 = sc.nextLine();

        if (AnagramChecker.areAnagram(s1, s2)) System.out.println("They are anagrams!");
        else System.out.println("They are not anagrams.");
    }
}
