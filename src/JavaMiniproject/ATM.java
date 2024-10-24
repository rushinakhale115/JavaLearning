package JavaMiniproject;
import javax.security.auth.login.AccountException;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Bank theBank=new Bank("Bank of Pccoe");

        //add a user which also creates a savings account
        User aUser= theBank.addUser("John","Doe","1234");

        //add a checking account for our user
        Account newAccount=new Account("Checking",aUser,theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true){

            //stay in the login prompt until successful login
            curUser=ATM.mainMenuPrompt(theBank,sc);

            //stay in the main menu until user quits
            ATM.printUserMenu(curUser,sc);
        }

    }
    public static User mainMenuPrompt(Bank theBank,Scanner sc){

        String userID;
        String pin;
        User authUser;

        //prompt the user for user ID/pin Combo until a correct one is reached
        do{
            System.out.println("\n\nWelcome to %s\n\n",theBank.getName());
            System.out.println("Enter User Id:");
            userID =sc.nextLine();
            System.out.println("Enter Pin:");
            pin=sc.nextLine();

            //try to get the user object corresponding to the iD and pin combo
            authUser=theBank.userLogin(userID,pin);
            if(authUser==null){
                System.out.println("Incorrect user id / pin combination "+"Please try again ");
            }

        }
        while (authUser==null);

        return authUser;
    }
    public static void printUserMenu(User theUser,Scanner sc){
        //print summary of user's account
        theUser.printAccountsSummary();

        //init
        int choice;

        //user menu
        do{
            System.out.println("Welcome %s, What would you like to do?",
                    theUser.getFirstName());
        }
    }
}

