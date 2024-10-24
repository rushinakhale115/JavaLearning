package oopspractice;

import java.util.Scanner;

public class CharCount {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the String: ");
            String string=sc.next();
            int count = 0;

            //Counts each character except space
            for(int i = 0; i < string.length(); i++) {
                if(string.charAt(i) != ' ')
                    count++;
            }

            //Displays the total number of characters present in the given string
            System.out.println("Total number of characters in the string: " + count);
        }
}
