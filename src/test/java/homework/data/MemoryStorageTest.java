package homework.data;

import java.util.Currency;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemoryStorageTest {
    
    @Before
    public void setup() {
        MemoryStorage.getInstance().removeAll();
    }
    
    @Test
    public void singleEntryTest(){
        MemoryStorage.getInstance().save(Currency.getInstance("CZK"), 100);
        
        Assert.assertEquals(1, MemoryStorage.getInstance().readAll().size());
        
        Assert.assertEquals((Integer) 100, 
                MemoryStorage.getInstance().readAll().get(Currency.getInstance("CZK")).get(0));
        
    }
    
    @Test
    public void multipleEntriesTest(){
        Currency czk = Currency.getInstance("CZK");
        Currency eur = Currency.getInstance("EUR");
        Currency usd = Currency.getInstance("USD");
        
        MemoryStorage.getInstance().save(czk, 100);
        
        MemoryStorage.getInstance().save(eur, 10);
        MemoryStorage.getInstance().save(eur, 5);
        MemoryStorage.getInstance().save(eur, 10);
        MemoryStorage.getInstance().save(eur, -10);
        
        MemoryStorage.getInstance().save(usd, -50);
        
        Assert.assertEquals(3, MemoryStorage.getInstance().readAll().size());
        
        Assert.assertEquals((Integer) 100, 
                MemoryStorage.getInstance().readAll().get(Currency.getInstance("CZK"))
                    .stream().reduce(Integer::sum).get());
        
        Assert.assertEquals((Integer) 15, 
                MemoryStorage.getInstance().readAll().get(Currency.getInstance("EUR"))
                    .stream().reduce(Integer::sum).get());
        
        Assert.assertEquals((Integer) (-50), 
                MemoryStorage.getInstance().readAll().get(Currency.getInstance("USD"))
                    .stream().reduce(Integer::sum).get());
        
    }

}
