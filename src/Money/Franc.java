package Money;

/**
 * Created by shin on 2016. 12. 29..
 */
public class Franc extends Money {
    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }
}
