package academy.mindswap.account;

import static academy.mindswap.util.Messages.*;

public class Debit implements Account{

    private int balance;

    @Override
    public void withdraw(int amount) {
        if(balance - amount >= 0){
            balance -= amount;
            System.out.println(WITHDRAW + amount);
            return;
        }
        System.out.println(NOT_ENOUGH_WITHDRAW);
    }

    @Override
    public void deposit(int amount) {this.balance += amount;}

    @Override
    public void pay(int amount) {
        if(balance - amount >= 0){
            balance -= amount;
            System.out.println(PAYMENT + amount);
            return;
        }
        System.out.println(NOT_ENOUGH_PAY);
    }

    @Override
    public int getBalance() {
        return this.balance;
    }
}
