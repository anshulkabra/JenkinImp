package org.uitestingespresso;

import org.junit.Test;
import org.uitestingespresso.utils.Utils;

import static junit.framework.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void emailValidateTest(){
        boolean actual= Utils.isValidEmail("sachin@gmail.com");
        boolean expected=true;
        assertEquals("entered email is false",expected,actual);

    }


    @Test
    public void passwordValidateTest(){
        boolean actual= Utils.isValidPassword("Sachin@123");
        boolean expected=true;
        assertEquals("entered email is false",expected,actual);

    }
}