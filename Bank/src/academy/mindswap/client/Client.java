package academy.mindswap.client;

import academy.mindswap.bank.Bank;

import java.util.ArrayList;
import java.util.List;

import static academy.mindswap.util.Messages.*;


public class Client {

    private Bank bank;
    private String clientId;
    private final List<String> cards = new ArrayList<>();
    private boolean hasId;
    private static int counter;


    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void askForId(){
        if(!checkBankPresence()){
            System.out.println(ENTER_BANK);
            return;
        }
        if(!hasId){
            clientId = "cl" + (++counter);
            System.out.println("Id: " + clientId);
            hasId = true;
            return;
        }
        System.out.println(HAVE_ID);
    }

    public void createAccount(String typeOfAccount){
        if(!checkBasicConditions(typeOfAccount)){
            return;
        }
        bank.createAccount(typeOfAccount,clientId);
    }

    public void askForCard(String typeOfAccount){
        if(!checkBasicConditions(typeOfAccount)){
            return;
        }
        if(!bank.checkIfHasAccount(clientId,typeOfAccount)){
            System.out.println("You need to have an account of " + typeOfAccount + " type to ask this.");
            return;
        }
        System.out.printf("Here is your " + typeOfAccount + " card!");
        cards.add(typeOfAccount);
    }

    private boolean checkBankPresence(){return bank != null;}

    public void deposit(String typeOfAccount, int amount) {
        if(!checkFullConditions(typeOfAccount)){
            return;
        }
        bank.depositOnAccount(typeOfAccount,amount,clientId);
    }

    public void checkBalance(String typeOfAccount) {
        if(!checkFullConditions(typeOfAccount)){
            return;
        }
        int balance = bank.askForBalance(typeOfAccount, clientId);
        System.out.println(balance == -1 ? NEED_ACCOUNT
                                         : "Your balance on your " + typeOfAccount + " account is " + balance);
    }

    public void pay(String typeOfAccount, int amount) {
        if(!checkFullConditions(typeOfAccount)){
            return;
        }
        bank.paymentWithAccount(typeOfAccount,amount, clientId);
    }

    public void withdraw(String typeOfAccount, int amount) {
        if(!checkFullConditions(typeOfAccount)){
            return;
        }
        bank.withdrawMoney(typeOfAccount,amount,clientId);
    }

    private boolean checkFullConditions(String typeOfAccount){
        if(!checkBankPresence()){
            System.out.println(ENTER_BANK);
            return false;
        }
        if(!hasId){
            System.out.println(NEED_ID);
            return false;
        }
        if(cards.stream().noneMatch(e -> e.equals(typeOfAccount))){
            System.out.println(NEED_CARD);
            return false;
        }
        return true;
    }

    private boolean checkBasicConditions(String typeOfAccount){
        if(!checkBankPresence()){
            System.out.println(ENTER_BANK);
            return false;
        }
        if(!hasId){
            System.out.println(NEED_ID);
            return false;
        }
        return true;
    }
}
