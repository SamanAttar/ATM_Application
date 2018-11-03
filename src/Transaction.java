import java.util.Date;

public class Transaction {

    private double amount;

    private Date timestamp;

    private String memo;

    private Account account;

    public Transaction(double amount, Account account){
        this.amount = amount;
        this.account = account;
        this.timestamp =  new Date();
        this.memo = "";
    }

    public Transaction(double amount, Account account, String memo){

        this(amount, account);
        this.memo = memo;
    }

}
