import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

public class MainTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test(expected = NumberFormatException.class)
    public void testEmptyString() {
        Integer.decode("");
        exceptionRule.expectMessage("Zero length string");
    }

    @Test(expected = NumberFormatException.class)
    public void testStringWord(){
        Integer.decode("gamedev");
    }

    @Test(expected = NullPointerException.class)
    public void testNull(){
        Integer.decode(null);
    }

    @Test
    public void testNegative(){
        Assert.assertEquals(-9, Integer.decode("-9").longValue());
    }

    @Test
    public void testPositive(){
        Assert.assertEquals(2, Integer.decode("+2").longValue());
    }

    @Test
    public void testHexFormat(){
        assertEquals(4779, Integer.decode("0x12AB"));
        assertEquals(-0Xa90,Integer.decode("-0Xa90"));
        assertEquals(4095,Integer.decode("#fff"));
        assertEquals(-2580,Integer.decode("-#A14"));
    }


    @Test
    public void testOctalFormat(){
        assertEquals(34,Integer.decode("042"));
        assertEquals(-34,Integer.decode("-042"));
    }

    @Test
    public void testDecimalNumeral(){
        assertEquals(197,Integer.decode("197"));
        assertEquals(-197,Integer.decode("-197"));
        assertEquals(0,Integer.decode("0"));
    }

    @Test(expected = NumberFormatException.class)
    public void testDouble(){
        Integer.decode("234.5");
    }

    @Test(expected = NumberFormatException.class)
    public void testSignBetweenNum() {
        Integer.decode("24-9");
    }

    @Test(expected = NumberFormatException.class)
    public void testSpaces() {
        Integer.decode("- 82");
    }

    @Test(expected = NumberFormatException.class)
    public void testNumSpaces() {
        Integer.decode("12 1");
    }


    @Test
    public void testIntMinValue(){
        Assert.assertEquals(Integer.MIN_VALUE, Integer.decode("-2147483648").longValue());
    }

    @Test
    public void testIntMaxValue(){
        Assert.assertEquals(Integer.MAX_VALUE, Integer.decode("2147483647").longValue());
    }



}