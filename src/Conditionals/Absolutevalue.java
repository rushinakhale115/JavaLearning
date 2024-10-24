package Conditionals;


import java.util.Scanner;
public class Absolutevalue
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a integer:");
        int n=sc.nextInt();
        if(n<0){
            n=n*-1;
            System.out.println("Absolute Value of the given integer is :"+n);
        }
        else{
            System.out.println("Absolute Value of the given integer is :"+n);
        }


    }

}
