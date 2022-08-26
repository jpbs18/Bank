package academy.mindswap.client;

import academy.mindswap.bank.Bank;


public class Client {

    private Bank bank;
    private String clientId;
    private boolean hasId;
    private static int counter;



    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void askForId(){
        if(!checkBankPresence()){
            System.out.println("Please enter a bank first.");
            return;
        }

        if(!hasId){
            clientId = "cl" + (++counter);
            System.out.println("Id: " + clientId);
            hasId = true;
            return;
        }
        System.out.println("You already have an Id.");
    }

    public void createAccount(String typeOfAccount){
        if(!checkBankPresence()){
            System.out.println("Should have a bank first.");
            return;
        }

        if(!hasId){
            System.out.println("You need a bank id for this operation, try to get one first.");
            return;
        }

        bank.createAccount(typeOfAccount,clientId);
    }

    public void askForCard(String typeOfAccount){
        if(!checkBankPresence()){
            System.out.println("Enter a bank first.");
            return;
        }

        if(!hasId){
            System.out.println("You need a bank id for this operation, try to get one first.");
            return;
        }

        if(typeOfAccount.equals("credit")){

            if(!bank.checkIfHasAccount(clientId,typeOfAccount)){
                System.out.println("You need to have an account of " + typeOfAccount + " type to ask this.");
                return;
            }

            System.out.println("Here is your " + typeOfAccount + " card!");
            return;
        }

        if(typeOfAccount.equals("debit")){

            if(!bank.checkIfHasAccount(clientId,typeOfAccount)){
                System.out.println("You need to have an account of " + typeOfAccount + " type to ask this.");
                return;
            }

            System.out.println("Here is your " + typeOfAccount + " card!");
        }

    }

    private boolean checkBankPresence(){
       return bank != null;
    }


}
