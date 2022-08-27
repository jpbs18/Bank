package academy.mindswap.account;

import static academy.mindswap.util.Messages.*;

public class Credit implements Account {

    private int balance;
    private final int rate = 5;

    @Override
    public void withdraw(int amount) {
        System.out.println(IMPOSSIBLE_WITHDRAWAL);
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
        else if(balance - amount < 0 && balance - amount > -95){
            balance -= amount - rate;
            System.out.println(PAYMENT + amount + RATE + rate);
            return;
        }
        System.out.println(NOT_ENOUGH_PAY);
    }

    @Override
    public int getBalance() {
        return this.balance;
    }
}
