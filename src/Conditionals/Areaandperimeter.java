package Conditionals;
import java.util.Scanner;
public class Areaandperimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length of a rectangle:");
        float x= sc.nextFloat();
        System.out.println("Enter Breadth of a rectangle :");
        float y= sc.nextFloat();
        float area = x*y;
        float perimeter = 2*(x+y);
        if(area>perimeter){
            System.out.println("Area is Greater than perimeter ");
        }else{
            System.out.println("Perimeter is Greater");
        }
    }
}
