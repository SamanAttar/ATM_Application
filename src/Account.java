import java.util.ArrayList;

public class Account {

    private String name;

    private String uuid;

    private User owner;

    private ArrayList<Transaction> transactions;


    public Account(String name, User user, Bank bank) {
        this.name = name;
        this.owner = user;
        this.uuid = bank.getNewAccountId();

        this.transactions = new ArrayList<Transaction>();
    }

    public String getUUID(){
        return this.uuid;
    }


    public String getSummaryLine() {

        double balance = this.getBalance();

        //if balance is negative
        if( balance >= 0 ){
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        }
        else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }
    }


    public double getBalance(){
        double balance = 0;

        for(Transaction t : this.transactions){
            balance += t.getAmount();
        }

        return balance;

    }
}
