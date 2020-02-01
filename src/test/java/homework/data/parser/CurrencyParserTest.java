package homework.data.parser;

import java.util.Currency;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class CurrencyParserTest {
    
    private Parser<Currency> parser;
    
    @Before
    public void setup() {
        parser = new CurrencyParser();
        
    }
    
    @Test
    public void testValidInput(){
        
        Currency result = parser.parse("CZK");
        Assert.assertEquals(Currency.getInstance("CZK"), result);
        
    }
    
    @Test
    public void testWrongInput(){
        
        Currency result = parser.parse("CZKa");
        Assert.assertNull(result);
        
    }
    
    @Test
    public void testWrongInputEmpty(){
        
        Currency result = parser.parse("");
        Assert.assertNull(result);
        
    }
    
    @Test
    public void testWrongInputNull(){
        
        Currency result = parser.parse(null);
        Assert.assertNull(result);
        
    }

}
