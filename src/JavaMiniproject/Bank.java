package JavaMiniproject;
import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private ArrayList<User>users;
    private ArrayList<Account>accounts;

    public Bank(String name){
        this.name=name;
        this.users=new ArrayList<User>();
        this.accounts=new ArrayList<Account>();

    }

    //generate a new universally unique id for a user.
    public String getNewUserUUID(){
        String uuid;
        Random rng=new Random();
        int len=6;
        boolean nonUnique=false;

        //continue looping until we get a unique ID
        do{
            //generate the number
            uuid="";
            for(int c=0;c<len;c++){
                uuid+=((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure it's unique
            nonUnique=false;
            for(User u:this.users){
                if(uuid.compareTo(u.getUUID())==0){
                    nonUnique=true;
                    break;
                }
            }
        }while(nonUnique);

        return uuid;
    }
    public String getNewAccountUUID(){
        String uuid;
        Random rng=new Random();
        int len=10;
        boolean nonUnique=false;

        //continue looping until we get a unique ID
        do{
            //generate the number
            uuid="";
            for(int c=0;c<len;c++){
                uuid+=((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure it's unique
            nonUnique=false;
            for(Account a:this.accounts){
                if(uuid.compareTo(a.getUUID())==0){
                    nonUnique=true;
                    break;
                }
            }
        }while(nonUnique);

        return uuid;

    }

    //Add an account
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }
    public User addUser(String firstName,String Lastname,String pin){
        //create  a new user object and add it to our list
        User newUser=new User(firstName,Lastname,pin,this);
        this.users.add(newUser);

        //create a savings account for the user and add to user and bank
        //accounts lists
        Account newAccount =new Account("Savings",newUser,this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }
    public User userLogin(String userID,String pin){

        //search through list of users
        for(User u:this.users){

            //check user id is correct
            if(u.getUUID().compareto(userID)==0 && u.validatePin(pin)){
                return u;
            }
        }
        //if we haven't find the user or have incorrect pin
        return null;
    }
    public String getName(){
        return this.name;
    }
}
