package academy.mindswap.account;

public interface Account {

    void withdraw(int amount);
    void deposit(int amount);
    void pay(int amount);
    int getBalance();
}
