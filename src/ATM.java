import java.util.Scanner;


public class ATM {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank("Bank of Saman");

        User user = bank.createUser("Saman", "Attar", "3111");

        Account account = new Account("Checking", user, bank);

        user.addAccount(account);
        bank.addAccount(account);


        User currentUser;
        while(true){

            currentUser = ATM.mainMenuPrompt(bank, sc);
            ATM.printUserMenu(currentUser, sc);
        }

    }


    public static User mainMenuPrompt(Bank bank, Scanner sc){

        String userId, pin;
        User authUser;

        do{
            System.out.println("\n Welcome to " + bank.getBankName());
            System.out.print("Enter your ID: ");
            userId = sc.nextLine();
            System.out.print("Enter your pin: ");
            pin = sc.nextLine();

            authUser = bank.userLogin(userId, pin);

            if(authUser == null)
                System.out.println("Incorrect username/pin combo, please try again ");


        } while(authUser == null);

        return authUser;
    }

    public static void printUserMenu(User user, Scanner sc){

        user.printAccountsSummary();

        int choice;

        do {
            System.out.println("\nWelcome, " + user.getFirstName() + ". Please select an option");
            System.out.println(" 1) Show Transaction History");
            System.out.println(" 2) Withdraw");
            System.out.println(" 3) Deposit");
            System.out.println(" 4) Transfer");
            System.out.println(" 5) Quit\n");
            choice = sc.nextInt();

            if(choice < 1 || choice > 5){
                System.out.println("Invalid Choice, select 1 - 5");
            }

            switch(choice) {

                case 1:
                    ATM.showTransactionHistory(user, sc);
                    break;
               /* case 2:
                    ATM.withdrawFunds(user, sc);
                    break;
                case 3:
                    ATM.depositFunds(user, sc);
                    break;
                case 4:
                    ATM.transferFunds(user, sc);
                    break;
                */
            }

            if ( choice != 5){
                ATM.printUserMenu(user, sc);
            }

        }
        while(choice != 5);


    }



    public static void showTransactionHistory(User user, Scanner sc){

        int account;

        do {

            System.out.println("Enter the number of the account: " + user.getNumberOfAccounts());

            account = sc.nextInt()-1;
            if(account < 0 || account >= user.getNumberOfAccounts()){

                System.out.println("Invalid Account. Try again.");

            }


        }
        while(account < 0 || account >= user.getNumberOfAccounts());

        user.printAccountTransactionHistory(account);

    }
}
