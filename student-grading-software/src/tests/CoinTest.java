package tests;

import model.Coin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CoinTest {
    private Coin myCoin;

    @Before
    public void setUp(){
        myCoin=new Coin();
    }

    @Test
    public void testFlipHeadsAndTails(){
        boolean never = true;
        for (int i = 0; i < 10; ++i){
            myCoin.flip();
            if (myCoin.checkStatus().equals("tail")){
                never = false;
            }
        }

        assertFalse(never);
    }
}
