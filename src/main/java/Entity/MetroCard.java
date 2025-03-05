package Entity;

public class MetroCard {

    private final String cardId;
    private int balance;

    public MetroCard(String cardId, int balance) {
        this.cardId = cardId;
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCardId() {
        return cardId;
    }

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {

        if(balance < amount)
            return false;

        balance -= amount;
        return true;
    }
}
