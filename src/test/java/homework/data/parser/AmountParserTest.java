package homework.data.parser;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class AmountParserTest {
    
    private Parser<Integer> parser;
    
    @Before
    public void setup() {
        parser = new AmountParser();
        
    }
    
    @Test
    public void testValidInput(){
        
        Integer result = parser.parse("123");
        Assert.assertEquals((Integer) 123, result);
        
    }
    
    @Test
    public void testValidNegativeInput(){
        
        Integer result = parser.parse("-321");
        Assert.assertEquals((Integer) (-321), result);
        
    }
    
    @Test
    public void testVariousWrongInputs(){
        
        Integer result = parser.parse("a");
        Assert.assertNull(result);
        
        result = parser.parse(null);
        Assert.assertNull(result);
        
        result = parser.parse("" + ((long)Integer.MAX_VALUE+1));
        Assert.assertNull(result);
        
        result = parser.parse("" + ((long)Integer.MIN_VALUE-1));
        Assert.assertNull(result);
        
    }

}
