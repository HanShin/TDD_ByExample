package Money;

/**
 * Created by shin on 2016. 12. 29..
 */
public class Money {
    protected int amount;

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount;
    }
}
