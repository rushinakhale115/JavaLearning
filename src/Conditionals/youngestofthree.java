package Conditionals;
import java.util.Scanner;
public class youngestofthree {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter age of first person:");
        int a= sc.nextInt();
        System.out.println("Enter age of second person:");
        int b= sc.nextInt();
        System.out.println("Enter age of third person:");
        int c= sc.nextInt();
        if (a < b && a < c) {
            System.out.println("First Person is Youngest");}

        else if(b<a && b<c) {
                System.out.println("Second person is youngest");}
        else{
                    System.out.println("third person is youngest");
                }
            }
        }


