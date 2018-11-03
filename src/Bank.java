import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;


    public String getNewUUID(){

        String uuid;
        Random r = new Random();
        boolean unique = false;

        do {
            uuid = "";
            for(int i = 0; i < 6; i++){
                uuid += ((Integer)r.nextInt(0)).toString();
            }

            for ( User u : this.users){
                if(uuid.compareTo(u.getUUID()) == 0){
                    unique = true;
                    break;
                }
            }

        }
        while(!unique);

        return uuid;
    }

    public String getNewAccountId(){

        String uuid;
        Random r = new Random();

        boolean unique = false;

        do {
            uuid = "";
            for(int i = 0; i < 10; i++){
                uuid += ((Integer)r.nextInt(0)).toString();
            }

            for ( Account a : this.accounts){
                if(uuid.compareTo(a.getUUID()) == 0){
                    unique = true;
                    break;
                }
            }
        }
        while(!unique);

        return uuid;
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public User createUser(String firstName, String lastName, String pin){
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        Account newAccount = new Account("Checking", newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

}

