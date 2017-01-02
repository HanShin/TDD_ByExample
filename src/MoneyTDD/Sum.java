package MoneyTDD;

/**
 * Created by shin on 2017. 1. 2..
 */
public class Sum implements Expression{
    Money augend;
    Money addend;

    Sum (Money augend, Money addend){

    }

    public Money reduce(String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.amount + addend.amount;
        return new Money (amount, to);
    }
}
