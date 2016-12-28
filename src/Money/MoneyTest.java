package Money;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by shin on 2016. 12. 28..
 */
@Test
public class MoneyTest {

    public void testMultiplication(){
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals( 15, product.amount);
    }

}
