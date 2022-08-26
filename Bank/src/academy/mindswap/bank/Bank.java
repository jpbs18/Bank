package academy.mindswap.bank;

import academy.mindswap.account.Account;
import academy.mindswap.account.Credit;
import academy.mindswap.account.Debit;

import java.util.*;

public class Bank {

    private Map<String, List<Account>> accounts;


    public Bank(){
        accounts = new HashMap<>();
    }

    public void createAccount(String typeOfAccount,String clientId ) {

        if(!accounts.containsKey(clientId) && typeOfAccount.equals("credit")){
            accounts.putIfAbsent(clientId,new ArrayList<>());
            Account account = new Credit();
            accounts.get(clientId).add(account);
            System.out.println("This is your first account with us, a credit account :)");
            return;
        }

        if(!accounts.containsKey(clientId) && typeOfAccount.equals("debit")){
            accounts.putIfAbsent(clientId,new ArrayList<>());
            accounts.get(clientId).add(new Debit());
            System.out.println("This is your first account with us, a debit account :)");
            return;
        }

        if(accounts.get(clientId).size() == 2){
            System.out.println("You can't have more accounts with us, sorry!");
            return;
        }

        if(accounts.containsKey(clientId) && typeOfAccount.equals("credit")){
            if(accounts.get(clientId).stream().anyMatch(e -> e instanceof Credit)){
                System.out.println("Sorry, you already have a credit account with us.");
                return;
            }
            accounts.get(clientId).add(new Credit());
            System.out.println("You have just opened a credit account.");
            return;
        }

        if(accounts.containsKey(clientId) && typeOfAccount.equals("debit")){
            if(accounts.get(clientId).stream().anyMatch(e -> e instanceof Debit)){
                System.out.println("Sorry, you already have a debit account with us.");
                return;
            }
            accounts.get(clientId).add(new Debit());
            System.out.println("You have just opened a debit account.");
        }

    }

    public boolean checkIfHasAccount(String clientId, String typeOfAccount) {
        if(typeOfAccount.equals("credit")){
            return accounts.get(clientId).stream().filter(e -> e instanceof Credit).count() == 1;
        }
        return accounts.get(clientId).stream().filter(e -> e instanceof Debit).count() == 1;
    }
}
