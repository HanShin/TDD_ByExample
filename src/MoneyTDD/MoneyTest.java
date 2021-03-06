package MoneyTDD;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

/**
 * Created by shin on 2016. 12. 28..
 */
@Test
public class MoneyTest {

    public void testMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    public void testFranMultiplication(){
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    public void testPlusReturnsSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum)result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1),result);
    }

    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF","USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

//    public void testArrayEquals(){
//        assertEquals(new Object[] {"abc"}, new Object[]{"abc"});
//    }

    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    public void testMixedAddtion(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenfrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);

        Money result = bank.reduce(fiveBucks.plus(tenfrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    public void testSumPlusMoney(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenfrancs = Money.franc(10);

        Bank bank = new Bank();
        bank.addRate("CHF","USD",2);
        Expression sum = new Sum(fiveBucks,tenfrancs).plus((fiveBucks));
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);

    }

    public void testSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenfrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks,tenfrancs).times(2);
        Money result = bank.reduce(sum,"USD");
        assertEquals(Money.dollar(20), result);
    }

//
//        Expression sum = Money.dollar(1).plus(Money.dollar(1));
//        assertTrue(sum instanceof Money);
//    }
}
