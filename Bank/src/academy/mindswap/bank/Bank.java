package academy.mindswap.bank;

import academy.mindswap.account.Account;
import academy.mindswap.account.Credit;
import academy.mindswap.account.Debit;

import java.util.*;

import static academy.mindswap.util.Messages.*;

public class Bank {

    private final Map<String, List<Account>> accounts;


    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String typeOfAccount,String clientId ) {

        if(!accounts.containsKey(clientId) && typeOfAccount.equals("credit")){
            accounts.putIfAbsent(clientId,new ArrayList<>());
            accounts.get(clientId).add(new Credit());
            System.out.println(FIRST_CREDIT);
            return;
        }

        if(!accounts.containsKey(clientId) && typeOfAccount.equals("debit")){
            accounts.putIfAbsent(clientId,new ArrayList<>());
            accounts.get(clientId).add(new Debit());
            System.out.println(FIRST_DEBIT);
            return;
        }

        if(accounts.get(clientId).size() == 2){
            System.out.println(LIMIT_ACCOUNTS);
            return;
        }

        if(accounts.containsKey(clientId) && typeOfAccount.equals("credit")){
            if(accounts.get(clientId).stream().anyMatch(e -> e instanceof Credit)){
                System.out.println(ALREADY_CREDIT);
                return;
            }
            accounts.get(clientId).add(new Credit());
            System.out.println(OPENED_CREDIT);
            return;
        }

        if(accounts.containsKey(clientId) && typeOfAccount.equals("debit")){
            if(accounts.get(clientId).stream().anyMatch(e -> e instanceof Debit)){
                System.out.println(ALREADY_DEBIT);
                return;
            }
            accounts.get(clientId).add(new Debit());
            System.out.println(OPENED_DEBIT);
        }

    }

    public boolean checkIfHasAccount(String clientId, String typeOfAccount) {

        if(typeOfAccount.equals("credit")){
            return accounts.get(clientId).stream().filter(e -> e instanceof Credit).count() == 1;
        }
        return accounts.get(clientId).stream().filter(e -> e instanceof Debit).count() == 1;
    }

    public void depositOnAccount(String typeOfAccount, int amount, String clientId) {

        if(checkIfHasAccount(clientId,typeOfAccount)){

            switch (typeOfAccount){
                case "credit":
                    List<Account> x = accounts.get(clientId).stream().filter(e-> e instanceof Credit).toList();
                    x.get(0).deposit(amount);
                    System.out.printf("You just deposited %d in your %s account.\n", amount, typeOfAccount);
                    return;
                case "debit":
                    List<Account> y = accounts.get(clientId).stream().filter(e-> e instanceof Debit).toList();
                    y.get(0).deposit(amount);
                    System.out.printf("You just deposited %d in your %s account.\n", amount, typeOfAccount);
                    return;
            }
        }
        System.out.println(NO_DEPOSITS);
    }

    public int askForBalance(String typeOfAccount, String clientId) {

        if(checkIfHasAccount(clientId,typeOfAccount)){

            switch (typeOfAccount){
                case "credit":
                    List<Account> x = accounts.get(clientId).stream().filter(e-> e instanceof Credit).toList();
                    return x.get(0).getBalance();
                case "debit":
                    List<Account> y = accounts.get(clientId).stream().filter(e-> e instanceof Debit).toList();
                    return y.get(0).getBalance();
            }
        }
        return -1;
    }

    public void paymentWithAccount(String typeOfAccount, int amount, String clientId) {

        if(checkIfHasAccount(clientId,typeOfAccount)){

            switch (typeOfAccount){
                case "credit":
                    List<Account> x = accounts.get(clientId).stream().filter(e-> e instanceof Credit).toList();
                   x.get(0).pay(amount);
                   return;
                case "debit":
                    List<Account> y = accounts.get(clientId).stream().filter(e-> e instanceof Debit).toList();
                    y.get(0).pay(amount);
                    return;
            }
        }
        System.out.println(NO_PAYMENTS);
    }


    public void withdrawMoney(String typeOfAccount, int amount, String clientId) {

        if(checkIfHasAccount(clientId,typeOfAccount)){

            switch (typeOfAccount){
                case "credit":
                    List<Account> x = accounts.get(clientId).stream().filter(e-> e instanceof Credit).toList();
                    x.get(0).withdraw(amount);
                    return;
                case "debit":
                    List<Account> y = accounts.get(clientId).stream().filter(e-> e instanceof Debit).toList();
                    y.get(0).withdraw(amount);
                    return;
            }
        }
        System.out.println(NO_WITHDRAWS);
    }
}
