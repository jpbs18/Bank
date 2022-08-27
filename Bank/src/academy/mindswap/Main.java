package academy.mindswap;

import academy.mindswap.bank.Bank;
import academy.mindswap.client.Client;

public class Main {

    public static void main(String[] args){

        Bank bank1 = new Bank();
        Client joao = new Client();

        joao.setBank(bank1);
        joao.askForId();
        joao.askForCard("debit");
        joao.createAccount("debit");
        joao.createAccount("debit");
        joao.askForCard("debit");
        joao.askForCard("credit");
        joao.createAccount("credit");
        joao.askForCard("credit");




    }
}
