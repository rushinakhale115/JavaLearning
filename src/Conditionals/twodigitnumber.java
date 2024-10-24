package Conditionals;
import java.util.Scanner;
public class twodigitnumber {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter a Number:");
        int n= sc.nextInt();
        if(n>9 && n<100){
            System.out.println("Number is Two Digit number");
        }else{
            System.out.println("Number is not a two digit number");
        }
    }
}
