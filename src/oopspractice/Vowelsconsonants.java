package oopspractice;

import java.util.Scanner;
import java.lang.*;

public class Vowelsconsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String string = sc.next();
        int vcount = 0;
        int ccount = 0;

        //Counts each character except space
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u') {
                vcount++;
            } else if(string.charAt(i)>='a' && string.charAt(i)<='z'); {

                ccount++;
            }
        }


        System.out.println("Total number of Vowels in the string: " + vcount);
        System.out.println("Total number of Consonants in the string: " + ccount);
    }
}
