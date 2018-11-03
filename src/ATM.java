import java.util.Scanner;


public class ATM {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank("Bank of Saman");

        User user = bank.createUser("Saman", "Attar", "3111");

        Account account = new Account("Checking", user, bank);

        user.addAccount(account);
        bank.addAccount(account);

    }
}
