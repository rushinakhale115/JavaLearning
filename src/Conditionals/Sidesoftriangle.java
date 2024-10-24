package Conditionals;

import java.util.Scanner;

public class Sidesoftriangle {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter first side:");
        int a= sc.nextInt();
        System.out.println("Enter second side:");
        int b= sc.nextInt();
        System.out.println("Enter Third side:");
        int c= sc.nextInt();
        if(a+b>c && a+c>b && b+c>a){
            System.out.println("Valid Triangle");
        }else{
            System.out.println("Invalid Triangle");
        }
    }
}
