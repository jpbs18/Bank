package academy.mindswap;

import academy.mindswap.bank.Bank;
import academy.mindswap.client.Client;
import com.sun.security.jgss.GSSUtil;

public class Main {

    public static void main(String[] args){

        Client joao = new Client();
        Client henrique = new Client();
        Bank bank1 = new Bank();
        Bank bank2 = new Bank();

        joao.setBank(bank1);
        joao.askForId();

        joao.createAccount("debit");
        joao.createAccount("credit");

        joao.askForCard("debit");
        joao.askForCard("credit");


        System.out.println();
        System.out.println("----------------");
        System.out.println();

        joao.setBank(bank2);
        joao.askForId();

        joao.createAccount("debit");
        joao.createAccount("credit");

        joao.askForCard("debit");
        joao.askForCard("credit");


    }
}
