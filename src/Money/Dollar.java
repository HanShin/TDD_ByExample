package Money;

/**
 * Created by shin on 2016. 12. 28..
 */
public class Dollar {
    int amount;
    Dollar(int amount){
        this.amount = amount;
    }

    Dollar times(int multiplier){

        return new Dollar( amount * multiplier);
    }
}
