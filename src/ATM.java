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
            System.out.println("Enter your ID: ");
            userId = sc.nextLine();
            System.out.println("Enter your pin: ");
            pin = sc.nextLine();

            authUser = bank.userLogin(userId, pin);

            if(authUser == null)
                System.out.println("Inncorrect username/pin combo, please try again ");


        } while(authUser == null);

        return authUser;
    }

    public static void printUserMenu(User user, Scanner sc){

        user.printAccountsSummary();

        int choice;


            System.out.printf("Welcome, " + user.getFirstName() + ". Please select an option");
            System.out.println(" 1) Show Transaction History");
            System.out.println(" 2) Withdrawl");
            System.out.println(" 3) Deposit");
            System.out.println(" 4) Transfer");
            System.out.println(" 5) Quit\n");
            choice = sc.nextInt();

            if(choice < 1 || choice > 5){
                System.out.println("Invalid Choice, select 1 - 5");
            }


    }
}
