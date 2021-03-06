import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String bankName;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    public Bank(String name){
        this.bankName = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getBankName(){
        return this.bankName;
    }


    public String getNewUUID(){

        String uuid;
        Random r = new Random();
        boolean unique = false;

        do {
            uuid = "";
            for(int i = 0; i < 6; i++){
                uuid += ((Integer)r.nextInt(10)).toString();
            }

            for ( User u : this.users){
                if(uuid.compareTo(u.getUUID()) == 0){
                    unique = true;
                    break;
                }
            }

        }
        while(unique);

        return uuid;
    }

    public String getNewAccountId(){

        String uuid;
        Random r = new Random();

        boolean unique = false;

        do {
            uuid = "";
            for(int i = 0; i < 10; i++){
                uuid += ((Integer)r.nextInt(10)).toString();
            }

            for ( Account a : this.accounts){
                if(uuid.compareTo(a.getUUID()) == 0){
                    unique = true;
                    break;
                }
            }
        }
        while(unique);

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

    public User userLogin(String userId, String pin){

        for(User u: this.users){
            if(u.getUUID().compareTo(userId) == 0){
                if(u.validatePin(pin))
                    return u;
            }
        }
        return null;
    }
}

