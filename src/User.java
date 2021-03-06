import com.sun.org.apache.xpath.internal.operations.Bool;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {

    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[];

    ArrayList<Account> accounts;// = new ArrayList<Account>();

    public User(String firstName, String lastName, String pin, Bank Bank) {
        this.firstName = firstName;
        this.lastName = lastName;

        try {
            MessageDigest md  = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.print("Error. Caught the NoSuchAlgorithmException. ");
            e.printStackTrace();
            System.exit(1);
        }

        this.uuid  = Bank.getNewUUID();

        this.accounts = new ArrayList<Account>();

        System.out.println("New User created.");
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("User ID: " + this.uuid);
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }

    public String getUUID(){
        return this.uuid;
    }

    public String getFirstName(){
        return this.firstName;
    }


    // Check if pin matches
    public boolean validatePin(String pin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }

    public void printAccountsSummary() {
        System.out.println("\nAccount Summary for " +  this.firstName + " " + this.lastName);
        for(int i = 0; i < this.accounts.size(); i++)
            System.out.println(i+1 + " : " + this.accounts.get(i).getSummaryLine());
    }

    public int getNumberOfAccounts(){
        return this.accounts.size();
    }

    public void printAccountTransactionHistory(int accountIndex){

        this.accounts.get(accountIndex).printTransactionHistory();
    }



}
