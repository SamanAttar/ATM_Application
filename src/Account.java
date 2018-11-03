import java.util.ArrayList;

public class Account {

    private String name;

    private String uuid;

    private User owner;

    private ArrayList<Transaction> transactions;


    public Account(String name, User user, Bank bank){
        this.name = name;
        this.owner = user;
        this.uuid = bank.getNewAccountId();

        this.transactions = new ArrayList<Transaction>();

        user.addAccount(this);
        bank.addAccount(this);
    }

    public String getUUID(){
        return this.uuid;
    }
}
